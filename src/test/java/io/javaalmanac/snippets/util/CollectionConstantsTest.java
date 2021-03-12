package io.javaalmanac.snippets.util;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class CollectionConstantsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(CollectionConstants::main, """
				The elevation of Matterhorn is 4478
				Constant collections cannot be modified
				null is not allowed in constant collections
				Duplicate entries are not allowed for constant sets
				Duplicate keys are not allowed for constant maps
				""");
	}

}
