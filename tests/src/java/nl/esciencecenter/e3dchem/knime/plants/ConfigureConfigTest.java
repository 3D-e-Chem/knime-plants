package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ConfigureConfigTest {

	@Test
	public void test_defaults() {
		ConfigureConfig config = new ConfigureConfig();

		assertEquals("chemplp", config.scoring_function.getStringValue());
	}

	@Test
	public void test_asMap_defaults() {
		ConfigureConfig config = new ConfigureConfig();

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
		expected.put("protein_file", null);
		expected.put("write_protein_conformations", true);
		expected.put("output_dir", "results");
		expected.put("ligand_file", null);
		expected.put("bindingsite_radius", 1.0);
		expected.put("write_protein_bindingsite", true);
		
		assertEquals(expected, result);
	}
}
