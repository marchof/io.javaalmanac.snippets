package io.javaalmanac.snippets.time;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class DaylightSavingTimeTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(DaylightSavingTime::main, """
				DST transitions in Europe/Zurich between 2019-12-31T23:00:00Z and 2029-12-31T23:00:00Z:
				Transition[Gap at 2020-03-29T02:00+01:00 to +02:00]
				Transition[Overlap at 2020-10-25T03:00+02:00 to +01:00]
				Transition[Gap at 2021-03-28T02:00+01:00 to +02:00]
				Transition[Overlap at 2021-10-31T03:00+02:00 to +01:00]
				Transition[Gap at 2022-03-27T02:00+01:00 to +02:00]
				Transition[Overlap at 2022-10-30T03:00+02:00 to +01:00]
				Transition[Gap at 2023-03-26T02:00+01:00 to +02:00]
				Transition[Overlap at 2023-10-29T03:00+02:00 to +01:00]
				Transition[Gap at 2024-03-31T02:00+01:00 to +02:00]
				Transition[Overlap at 2024-10-27T03:00+02:00 to +01:00]
				Transition[Gap at 2025-03-30T02:00+01:00 to +02:00]
				Transition[Overlap at 2025-10-26T03:00+02:00 to +01:00]
				Transition[Gap at 2026-03-29T02:00+01:00 to +02:00]
				Transition[Overlap at 2026-10-25T03:00+02:00 to +01:00]
				Transition[Gap at 2027-03-28T02:00+01:00 to +02:00]
				Transition[Overlap at 2027-10-31T03:00+02:00 to +01:00]
				Transition[Gap at 2028-03-26T02:00+01:00 to +02:00]
				Transition[Overlap at 2028-10-29T03:00+02:00 to +01:00]
				Transition[Gap at 2029-03-25T02:00+01:00 to +02:00]
				Transition[Overlap at 2029-10-28T03:00+02:00 to +01:00]
				""");
	}

}
