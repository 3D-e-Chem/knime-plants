package nl.esciencecenter.e3dchem.knime.plants;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;

/**
 * <code>NodeDialog</code> for the "Configure" Node.
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more
 * complex dialog please derive directly from
 * {@link org.knime.core.node.NodeDialogPane}.
 */
public class ConfigureDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring Configure node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    protected ConfigureDialog() {
        super();

        addDialogComponent(new DialogComponentNumber(
                new SettingsModelIntegerBounded(
                    ConfigureModel.CFGKEY_COUNT,
                    ConfigureModel.DEFAULT_COUNT,
                    Integer.MIN_VALUE, Integer.MAX_VALUE),
                    "Counter:", /*step*/ 1, /*componentwidth*/ 5));

    }
}
