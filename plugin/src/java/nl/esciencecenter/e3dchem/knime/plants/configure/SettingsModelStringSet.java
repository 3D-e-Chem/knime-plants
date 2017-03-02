package nl.esciencecenter.e3dchem.knime.plants.configure;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * SettingsModelString where value must be one of choices
 */
public class SettingsModelStringSet extends SettingsModelString {
	private Set<String> choices;

	public SettingsModelStringSet(String configName, String defaultValue, Set<String> choices) {
		super(configName, defaultValue);
		if (choices.isEmpty()) {
			throw new IllegalArgumentException("Specified set must not be empty");
		}
		this.choices = choices;
		try {
			this.validateValue(defaultValue);
		} catch (InvalidSettingsException e) {
			throw new IllegalArgumentException("defaultValue", e);
		}
	}

	public SettingsModelStringSet(String configName, String defaultValue, String... choices) {
		this(configName, defaultValue, Stream.of(choices).collect(Collectors.toSet()));
	}

	@Override
	protected SettingsModelStringSet createClone() {
		return new SettingsModelStringSet(this.getConfigName(), this.getStringValue(), choices);
	}

	@Override
	protected void validateSettingsForModel(NodeSettingsRO settings) throws InvalidSettingsException {
		super.validateSettingsForModel(settings);
		validateValue(settings.getString(getConfigName()));
	}

	protected void validateValue(String value) throws InvalidSettingsException {
		if (!choices.contains(value)) {
			throw new InvalidSettingsException("value (='" + value + "') must be one of " + choices.stream().map(i -> "'" + i + "'").collect(Collectors.joining(", ")));
		}
	}

	public Set<String> getChoices() {
		return choices;
	}
}
