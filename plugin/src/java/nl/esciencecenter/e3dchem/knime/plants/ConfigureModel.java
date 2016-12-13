package nl.esciencecenter.e3dchem.knime.plants;

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
	ConfigureConfig config = new ConfigureConfig();
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
		// TODO Code executed on reset.
		// Models build during execute are cleared here.
		// Also data handled in load/saveInternals will be erased here.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
			throws InvalidSettingsException {

		// TODO: check if user settings are available, fit to the incoming
		// table structure, and the incoming types are feasible for the node
		// to execute. If the node can execute in its current state return
		// the spec of its output data table(s) (if you can, otherwise an array
		// with null elements), or throw an exception with a useful user message

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

		// TODO load internal data.
		// Everything handed to output ports is loaded automatically (data
		// returned by the execute method, models loaded in loadModelContent,
		// and user settings set through loadSettingsFrom - is all taken care
		// of). Load here only the other internals that need to be restored
		// (e.g. data used by the views).

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveInternals(final File internDir,
			final ExecutionMonitor exec) throws IOException,
			CanceledExecutionException {

		// TODO save internal models.
		// Everything written to output ports is saved automatically (data
		// returned by the execute method, models saved in the saveModelContent,
		// and user settings saved through saveSettingsTo - is all taken care
		// of). Save here only the other internals that need to be preserved
		// (e.g. data used by the views).
	}

}
