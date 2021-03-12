package io.javaalmanac.snippets.time;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class WorldClockTest {

	@Test
	void run_main() throws Exception {
		var grabber = new ConsoleGrabber();
		grabber.run(WorldClock::main);
		var lines = grabber.lines();
		assertTrue(lines.size() > 500);
		lines.stream().reduce(this::assertOrder);
	}

	String assertOrder(String l1, String l2) {
		var t1 = l1.substring(38, 65);
		var t2 = l2.substring(38, 65);
		assertTrue(t1.compareTo(t2) <= 0, "Not sorted: " + t1 + " > " + t2);
		return l2;
	}

}
