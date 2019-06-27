package nl.esciencecenter.e3dchem.knime.plants.run;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.util.LockFailedException;
import org.knime.testing.core.TestrunConfiguration;
import org.osgi.framework.Bundle;

import nl.esciencecenter.e3dchem.knime.plants.Activator;
import nl.esciencecenter.e3dchem.knime.testing.TestFlowRunner;

public class RunWorkflowTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
    private TestFlowRunner runner;

    @Before
    public void setUp() throws IOException {
        TestrunConfiguration runConfiguration = new TestrunConfiguration();
        runConfiguration.setTestDialogs(true);
        runConfiguration.setReportDeprecatedNodes(false);
        runConfiguration.setCheckMemoryLeaks(false);
        runConfiguration.setLoadSaveLoad(false);
        runner = new TestFlowRunner(collector, runConfiguration);
        makeBinariesExecutable();
    }

    /**
     * For non-Windows the binaries must have their executable permission bit set.
     *
     * When plugin fragment is installed in KNIME the bin.linux/META-INF/p2.inf does a chmod. During tests the p2.inf is not
     * triggered, so do it here.
     *
     * @throws IOException
     */
    private void makeBinariesExecutable() throws IOException {
        if (!isWindows()) {
            Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
            File path = new File(FileLocator.toFileURL(FileLocator.find(bundle, new Path("/bin/PLANTS"), null)).getPath());
            path.setExecutable(true);
        }
    }

    private boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

    @Test
    public void test_simple() throws IOException, InvalidSettingsException, CanceledExecutionException,
            UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
        File workflowDir = new File("src/knime/run-test");
        runner.runTestWorkflow(workflowDir);
    }
}
