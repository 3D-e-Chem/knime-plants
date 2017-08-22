package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.*;

import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.Test;

public class PreferenceInitializerTest {

	@Test
	public void testInitializeDefaultPreferences() {
		PreferenceInitializer initializer = new PreferenceInitializer();
		initializer.initializeDefaultPreferences();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		String path = store.getString(PlantsPreferencePage.PLANTS_EXECUTABLE);

		assertTrue(path.startsWith("PLANTS"));
	}
}
