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
        expected.put("aco_ants", 20);
        expected.put("flip_amide_bonds", "0");
        expected.put("flip_planar_n", "1");
        expected.put("force_flipped_bonds_planarity", "0");
        expected.put("force_planar_bond_rotation", "1");
        expected.put("rescore_mode", "simplex");
        expected.put("flip_ring_corners", "0");
        expected.put("cluster_structures", 10);
        expected.put("write_multi_mol2", "1");
        expected.put("write_merged_protein", "0");
        expected.put("scoring_function", "chemplp");
        expected.put("outside_binding_site_penalty", 50.0);
        expected.put("enable_sulphur_acceptors", "0");
        expected.put("ligand_intra_score", "clash2");
        expected.put("chemplp_clash_include_14", "1");
        expected.put("chemplp_clash_include_HH", "0");
        expected.put("write_ranking_links", "0");
        expected.put("protein_file", "protein.mol2");
        expected.put("write_protein_conformations", "1");
        expected.put("write_protein_splitted", "1");
        expected.put("output_dir", "results");
        expected.put("ligand_file", "ligands.mol2");
        expected.put("bindingsite_radius", 1.0);
        expected.put("write_protein_bindingsite", "1");

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
        settings.addInt("aco_ants", 20);
        settings.addBoolean("flip_amide_bonds", false);
        settings.addBoolean("flip_planar_n", true);
        settings.addBoolean("force_flipped_bonds_planarity", false);
        settings.addBoolean("force_planar_bond_rotation", true);
        settings.addBoolean("rescore_simplex", true);
        settings.addBoolean("flip_ring_corners", false);
        settings.addInt("cluster_structures", 10);
        settings.addBoolean("write_multi_mol2", true);
        settings.addBoolean("write_merged_protein", false);
        settings.addString("scoring_function", "chemplp");
        settings.addDouble("outside_binding_site_penalty", 50.0);
        settings.addBoolean("enable_sulphur_acceptors", false);
        settings.addString("ligand_intra_score", "clash2");
        settings.addBoolean("chemplp_clash_include_14", true);
        settings.addBoolean("chemplp_clash_include_HH", false);
        settings.addBoolean("write_ranking_links", false);
        settings.addString("protein_file", "protein.mol2");
        settings.addBoolean("write_protein_conformations", true);
        settings.addBoolean("write_protein_splitted", true);
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
