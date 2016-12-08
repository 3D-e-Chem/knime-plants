package nl.esciencecenter.e3dchem.knime.plants;

import javax.swing.JFileChooser;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentFileChooser;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;

/**
 * <code>NodeDialog</code> for the "Configure" Node.
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more
 * complex dialog please derive directly from
 * {@link org.knime.core.node.NodeDialogPane}.
 */
public class ConfigureDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring Configure node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    protected ConfigureDialog() {
        super();
        
        ConfigureConfig config = new ConfigureConfig();
        
        this.createNewTab("Search algorithm");
        SettingsModelStringSet search_speed = config.search_speed;
        addDialogComponent(new DialogComponentStringSelection(search_speed, "Search speed", search_speed.getChoices()));
//        addDialogComponent(new DialogComponentNumber(config.aco_ants, "Number of ants", 1));
//        addDialogComponent(new DialogComponentNumber(config.aco_evap, "Evaporation factor", 0.1));
//        addDialogComponent(new DialogComponentNumber(config.aco_sigma, "Iteration scaling factor", 0.1));
//        addDialogComponent(new DialogComponentBoolean(config.flip_amide_bonds, "Flip amide bonds"));
//        addDialogComponent(new DialogComponentBoolean(config.flip_planar_n, "Flip bonds next to planar nitrogens"));
//        addDialogComponent(new DialogComponentBoolean(config.force_flipped_bonds_planarity, "Automatic planarity correction for flippable bonds"));
//        addDialogComponent(new DialogComponentBoolean(config.force_planar_bond_rotation, "Free rotation of planar bonds"));
//        addDialogComponent(new DialogComponentBoolean(config.rescore_mode, "Simplex optimization during rescoring"));
//        addDialogComponent(new DialogComponentBoolean(config.flip_ring_corners, "Flip if free rubg corners"));
        
        this.createNewTab("Binding site");
        addDialogComponent(new DialogComponentNumber(config.bindingsite_center_x, "Center X", 1));
        addDialogComponent(new DialogComponentNumber(config.bindingsite_center_y, "Center Z", 1));
        addDialogComponent(new DialogComponentNumber(config.bindingsite_center_z, "Center Y", 1));
        addDialogComponent(new DialogComponentNumber(config.bindingsite_radius, "Radius", 1));
        
        this.createNewTab("Cluster algorithm");
        addDialogComponent(new DialogComponentNumber(config.cluster_rmsd, "RMSD similarity threshold", 1));
        addDialogComponent(new DialogComponentNumber(config.cluster_structures, "Number of structures", 1));

        this.createNewTab("Scoring functions");
        this.createNewGroup("Intermolecular (protein-ligand interaction scoring)");
        SettingsModelStringSet scoring_function = config.scoring_function;
        addDialogComponent(new DialogComponentStringSelection(scoring_function, "Scoring function", scoring_function.getChoices()));
//        addDialogComponent(new DialogComponentNumber(config.outside_binding_site_penalty, "Using precalculated grids use value to fill grid points outside the binding site definition", 1));
//        addDialogComponent(new DialogComponentBoolean(config.enable_sulphur_acceptors, "Sulphur acceptors"));
//        this.createNewGroup("Intramolecular ligand scoring");
//        addDialogComponent(new DialogComponentStringSelection(ligand_intra_score, "Ligand intra score", ligand_intra_score.getChoices()));
//        addDialogComponent(new DialogComponentNumber(config.chemplp_clash_include_14, "Chemplp+clash interactions", 1));
//        addDialogComponent(new DialogComponentBoolean(config.chemplp_clash_include_HH, "Hydrogen-hydrogen interactions"));
        
        
        this.createNewTab("Input");
        DialogComponentFileChooser proteinFile = new DialogComponentFileChooser(config.protein_file, "historyID4protein_file", "mol2");
        proteinFile.setBorderTitle("Protein file");
        addDialogComponent(proteinFile);
        DialogComponentFileChooser ligandFile = new DialogComponentFileChooser(config.ligand_file, "historyID4ligand_file", "mol2");
        ligandFile.setBorderTitle("Ligand file");
        addDialogComponent(ligandFile);

        this.createNewTab("Output");
        addDialogComponent(new DialogComponentFileChooser(config.output_dir, "historyID4output_dir", JFileChooser.SAVE_DIALOG, true));
        addDialogComponent(new DialogComponentBoolean(config.write_protein_conformations, "Protein conformations"));
        addDialogComponent(new DialogComponentBoolean(config.write_protein_bindingsite, "Protein binding site"));
        addDialogComponent(new DialogComponentBoolean(config.write_multi_mol2, "Multi-mol2"));
        addDialogComponent(new DialogComponentBoolean(config.write_ranking_links, "Ranked soft links"));
        addDialogComponent(new DialogComponentBoolean(config.write_merged_protein, "Merged protein"));
        
        this.createNewTab("Constraints");
        
        this.selectTab("Input");
        this.removeTab("Options");
    }
}
