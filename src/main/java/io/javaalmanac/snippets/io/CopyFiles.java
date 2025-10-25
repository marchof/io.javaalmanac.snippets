package io.javaalmanac.snippets.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HexFormat;

/**
 * The {@link java.nio.file.Files} class offers a couple of convenience methods
 * to copy data between files, {@link java.io.InputStream}s and
 * {@link java.io.OutputStream}s. Also streams can be directly transferred with
 * {@link java.io.InputStream#transferTo(java.io.OutputStream)}. Many Java
 * idioms with temporary buffers shuffling data chunks in `while` loops are
 * obsolete nowadays.
 * 
 * @title Copy Files and IO Streams
 * @category api.io
 * @since 9
 */
public class CopyFiles {

	static final HexFormat HEX = HexFormat.of();

	static final byte[] TEST_CONTENT = HEX.parseHex("cafebabe");

	void main() throws IOException {

		var srcfile = Files.createTempFile("CopyFiles", ".txt");
		var dstfile = Files.createTempFile("CopyFiles", ".txt");
		Files.write(srcfile, TEST_CONTENT);

		// Directly copy files
		Files.copy(srcfile, dstfile, StandardCopyOption.REPLACE_EXISTING);

		System.out.println(HEX.formatHex(Files.readAllBytes(dstfile)));

		// Copy data from InputStream to a file:
		var in = new ByteArrayInputStream(TEST_CONTENT);
		Files.copy(in, dstfile, StandardCopyOption.REPLACE_EXISTING);

		System.out.println(HEX.formatHex(Files.readAllBytes(dstfile)));

		// Copy the file content to an OutputStream:
		var out = new ByteArrayOutputStream();
		Files.copy(srcfile, out);

		System.out.println(HEX.formatHex(out.toByteArray()));

		// Copy content from an InputStream to an OutputStream:
		in = new ByteArrayInputStream(TEST_CONTENT);
		out = new ByteArrayOutputStream();
		in.transferTo(out);

		System.out.println(HEX.formatHex(out.toByteArray()));

	}

}
