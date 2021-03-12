package io.javaalmanac.snippets.time;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class CalendarSystemsTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(CalendarSystems::main, """
				Hijrah-umalqura AH 1443-02-07
				2021-09-14
				Japanese Reiwa 3-09-14
				Minguo ROC 110-09-14
				ThaiBuddhist BE 2564-09-14
				""");
	}

}
