package io.javaalmanac.snippets.time;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class CalendarSystemsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(CalendarSystems::main, """
				Hijrah-umalqura AH 1447-03-24
				2025-09-16
				Japanese Reiwa 7-09-16
				Minguo ROC 114-09-16
				ThaiBuddhist BE 2568-09-16
				""");
	}

}
