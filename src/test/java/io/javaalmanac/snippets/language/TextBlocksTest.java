package io.javaalmanac.snippets.language;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class TextBlocksTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(TextBlocks::main, """
				Hello
				"World"!

				<a href="https://javaalmanac.io/">Click here!</a>
				""");
	}

}
