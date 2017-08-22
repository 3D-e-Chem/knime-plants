package nl.esciencecenter.e3dchem.knime.plants;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PlantsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	public static final String PLANTS_EXECUTABLE = "PLANTS_EXECUTABLE";

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences for 3D-e-Chem PLANTS nodes");
	}

	@Override
	protected void createFieldEditors() {
        StringFieldEditor executableField = new ExecutableFieldEditor(PLANTS_EXECUTABLE, "Path of PLANTS executable", false,
                getFieldEditorParent());
		addField(executableField);
	}
}
