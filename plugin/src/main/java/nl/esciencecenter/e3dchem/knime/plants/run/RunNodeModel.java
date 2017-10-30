package nl.esciencecenter.e3dchem.knime.plants.run;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.collection.ListCell;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;

import nl.esciencecenter.e3dchem.knime.plants.Activator;
import nl.esciencecenter.e3dchem.knime.plants.PlantsPreferencePage;

public class RunNodeModel extends NodeModel {
    private RunNodeConfig config = new RunNodeConfig();

    public RunNodeModel() {
        super(1, 1);
    }

    @Override
    protected DataTableSpec[] configure(DataTableSpec[] inSpecs) throws InvalidSettingsException {
        DataTableSpec appendedSpec = createOutputSpec();
        DataTableSpec outputSpec = new DataTableSpec(inSpecs[0], appendedSpec);
        return new DataTableSpec[] { outputSpec };
    }

    @Override
    protected BufferedDataTable[] execute(BufferedDataTable[] inData, ExecutionContext exec) throws Exception {
        String executable = Activator.getDefault().getPreferenceStore().getString(PlantsPreferencePage.PLANTS_EXECUTABLE);
        BufferedDataTable inTable = inData[0];
        DataTableSpec inSpec = inTable.getSpec();
        int modeIndex = inSpec.findColumnIndex(config.getModeColumn().getStringValue());
        int argumentsIndex = inSpec.findColumnIndex(config.getArgumentsColumn().getStringValue());
        int workingDirectoryIndex = inSpec.findColumnIndex(config.getWorkingDirectoryColumn().getStringValue());
        BufferedDataContainer container = exec.createDataContainer(createOutputSpec());
        long rowCount = inTable.size();
        long currentRow = 0;
        for (DataRow inRow : inTable) {
            String mode = ((StringCell) inRow.getCell(modeIndex)).getStringValue();
            ListCell argumentsCell = ((ListCell) inRow.getCell(argumentsIndex));
            List<String> arguments = StreamSupport.stream(argumentsCell.spliterator(), false)
                    .map(c -> ((StringCell) c).getStringValue()).collect(Collectors.toList());
            File workingDirectory = new File(((StringCell) inRow.getCell(workingDirectoryIndex)).getStringValue());
            DataRow row = process(inRow.getKey(), workingDirectory, executable, mode, arguments, exec);
            container.addRowToTable(row);
            exec.checkCanceled();
            exec.setProgress(0.9 * currentRow / rowCount, " processing row " + currentRow);
            currentRow++;
        }

        container.close();
        BufferedDataTable outTable = container.getTable();
        BufferedDataTable out = exec.createJoinedTable(inTable, outTable, exec.createSubProgress(0.1));
        return new BufferedDataTable[] { out };
    }

    public DataRow process(RowKey rowKey, File workingDirectory, String executable, String mode, List<String> arguments,
            ExecutionContext context)
            throws IOException, InterruptedException, CanceledExecutionException {
        List<String> commands = new ArrayList<>();
        commands.add(executable);
        commands.add("--mode");
        commands.add(mode);
        for (String argument : arguments) {
            commands.add(argument);
        }
        File stderr = new File(workingDirectory, "stderr.txt");
        File stdout = new File(workingDirectory, "stdout.txt");
        Process process = new ProcessBuilder(commands).directory(workingDirectory).redirectError(stderr).redirectOutput(stdout)
                .start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            process.destroy();
            throw e;
        }
        int exitCode = process.exitValue();
        if (exitCode != 0) {
            setWarningMessage("Some rows failed to run correctly");
        }
        return new DefaultRow(rowKey, new IntCell(exitCode));
    }

    @Override
    protected void loadInternals(File nodeInternDir, ExecutionMonitor exec) throws IOException, CanceledExecutionException {
        // No internals to load
    }

    @Override
    protected void saveInternals(File nodeInternDir, ExecutionMonitor exec) throws IOException, CanceledExecutionException {
        // No internals to save
    }

    @Override
    protected void saveSettingsTo(NodeSettingsWO settings) {
        config.saveSettingsTo(settings);
    }

    @Override
    protected void validateSettings(NodeSettingsRO settings) throws InvalidSettingsException {
        config.validateSettings(settings);
    }

    @Override
    protected void loadValidatedSettingsFrom(NodeSettingsRO settings) throws InvalidSettingsException {
        config.loadValidatedSettingsFrom(settings);
    }

    @Override
    protected void reset() {
        // No internals to reset
    }

    private DataTableSpec createOutputSpec() {
        return new DataTableSpec(new DataColumnSpecCreator("exit code", IntCell.TYPE).createSpec());
    }
}
