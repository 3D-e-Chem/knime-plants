package nl.esciencecenter.e3dchem.knime.plants.configure;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettings;

import nl.esciencecenter.e3dchem.knime.plants.configure.ConfigureConfig;

public class ConfigureConfigTest {
	private ConfigureConfig config;
	
	@Before
	public void setUp() {
		config = new ConfigureConfig();
	}
	

	@Test
	public void test_defaults() {
		assertEquals("chemplp", config.scoring_function.getStringValue());
		// TODO check more fields
	}

	@Test
	public void test_asMap_defaults() {
		Map<String, Object> result = config.asMap();
		Map<String, Object> expected = new HashMap<String, Object>();		
		expected.put("bindingsite_center_x", 0.0);
		expected.put("bindingsite_center_z", 0.0);
		expected.put("cluster_rmsd", 2.0);
		expected.put("bindingsite_center_y", 0.0);
		expected.put("search_speed", "speed1");
		expected.put("cluster_structures", 10);
		expected.put("write_multi_mol2", true);
		expected.put("write_merged_protein", false);
		expected.put("scoring_function", "chemplp");
		expected.put("write_ranking_links", false);
		expected.put("protein_file", "protein.mol2");
		expected.put("write_protein_conformations", true);
		expected.put("output_dir", "results");
		expected.put("ligand_file", "ligands.mol2");
		expected.put("bindingsite_radius", 1.0);
		expected.put("write_protein_bindingsite", true);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void test_validateSettings() {
		NodeSettings settings = new NodeSettings("settings");
		settings.addDouble("bindingsite_center_x", 0.0);
		settings.addDouble("bindingsite_center_z", 0.0);
		settings.addDouble("cluster_rmsd", 2.0);
		settings.addDouble("bindingsite_center_y", 0.0);
		settings.addString("search_speed", "speed1");
		settings.addInt("cluster_structures", 10);
		settings.addBoolean("write_multi_mol2", true);
		settings.addBoolean("write_merged_protein", false);
		settings.addString("scoring_function", "chemplp");
		settings.addBoolean("write_ranking_links", false);
		settings.addString("protein_file", "protein.mol2");
		settings.addBoolean("write_protein_conformations", true);
		settings.addString("output_dir", "results");
		settings.addString("ligand_file", "ligands.mol2");
		settings.addDouble("bindingsite_radius", 1.0);
		settings.addBoolean("write_protein_bindingsite", true);

		try {
			config.validateSettings(settings);
		} catch (InvalidSettingsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_saveSettingsTo() throws InvalidSettingsException {
		NodeSettings settings = new NodeSettings("settings");
		
		config.saveSettingsTo(settings);
		
		assertEquals(2.0, settings.getDouble("cluster_rmsd"), 0.01);
		// TODO check other fields
	}
}
