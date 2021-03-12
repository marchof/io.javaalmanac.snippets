package io.javaalmanac.snippets.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class MessageAuthenticationCodeTest {

	@Test
	void run_main() throws Exception {
		var grabber = new ConsoleGrabber();
		grabber.run(MessageAuthenticationCode::main);
		var lines = grabber.lines();
		assertEquals(3, lines.size());
		assertEquals(lines.get(0), lines.get(1));
		assertNotEquals(lines.get(1), lines.get(2));
	}

}
