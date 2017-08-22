package nl.esciencecenter.e3dchem.knime.plants.run;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.knime.core.data.DataRow;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;

public class RunNodeModelTest {
	@Rule
	public TemporaryFolder folder= new TemporaryFolder();

	@Test
	public void testProcess() throws IOException, InterruptedException {
		Assume.assumeTrue(!System.getProperty("os.name").contains("Windows"));
		
		RunNodeModel node = new RunNodeModel();
		RowKey rowKey = RowKey.createRowKey(1234L);
		File workingDirectory = folder.getRoot();
		String executable = "/bin/echo";
		String mode = "bind";
		List<String> arguments = Arrays.asList("arg1", "arg2");

		DataRow row = node.process(rowKey, workingDirectory, executable, mode, arguments);
		
        String sep = System.getProperty("line.separator");
        DefaultRow expected = new DefaultRow(rowKey, new IntCell(0), new StringCell("--mode bind arg1 arg2" + sep),
                new StringCell(""));
		assertEquals(expected, row);
	}
}
