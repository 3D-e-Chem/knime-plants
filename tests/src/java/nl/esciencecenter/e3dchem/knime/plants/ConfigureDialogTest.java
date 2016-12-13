package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigureDialogTest {

	@Test
	public void test() {
		ConfigureFactory factory = new ConfigureFactory();		
		ConfigureDialog dialog = (ConfigureDialog) factory.createNodeDialogPane();
		
		int result = dialog.getPanel().getComponentCount();
		assertEquals(2, result);
	}
}
