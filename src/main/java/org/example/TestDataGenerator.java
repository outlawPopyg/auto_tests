package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataGenerator {
	public static void main(String[] args) {
		String type = args[0];
		int count = Integer.parseInt(args[1]);
		String fileName = args[2];
		String format = args[3];

		if (type.equals("groups")) {
			generateForGroups(count, fileName, format);
		} else {
			throw new IllegalArgumentException("Unrecognized type of data " + type);
		}
	}

	@SneakyThrows
	private static void generateForGroups(int count, String fileName, String format) {
		List<GroupData> groupData = new ArrayList<>();
		XmlMapper xmlMapper = new XmlMapper();
		Group group = new Group(groupData);

		if (count > 0) {
			for (int i = 0; i < count; i++) {
				groupData.add(
						GroupData.builder()
								.header(generateRandomString())
								.footer(generateRandomString())
								.name(generateRandomString())
								.build()
				);
			}

			if (format.equals("xml")) {
				if (!fileName.endsWith(".xml")) {
					throw new IllegalArgumentException("Bad file extension: " + fileName);
				}

				Path path = Path.of("/storage");
				if (!Files.isDirectory(path.normalize().toAbsolutePath())) {
					Files.createDirectory(path.normalize().toAbsolutePath());
				}
				String resultPath = Path.of("/storage/")
						.resolve(Path.of(fileName)).normalize().toAbsolutePath().toString();

				xmlMapper.writeValue(new File(resultPath), group);
			} else {
				throw new IllegalArgumentException("Unrecognized format " + format);
			}
		}
	}

	private static String generateRandomString() {
		int leftLimit = 48;
		int rightLimit = 122;
		int targetStringLength = 10;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
}