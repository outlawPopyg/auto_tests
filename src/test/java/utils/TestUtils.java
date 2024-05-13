package utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class TestUtils {
	public static Object retrieveData(String path, Class<?> clazz) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		File file = new File(Path.of(path).normalize().toAbsolutePath().toString());
		return xmlMapper.readValue(file, clazz);
	}
}
