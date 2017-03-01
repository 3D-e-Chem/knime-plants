package nl.esciencecenter.e3dchem.knime.plants.execute;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

public class ExecuteFactory extends NodeFactory<ExecuteModel>{

	@Override
	public ExecuteModel createNodeModel() {
		return new ExecuteModel();
	}

	@Override
	protected int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<ExecuteModel> createNodeView(int viewIndex, ExecuteModel nodeModel) {
		return null;
	}

	@Override
	protected boolean hasDialog() {
		return true;
	}

	@Override
	protected NodeDialogPane createNodeDialogPane() {
		return new ExecuteDialog();
	}

}
