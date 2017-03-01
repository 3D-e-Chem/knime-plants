package nl.esciencecenter.e3dchem.knime.plants.execute;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.knime.core.data.DataTableSpec;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;

import nl.esciencecenter.e3dchem.knime.plants.Activator;

public class ExecuteModel extends NodeModel {
	private ExecuteConfig config = new ExecuteConfig();

	protected ExecuteModel() {
		super(0, 0);
	}

	@Override
	protected BufferedDataTable[] execute(BufferedDataTable[] inData, ExecutionContext exec) throws Exception {
		String executable = Activator.getDefault().getPreferenceStore().getString("EXECUTABLE");
		List<String> commands = new ArrayList<>();
		commands.add(executable);
		commands.add("--mode");
		commands.add(config.arguments.getStringValue());
		File workingDirectory = new File(config.workingDirectory.getStringValue());
		Process process = new ProcessBuilder(commands).directory(workingDirectory).inheritIO().start();
		process.waitFor();
		return new BufferedDataTable[] {};
	}

	@Override
	protected DataTableSpec[] configure(DataTableSpec[] inSpecs) throws InvalidSettingsException {
		return new DataTableSpec[]{};
	}

	@Override
	protected void loadInternals(File nodeInternDir, ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void saveInternals(File nodeInternDir, ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
