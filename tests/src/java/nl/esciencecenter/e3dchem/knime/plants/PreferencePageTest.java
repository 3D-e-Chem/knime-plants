package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PreferencePageTest {
    private static SWTWorkbenchBot bot;

    @BeforeClass
    public static void setUp() {
        assumeFalse("Does not work on Mac", System.getProperty("os.name").contains("Mac"));
        bot = new SWTWorkbenchBot();
    }

    @AfterClass
    public static void sleep() {
        bot.closeAllShells();
    }

    @Test
    public void test_initialState() {
        String binDir = bot.textWithLabel("Path of PLANTS executable").getText();
        assertTrue("Path of PLANTS executable contains 'bin'", binDir.contains("bin"));
    }

    @Before
    public void openPage() {
        bot.menu("Window").menu("Preferences").click();

        bot.shell("Preferences").activate();

        bot.tree().expandNode("KNIME", true).select("PLANTS");
    }

    @After
    public void closePage() {
        bot.shell("Preferences").close();
    }
}