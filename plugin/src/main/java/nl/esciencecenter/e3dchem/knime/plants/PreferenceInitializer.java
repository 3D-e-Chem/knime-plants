package nl.esciencecenter.e3dchem.knime.plants;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		String path;
		if (System.getProperty("os.name").contains("Windows")) {
            path = findPathInBundle("/bin/PLANTS.exe");
		} else {
            path = findPathInBundle("/bin/PLANTS");
		}

        store.setDefault(PlantsPreferencePage.PLANTS_EXECUTABLE, path);
	}

	private String findPathInBundle(String path) {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
            URL url = FileLocator.find(bundle, new Path(path), null);
            if (url == null) {
                return "";
            }
            return FileLocator.toFileURL(url).getPath();
		} catch (IOException e) {
			return "";
		}
	}
}
