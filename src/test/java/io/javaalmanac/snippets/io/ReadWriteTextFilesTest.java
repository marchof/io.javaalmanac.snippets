package io.javaalmanac.snippets.io;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class ReadWriteTextFilesTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(ReadWriteTextFiles::main, """
				Line 1
				Line 2
				Line 3
				> Line 1
				> Line 2
				> Line 3
				Line 1/Line 2/Line 3
				1: Line 1
				2: Line 2
				3: Line 3
				""");
	}

}
