package io.javaalmanac.snippets.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class DiffieHellmanKeyAgreementTest {

	@Test
	void run_main() throws Exception {
		var grabber = new ConsoleGrabber();
		grabber.run(DiffieHellmanKeyAgreement::main);
		var lines = grabber.lines();
		assertEquals(2, lines.size());
		assertEquals(lines.get(0).split(":\\W+")[1], lines.get(1).split(":\\W+")[1]);
	}

}
