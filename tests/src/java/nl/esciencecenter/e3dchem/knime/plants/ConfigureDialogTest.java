package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigureDialogTest {

	@Test
	public void test() {
		ConfigureDialog dialog = new ConfigureDialog();
		assertTrue(dialog.getPanel().getComponentCount() > 6);
	}
}
