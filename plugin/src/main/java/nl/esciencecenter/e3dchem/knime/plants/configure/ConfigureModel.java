package nl.esciencecenter.e3dchem.knime.plants.configure;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.container.CellFactory;
import org.knime.core.data.container.ColumnRearranger;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;


/**
 * This is the model implementation of Configure.
 *
 */
public class ConfigureModel extends NodeModel {
	private static final int IN_PORT = 0;
	private ConfigureConfig config = new ConfigureConfig();
	private Mustache mustache;
	private String templateFilename = "config.mustache";

	/**
	 * Constructor for the node model.
	 */
	protected ConfigureModel() {
		super(1, 1);
		MustacheFactory mf = new DefaultMustacheFactory();
		mustache = mf.compile(new InputStreamReader(getClass().getResourceAsStream(templateFilename)), templateFilename);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
			final ExecutionContext exec) throws Exception {
		Writer writer = new StringWriter();
		Map<String,Object> scope = config.asMap();
		mustache.execute(writer, scope).flush();
		String configBody = writer.toString();

		ColumnRearranger outputTable = new ColumnRearranger(inData[IN_PORT].getDataTableSpec());
		CellFactory cellFactory = new SingleStringCellFactory(createOutputColumnSpec() , configBody);
		outputTable.append(cellFactory);
		BufferedDataTable bufferedOutput = exec.createColumnRearrangeTable(
				inData[IN_PORT], outputTable, exec);
		return new BufferedDataTable[] { bufferedOutput };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void reset() {
        // Nothing to reset
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
			throws InvalidSettingsException {

        // checking inSpecs is not needed, 
        // each incoming row will be returned with an extra column with the PLANTS configuration

        DataTableSpec appendedSpec = createOutputSpec();
		DataTableSpec outputSpec = new DataTableSpec(
				inSpecs[IN_PORT], appendedSpec);

		return new DataTableSpec[]{ outputSpec };
	}

	private DataTableSpec createOutputSpec() {
		DataColumnSpec newColumnSpec = createOutputColumnSpec();
		return new DataTableSpec(newColumnSpec);
	}

	private DataColumnSpec createOutputColumnSpec() {
		DataColumnSpecCreator colSpecCreator = new DataColumnSpecCreator("PLANTS configuration", StringCell.TYPE);
		return colSpecCreator.createSpec();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) {
		config.saveSettingsTo(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
			throws InvalidSettingsException {
		config.loadValidatedSettingsFrom(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings)
			throws InvalidSettingsException {
		config.validateSettings(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadInternals(final File internDir,
			final ExecutionMonitor exec) throws IOException,
			CanceledExecutionException {
        // nothing to load
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveInternals(final File internDir,
			final ExecutionMonitor exec) throws IOException,
			CanceledExecutionException {
        // nothing to save
	}

}
