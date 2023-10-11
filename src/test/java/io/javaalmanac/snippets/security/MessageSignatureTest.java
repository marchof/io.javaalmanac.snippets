package io.javaalmanac.snippets.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class MessageSignatureTest {

	@Test
	void run_main() throws Exception {
		var grabber = new ConsoleGrabber();
		grabber.run(MessageSignature::main);
		var lines = grabber.lines();
		assertEquals("true", lines.get(0));
		assertEquals("false", lines.get(1));
	}

}
