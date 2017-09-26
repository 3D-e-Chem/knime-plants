package nl.esciencecenter.e3dchem.knime.plants.configure;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

import org.junit.BeforeClass;
import org.junit.Test;

import nl.esciencecenter.e3dchem.knime.plants.configure.ConfigureDialog;
import nl.esciencecenter.e3dchem.knime.plants.configure.ConfigureFactory;

public class ConfigureDialogTest {

    @BeforeClass
    public static void setUp() {
        assumeFalse("Does not work on Windows", System.getProperty("os.name").contains("Windows"));
    }

    @Test
	public void test() {
		ConfigureFactory factory = new ConfigureFactory();		
		ConfigureDialog dialog = (ConfigureDialog) factory.createNodeDialogPane();
		
		int result = dialog.getPanel().getComponentCount();
		assertEquals(2, result);
	}
}
