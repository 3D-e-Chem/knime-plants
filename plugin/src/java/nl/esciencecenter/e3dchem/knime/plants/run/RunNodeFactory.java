package nl.esciencecenter.e3dchem.knime.plants.run;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

public class RunNodeFactory extends NodeFactory<RunNodeModel>{

	@Override
	public RunNodeModel createNodeModel() {
		return new RunNodeModel();
	}

	@Override
	protected int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<RunNodeModel> createNodeView(int viewIndex, RunNodeModel nodeModel) {
		return null;
	}

	@Override
	protected boolean hasDialog() {
		return true;
	}

	@Override
	protected NodeDialogPane createNodeDialogPane() {
		return new RunNodeDialog();
	}

}
