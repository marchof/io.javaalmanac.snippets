package io.javaalmanac.snippets.language;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class NumericLiteralsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(NumericLiterals::main, """
				182
				342391
				1000000
				42
				-889275714
				3405691582
				1000.0
				0.333333
				415733.8356933594
				1000.0
				415733.84
				""");
	}

}
