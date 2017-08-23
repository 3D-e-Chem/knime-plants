package nl.esciencecenter.e3dchem.knime.plants.configure;

import java.util.HashMap;
import java.util.Map;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
import org.knime.core.node.defaultnodesettings.SettingsModelDouble;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelNumber;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

public class ConfigureConfig {
    // search algorithm
    public SettingsModelStringSet search_speed = new SettingsModelStringSet("search_speed", "speed1", "speed1", "speed2",
            "speed4");
    public SettingsModelNumber aco_ants = new SettingsModelInteger("aco_ants", 20);
    public SettingsModelBoolean flip_amide_bonds = new SettingsModelBoolean("flip_amide_bonds", false);
    public SettingsModelBoolean flip_planar_n = new SettingsModelBoolean("flip_planar_n", true);
    public SettingsModelBoolean force_flipped_bonds_planarity = new SettingsModelBoolean("force_flipped_bonds_planarity", false);
    public SettingsModelBoolean force_planar_bond_rotation = new SettingsModelBoolean("force_planar_bond_rotation", true);
    public SettingsModelBoolean rescore_simplex = new SettingsModelBoolean("rescore_simplex", true);
    public SettingsModelBoolean flip_ring_corners = new SettingsModelBoolean("flip_ring_corners", false);

    // binding site
    public SettingsModelNumber bindingsite_center_x = new SettingsModelDouble("bindingsite_center_x", 0.0);
    public SettingsModelNumber bindingsite_center_y = new SettingsModelDouble("bindingsite_center_y", 0.0);
    public SettingsModelNumber bindingsite_center_z = new SettingsModelDouble("bindingsite_center_z", 0.0);
    public SettingsModelNumber bindingsite_radius = new SettingsModelDouble("bindingsite_radius", 1.0);
    // cluster algorithm
    public SettingsModelNumber cluster_rmsd = new SettingsModelDouble("cluster_rmsd", 2.0);
    public SettingsModelNumber cluster_structures = new SettingsModelInteger("cluster_structures", 10);
    // scoring functions
    // Intermolecular (protein-ligand interaction scoring)
    public SettingsModelStringSet scoring_function = new SettingsModelStringSet("scoring_function", "chemplp", "chemplp", "plp",
            "plp95");
    public SettingsModelNumber outside_binding_site_penalty = new SettingsModelDouble("outside_binding_site_penalty", 50.0);
    public SettingsModelBoolean enable_sulphur_acceptors = new SettingsModelBoolean("enable_sulphur_acceptors", false);
    // Intramolecular ligand scoring
    public SettingsModelStringSet ligand_intra_score = new SettingsModelStringSet("ligand_intra_score", "clash2", "clash",
            "clash2", "lj");
    public SettingsModelBoolean chemplp_clash_include_14 = new SettingsModelBoolean("chemplp_clash_include_14", true);
    public SettingsModelBoolean chemplp_clash_include_HH = new SettingsModelBoolean("chemplp_clash_include_HH", false);
    // input
    public SettingsModelString protein_file = new SettingsModelString("protein_file", "protein.mol2");
    public SettingsModelString ligand_file = new SettingsModelString("ligand_file", "ligands.mol2");
    // output
    public SettingsModelString output_dir = new SettingsModelString("output_dir", "results");
    public SettingsModelBoolean write_protein_conformations = new SettingsModelBoolean("write_protein_conformations", true);
    public SettingsModelBoolean write_protein_bindingsite = new SettingsModelBoolean("write_protein_bindingsite", true);
    public SettingsModelBoolean write_protein_splitted = new SettingsModelBoolean("write_protein_splitted", true);
    public SettingsModelBoolean write_multi_mol2 = new SettingsModelBoolean("write_multi_mol2", true);
    public SettingsModelBoolean write_ranking_links = new SettingsModelBoolean("write_ranking_links", false);
    public SettingsModelBoolean write_merged_protein = new SettingsModelBoolean("write_merged_protein", false);

