package core;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigManager {
	private static Properties properties = new Properties();

	static {
		try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (input != null) {
				properties.load(input);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key, "");
	}
}
