package io.javaalmanac.snippets.time;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class ConvertBetweenTimeZonesTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(ConvertBetweenTimeZones::main, """
				Lunar Eclipse at 2025-03-14T15:59+09:00[Asia/Tokyo]
				Lunar Eclipse at 2025-03-14T12:29+05:30[Asia/Kolkata]
				Lunar Eclipse at 2025-03-14T07:59+01:00[Europe/Paris]
				Lunar Eclipse at 2025-03-14T03:59-03:00[America/Fortaleza]
				Lunar Eclipse at 2025-03-13T20:59-10:00[Pacific/Honolulu]
				""");
	}

}