    public void saveSettingsTo(final NodeSettingsWO settings) {
        // search algorithm
        search_speed.saveSettingsTo(settings);
        aco_ants.saveSettingsTo(settings);
        flip_amide_bonds.saveSettingsTo(settings);
        flip_planar_n.saveSettingsTo(settings);
        force_flipped_bonds_planarity.saveSettingsTo(settings);
        force_planar_bond_rotation.saveSettingsTo(settings);
        rescore_simplex.saveSettingsTo(settings);
        flip_ring_corners.saveSettingsTo(settings);
        // binding site
        bindingsite_center_x.saveSettingsTo(settings);
        bindingsite_center_y.saveSettingsTo(settings);
        bindingsite_center_z.saveSettingsTo(settings);
        bindingsite_radius.saveSettingsTo(settings);
        // cluster algorithm
        cluster_rmsd.saveSettingsTo(settings);
        cluster_structures.saveSettingsTo(settings);
        // scoring functions
        scoring_function.saveSettingsTo(settings);
        outside_binding_site_penalty.saveSettingsTo(settings);
        enable_sulphur_acceptors.saveSettingsTo(settings);
        ligand_intra_score.saveSettingsTo(settings);
        chemplp_clash_include_14.saveSettingsTo(settings);
        chemplp_clash_include_HH.saveSettingsTo(settings);
        // input
        protein_file.saveSettingsTo(settings);
        ligand_file.saveSettingsTo(settings);
        // output
        output_dir.saveSettingsTo(settings);
        write_protein_conformations.saveSettingsTo(settings);
        write_protein_bindingsite.saveSettingsTo(settings);
        write_protein_splitted.saveSettingsTo(settings);
        write_multi_mol2.saveSettingsTo(settings);
        write_ranking_links.saveSettingsTo(settings);
        write_merged_protein.saveSettingsTo(settings);
    }

