package configuration;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

public class Settings {
	@Setter
	private static String filePath = "settings.xml";
	@Getter
	private static SettingsDTO settingsDTO;
	private static final XmlMapper xmlMapper = new XmlMapper();

	public static SettingsDTO loadProperties() {
		try {
			return xmlMapper.readValue(new File(filePath), SettingsDTO.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
