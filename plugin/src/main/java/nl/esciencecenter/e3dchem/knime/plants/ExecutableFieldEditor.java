package nl.esciencecenter.e3dchem.knime.plants;

import java.io.IOException;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class ExecutableFieldEditor extends FileFieldEditor {

	public ExecutableFieldEditor(String name, String labelText, boolean enforceAbsolute, Composite parent) {
		super(name, labelText, enforceAbsolute, parent);
		this.setEmptyStringAllowed(false);
	}

	@Override
	protected boolean checkState() {
		if (this.getStringValue() != null && this.getStringValue().length() > 0) {
			try {
                new ProcessBuilder().command(this.getStringValue()).start().waitFor();
				// Not interested in exitCode, just want to know if it can be
				// executed
				clearErrorMessage();
				return true;
			} catch (IOException e) {
				showErrorMessage(e.getMessage());
				return false;
			} catch (InterruptedException e) {
				showErrorMessage(e.getMessage());
                // Restore interrupted state...
                Thread.currentThread().interrupt();
				return false;
			}
		} else {
			showErrorMessage("Can not be empty");
			return false;
		}
	}
}
