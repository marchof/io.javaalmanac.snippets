package io.javaalmanac.snippets.net;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class UnixDomainSocketsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(UnixDomainSockets::main, """
				Hello Socket!
				""");
	}

}