    public void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
        // search algorithm
        search_speed.loadSettingsFrom(settings);
        aco_ants.loadSettingsFrom(settings);
        flip_amide_bonds.loadSettingsFrom(settings);
        flip_planar_n.loadSettingsFrom(settings);
        force_flipped_bonds_planarity.loadSettingsFrom(settings);
        force_planar_bond_rotation.loadSettingsFrom(settings);
        rescore_simplex.loadSettingsFrom(settings);
        flip_ring_corners.loadSettingsFrom(settings);
        // binding site
        bindingsite_center_x.loadSettingsFrom(settings);
        bindingsite_center_y.loadSettingsFrom(settings);
        bindingsite_center_z.loadSettingsFrom(settings);
        bindingsite_radius.loadSettingsFrom(settings);
        // cluster algorithm
        cluster_rmsd.loadSettingsFrom(settings);
        cluster_structures.loadSettingsFrom(settings);
        // scoring functions
        scoring_function.loadSettingsFrom(settings);
        outside_binding_site_penalty.loadSettingsFrom(settings);
        enable_sulphur_acceptors.loadSettingsFrom(settings);
        ligand_intra_score.loadSettingsFrom(settings);
        chemplp_clash_include_14.loadSettingsFrom(settings);
        chemplp_clash_include_HH.loadSettingsFrom(settings);
        // input
        protein_file.loadSettingsFrom(settings);
        ligand_file.loadSettingsFrom(settings);
        // output
        output_dir.loadSettingsFrom(settings);
        write_protein_conformations.loadSettingsFrom(settings);
        write_protein_bindingsite.loadSettingsFrom(settings);
        write_protein_splitted.loadSettingsFrom(settings);
        write_multi_mol2.loadSettingsFrom(settings);
        write_ranking_links.loadSettingsFrom(settings);
        write_merged_protein.loadSettingsFrom(settings);
    }

    public void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
        // search algorithm
        search_speed.validateSettings(settings);
        aco_ants.validateSettings(settings);
        flip_amide_bonds.validateSettings(settings);
        flip_planar_n.validateSettings(settings);
        force_flipped_bonds_planarity.validateSettings(settings);
        force_planar_bond_rotation.validateSettings(settings);
        rescore_simplex.validateSettings(settings);
        flip_ring_corners.validateSettings(settings);
        // binding site
        bindingsite_center_x.validateSettings(settings);
        bindingsite_center_y.validateSettings(settings);
        bindingsite_center_z.validateSettings(settings);
        bindingsite_radius.validateSettings(settings);
        // cluster algorithm
        cluster_rmsd.validateSettings(settings);
        cluster_structures.validateSettings(settings);
        // scoring functions
        scoring_function.validateSettings(settings);
        outside_binding_site_penalty.validateSettings(settings);
        enable_sulphur_acceptors.validateSettings(settings);
        ligand_intra_score.validateSettings(settings);
        chemplp_clash_include_14.validateSettings(settings);
        chemplp_clash_include_HH.validateSettings(settings);
        // input
        protein_file.validateSettings(settings);
        ligand_file.validateSettings(settings);
        // output
        output_dir.validateSettings(settings);
        write_protein_conformations.validateSettings(settings);
        write_protein_bindingsite.validateSettings(settings);
        write_protein_splitted.validateSettings(settings);
        write_multi_mol2.validateSettings(settings);
        write_ranking_links.validateSettings(settings);
        write_merged_protein.validateSettings(settings);
    }

    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // search algorithm
        map.put("search_speed", search_speed.getStringValue());
        map.put("aco_ants", ((SettingsModelInteger) aco_ants).getIntValue());
        map.put("flip_amide_bonds", flip_amide_bonds.getBooleanValue() ? "1" : "0");
        map.put("flip_planar_n", flip_planar_n.getBooleanValue() ? "1" : "0");
        map.put("force_flipped_bonds_planarity", force_flipped_bonds_planarity.getBooleanValue() ? "1" : "0");
        map.put("force_planar_bond_rotation", force_planar_bond_rotation.getBooleanValue() ? "1" : "0");
        map.put("rescore_mode", rescore_simplex.getBooleanValue() ? "simplex" : "no_simplex");
        map.put("flip_ring_corners", flip_ring_corners.getBooleanValue() ? "1" : "0");
        // binding site
        map.put("bindingsite_center_x", ((SettingsModelDouble) bindingsite_center_x).getDoubleValue());
        map.put("bindingsite_center_y", ((SettingsModelDouble) bindingsite_center_y).getDoubleValue());
        map.put("bindingsite_center_z", ((SettingsModelDouble) bindingsite_center_z).getDoubleValue());
        map.put("bindingsite_radius", ((SettingsModelDouble) bindingsite_radius).getDoubleValue());
        // cluster algorithm
        map.put("cluster_rmsd", ((SettingsModelDouble) cluster_rmsd).getDoubleValue());
        map.put("cluster_structures", ((SettingsModelInteger) cluster_structures).getIntValue());
        // scoring functions
        map.put("scoring_function", scoring_function.getStringValue());
        map.put("outside_binding_site_penalty", ((SettingsModelDouble) outside_binding_site_penalty).getDoubleValue());
        map.put("enable_sulphur_acceptors", enable_sulphur_acceptors.getBooleanValue() ? "1" : "0");
        map.put("ligand_intra_score", ligand_intra_score.getStringValue());
        map.put("chemplp_clash_include_14", chemplp_clash_include_14.getBooleanValue() ? "1" : "0");
        map.put("chemplp_clash_include_HH", chemplp_clash_include_HH.getBooleanValue() ? "1" : "0");
        // input
        map.put("protein_file", protein_file.getStringValue());
        map.put("ligand_file", ligand_file.getStringValue());
        // output
        map.put("output_dir", output_dir.getStringValue());
        map.put("write_protein_conformations", write_protein_conformations.getBooleanValue() ? "1" : "0");
        map.put("write_protein_bindingsite", write_protein_bindingsite.getBooleanValue() ? "1" : "0");
        map.put("write_protein_splitted", write_protein_splitted.getBooleanValue() ? "1" : "0");
        map.put("write_multi_mol2", write_multi_mol2.getBooleanValue() ? "1" : "0");
        map.put("write_ranking_links", write_ranking_links.getBooleanValue() ? "1" : "0");
        map.put("write_merged_protein", write_merged_protein.getBooleanValue() ? "1" : "0");
        return map;
    }
}
