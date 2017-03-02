package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.container.CellFactory;
import org.knime.core.data.def.StringCell;

import nl.esciencecenter.e3dchem.knime.plants.configure.SingleStringCellFactory;

public class SingleStringCellFactoryTest {

	@Test
	public void test() {
		String content = "the content of the cell";
		CellFactory cellFactory = new SingleStringCellFactory(createOutputColumnSpec() , content);

		DataRow row = null; // SingleStringCellFactory does not care what input row has in it, so empty row will suffice
		DataCell[] cells = cellFactory.getCells(row);
		
		DataCell[] expectedCells = new DataCell[]{ new StringCell(content)};
		assertArrayEquals(cells, expectedCells);
	}

	private DataColumnSpec createOutputColumnSpec() {
		DataColumnSpecCreator colSpecCreator = new DataColumnSpecCreator(
                "PLANTS configuration", StringCell.TYPE);
        return colSpecCreator.createSpec();
	}

}
