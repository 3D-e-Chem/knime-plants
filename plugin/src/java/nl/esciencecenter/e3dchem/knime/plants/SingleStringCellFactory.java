package nl.esciencecenter.e3dchem.knime.plants;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataRow;
import org.knime.core.data.container.SingleCellFactory;
import org.knime.core.data.def.StringCell;

public class SingleStringCellFactory extends SingleCellFactory  {
	private String content;

	public SingleStringCellFactory(final DataColumnSpec newColSpec, final String content) {
		super(newColSpec);
		this.content = content;
	}

	@Override
	public DataCell getCell(DataRow row) {
		return new StringCell(content);
	}

}
