package io.javaalmanac.snippets.time;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class CalculateWithLocalDatesTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(CalculateWithLocalDates::main, """
				Nights: 5
				Dinner: Tue 2021-12-28
				Dinner: Wed 2021-12-29
				Dinner: Thu 2021-12-30
				Dinner: Fri 2021-12-31
				Dinner: Sat 2022-01-01
				Stay 3 more days: Wed 2022-01-05
				Stay to next sunday: Sun 2022-01-09
				""");
	}

}
