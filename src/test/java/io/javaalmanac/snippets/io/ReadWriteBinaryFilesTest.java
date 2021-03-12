package io.javaalmanac.snippets.io;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class ReadWriteBinaryFilesTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(ReadWriteBinaryFiles::main, """
				cafebabe
				cafebabecafebabe
				""");
	}

}
