package nl.esciencecenter.e3dchem.knime.plants;

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
	public SettingsModelStringSet search_speed = new SettingsModelStringSet("search_speed", "speed1", "speed1",
			"speed2", "speed4");
	// binding site
	public SettingsModelNumber bindingsite_center_x = new SettingsModelDouble("bindingsite_center_x", 0.0);
	public SettingsModelNumber bindingsite_center_y = new SettingsModelDouble("bindingsite_center_y", 0.0);
	public SettingsModelNumber bindingsite_center_z = new SettingsModelDouble("bindingsite_center_z", 0.0);
	public SettingsModelNumber bindingsite_radius = new SettingsModelDouble("bindingsite_raduis", 1.0);
	// cluster algorithm
	public SettingsModelNumber cluster_rmsd = new SettingsModelDouble("cluster_rmsd", 2.0);
	public SettingsModelNumber cluster_structures = new SettingsModelInteger("cluster_structures", 10);
	// scoring functions
	public SettingsModelStringSet scoring_function = new SettingsModelStringSet("scoring_function", "chemplp",
			"chemplp", "plp", "plp95");
	// input
	public SettingsModelString protein_file = new SettingsModelString("protein_file", null);
	public SettingsModelString ligand_file = new SettingsModelString("ligand_file", null);
	// output
	public SettingsModelString output_dir = new SettingsModelString("output_dir", "results");
	public SettingsModelBoolean write_protein_conformations = new SettingsModelBoolean("write_protein_conformations",
			true);
	public SettingsModelBoolean write_protein_bindingsite = new SettingsModelBoolean("write_protein_bindingsite", true);
	public SettingsModelBoolean write_multi_mol2 = new SettingsModelBoolean("write_multi_mol2", true);
	public SettingsModelBoolean write_ranking_links = new SettingsModelBoolean("write_ranking_links", false);
	public SettingsModelBoolean write_merged_protein = new SettingsModelBoolean("write_merged_protein", false);
	public SettingsModelNumber aco_ants;

	public ConfigureConfig() {
	}

	public void saveSettingsTo(final NodeSettingsWO settings) {
		// search algorithm
		search_speed.saveSettingsTo(settings);
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
		// input
		protein_file.saveSettingsTo(settings);
		ligand_file.saveSettingsTo(settings);
		// output
		output_dir.saveSettingsTo(settings);
		write_protein_conformations.saveSettingsTo(settings);
		write_protein_bindingsite.saveSettingsTo(settings);
		write_multi_mol2.saveSettingsTo(settings);
		write_ranking_links.saveSettingsTo(settings);
		write_merged_protein.saveSettingsTo(settings);
	}

	public void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
		// search algorithm
		search_speed.loadSettingsFrom(settings);
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
		// input
		protein_file.loadSettingsFrom(settings);
		ligand_file.loadSettingsFrom(settings);
		// output
		output_dir.loadSettingsFrom(settings);
		write_protein_conformations.loadSettingsFrom(settings);
		write_protein_bindingsite.loadSettingsFrom(settings);
		write_multi_mol2.loadSettingsFrom(settings);
		write_ranking_links.loadSettingsFrom(settings);
		write_merged_protein.loadSettingsFrom(settings);
	}

	public void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
		// search algorithm
		search_speed.validateSettings(settings);
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
		// input
		protein_file.validateSettings(settings);
		ligand_file.validateSettings(settings);
		// output
		output_dir.validateSettings(settings);
		write_protein_conformations.validateSettings(settings);
		write_protein_bindingsite.validateSettings(settings);
		write_multi_mol2.validateSettings(settings);
		write_ranking_links.validateSettings(settings);
		write_merged_protein.validateSettings(settings);
	}

	public Map<String, Object> asMap() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// search algorithm
		map.put("search_speed", search_speed.getStringValue());
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
		// input
		map.put("protein_file", protein_file.getStringValue());
		map.put("ligand_file", ligand_file.getStringValue());
		// output
		map.put("output_dir", output_dir.getStringValue());
		map.put("write_protein_conformations", write_protein_conformations.getBooleanValue());
		map.put("write_protein_bindingsite", write_protein_bindingsite.getBooleanValue());
		map.put("write_multi_mol2", write_multi_mol2.getBooleanValue());
		map.put("write_ranking_links", write_ranking_links.getBooleanValue());
		map.put("write_merged_protein", write_merged_protein.getBooleanValue());
		return map;

	}
}
