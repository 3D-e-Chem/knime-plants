package nl.esciencecenter.e3dchem.knime.plants.run;

import org.knime.core.data.StringValue;
import org.knime.core.data.collection.ListDataValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;

public class RunNodeDialog extends DefaultNodeSettingsPane {

    @SuppressWarnings("unchecked")
    public RunNodeDialog() {
		super();
		RunNodeConfig config = new RunNodeConfig();

        addDialogComponent(new DialogComponentColumnNameSelection(config.getModeColumn(), "Mode", 0, StringValue.class));
		addDialogComponent(
                new DialogComponentColumnNameSelection(config.getArgumentsColumn(), "Arguments", 0, ListDataValue.class));
        addDialogComponent(new DialogComponentColumnNameSelection(config.getWorkingDirectoryColumn(), "Working directory", 0,
				StringValue.class));
	}
}
