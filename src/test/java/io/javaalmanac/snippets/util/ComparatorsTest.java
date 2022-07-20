package io.javaalmanac.snippets.util;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class ComparatorsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(Comparators::main, """
				[apple, Cherry, Fig, Mango, Pear]
				[Cherry, Fig, Mango, Pear, apple]
				[Fig, Pear, apple, Mango, Cherry]
				[Cherry, apple, Mango, Pear, Fig]
				[null, null, a, B, c]
				Cherry
				""");
	}

}
