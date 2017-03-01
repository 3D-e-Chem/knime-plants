package nl.esciencecenter.e3dchem.knime.plants;

import java.io.IOException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class WorkbenchPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private FileFieldEditor executableField;

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences for 3D-e-Chem PLANTS nodes");
	}

	@Override
	protected void createFieldEditors() {
		executableField = new FileFieldEditor("EXECUTABLE", "Path of PLANTS executable", false, getFieldEditorParent());
		addField(executableField);
	}

	@Override
	protected void checkState() {
		super.checkState();
		if (executableField.getStringValue() != null
                && executableField.getStringValue().length() > 0) {
			try {
				new ProcessBuilder().command(executableField.getStringValue()).start().waitFor();
				setValid(true);
				setErrorMessage(null);
			} catch (IOException e) {
				setValid(false);
				setErrorMessage(e.getMessage());
			} catch (InterruptedException e) {
				setValid(false);
				setErrorMessage(e.getMessage());
			} 
		}
	}
}
