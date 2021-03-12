package io.javaalmanac.snippets.function;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class NotPredicateTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(NotPredicate::main, """
				venus
				mars
				earth
				""");
	}

}
