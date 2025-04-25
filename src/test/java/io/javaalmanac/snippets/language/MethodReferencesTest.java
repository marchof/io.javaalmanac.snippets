package io.javaalmanac.snippets.language;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class MethodReferencesTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(MethodReferences::main, """
				constructor
				instanceMethod
				instanceMethod
				instanceMethod hello
				classMethod
				classMethodWithReturn hello
				42
				""");
	}

}
