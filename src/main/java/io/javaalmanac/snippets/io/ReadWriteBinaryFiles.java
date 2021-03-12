package io.javaalmanac.snippets.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HexFormat;

/**
 * The {@link java.nio.file.Files} class offers a couple of convenience methods
 * to read and write binary content from/to files.
 * 
 * @title Read and Write Binary Files
 * @category api.io
 * @since 11
 */
public class ReadWriteBinaryFiles {

	static final HexFormat HEX = HexFormat.of();

	static final byte[] TEST_CONTENT = HEX.parseHex("cafebabe");

	public static void main(String... args) throws IOException {

		var file = Files.createTempFile("ReadWriteBinaryFiles", ".txt");

		// Write out a raw byte array to a file
		Files.write(file, TEST_CONTENT);

		// Read the entire content as one byte array:
		var content = Files.readAllBytes(file);
		System.out.println(HEX.formatHex(content));

		// Append binary content with an OutputStream:
		try (OutputStream out = Files.newOutputStream(file, StandardOpenOption.APPEND)) {
			out.write(TEST_CONTENT);
		}

		// Read binary content from an InputStream:
		try (InputStream in = Files.newInputStream(file)) {
			content = in.readAllBytes();
			System.out.println(HEX.formatHex(content));
		}

		Files.delete(file);

	}

}
