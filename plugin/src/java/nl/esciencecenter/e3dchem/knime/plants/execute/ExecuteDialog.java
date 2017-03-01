package nl.esciencecenter.e3dchem.knime.plants.execute;

import javax.swing.JFileChooser;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentFileChooser;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;

public class ExecuteDialog extends DefaultNodeSettingsPane {

	public ExecuteDialog() {
		super();
		ExecuteConfig config = new ExecuteConfig();
		
		addDialogComponent(new DialogComponentStringSelection(config.mode, "Mode", config.mode.getChoices()));
		addDialogComponent(new DialogComponentString(config.arguments, "Arguments"));
		addDialogComponent(new DialogComponentFileChooser(config.workingDirectory, "plantsWorkingDirectory", JFileChooser.DIRECTORIES_ONLY, true));
	}
}
