package io.javaalmanac.snippets.language;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class RecordsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(Records::main, """
				3.0
				Point[x=3.0, y=5.0]
				true
				17563648
				56.54866776461626
				""");
	}

}
