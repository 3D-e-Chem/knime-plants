package nl.esciencecenter.e3dchem.knime.plants.execute;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.knime.plants.SettingsModelStringSet;

public class ExecuteConfig {
	public SettingsModelStringSet mode = new SettingsModelStringSet("mode", "screen", "screen", "bind", "volume", "bindstat", "align", "rescorealign");
	public SettingsModelString arguments = new SettingsModelString("arguments", null);
	public SettingsModelString workingDirectory = new SettingsModelString("workingDirectory", null);
	public void saveSettingsTo(NodeSettingsWO settings) {
		mode.saveSettingsTo(settings);
		arguments.saveSettingsTo(settings);
		workingDirectory.saveSettingsTo(settings);
		
	}
	public void validateSettings(NodeSettingsRO settings) throws InvalidSettingsException {
		mode.validateSettings(settings);
		arguments.validateSettings(settings);
		workingDirectory.validateSettings(settings);
		
	}
	public void loadValidatedSettingsFrom(NodeSettingsRO settings) throws InvalidSettingsException {
		mode.loadSettingsFrom(settings);
		arguments.loadSettingsFrom(settings);
		workingDirectory.loadSettingsFrom(settings);
	}
}
