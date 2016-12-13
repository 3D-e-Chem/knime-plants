package nl.esciencecenter.e3dchem.knime.plants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettings;

public class SettingsModelStringSetTest {
	private SettingsModelStringSet model;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		model = new SettingsModelStringSet("search_speed", "speed1", "speed1",
				"speed2", "speed4");
	}
	
	private NodeSettings getSettings(String value) {
		NodeSettings settings = new NodeSettings(value);
		settings.addString("search_speed", value);
		return settings;
	}
	
	@Test
	public void test_construct_invaliddefaultvalue() {
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("defaultValue");
        
		model = new SettingsModelStringSet("search_speed", "speed0", "speed1",
				"speed2", "speed4");
	}

	@Test
	public void test_construct_nochoices() {
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Specified set must not be empty");
        
		model = new SettingsModelStringSet("search_speed", "speed1");
	}
	
	@Test
	public void test_validateValue_oneofchoice() {
		String value = "speed1";
		try {
			NodeSettings settings = getSettings(value);
			model.validateSettings(settings);
		} catch (InvalidSettingsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_validateValue_notoneofchoice() throws InvalidSettingsException {
		String value = "speed0";
		
		thrown.expect(InvalidSettingsException.class);
        thrown.expectMessage("value (='speed0') must be one of 'speed4', 'speed2', 'speed1'");
		 
        NodeSettings settings = getSettings(value);
        model.validateSettings(settings);
	}
	
	@Test
	public void test_getChoices() {
		Set<String> expecteds = new HashSet<String>();
		expecteds.add("speed1");
		expecteds.add("speed2");
		expecteds.add("speed4");
		
		assertEquals(expecteds, model.getChoices());
	}
}
