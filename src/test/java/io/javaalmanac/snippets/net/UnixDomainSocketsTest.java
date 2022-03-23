package io.javaalmanac.snippets.net;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class UnixDomainSocketsTest {

	@Test
	void run_main() throws Exception {
		var grabber = new ConsoleGrabber();
		grabber.run(UnixDomainSockets::main);
		var lines = grabber.lines();
		assertEquals(2, lines.size());
		assertTrue(lines.get(0).contains("Listening on"));
		assertEquals("Hello Socket!", lines.get(1));
	}

}
