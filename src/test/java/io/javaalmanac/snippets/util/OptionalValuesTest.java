package io.javaalmanac.snippets.util;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class OptionalValuesTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(OptionalValues::main, """
				Our task today:
				Do some coding.
				Do some coding.
				Do some coding.
				Do some coding.
				DO SOME CODING.
				Do some coding.
				No Task today:
				Clean the kitchen.
				Find random Task.
				Just lazy today.
				""");
	}

}
