package io.javaalmanac.snippets.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Print the current time in all time zones known to the JDK (from the [tz
 * database](https://en.wikipedia.org/wiki/Tz_database)) together with their
 * current UTC offset and the DST status.
 *
 * @title World Clock
 * @category api.time
 * @since 8
 */
public class WorldClock {

	static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, yyyy-MM-dd HH:mm:ss  xxx", Locale.US);

	String format(ZonedDateTime t) {
		String dst = t.getZone().getRules().isDaylightSavings(t.toInstant()) ? "DST" : "";
		return "%-32s %s  %s".formatted(t.getZone(), t.format(FORMATTER), dst);
	}

	void main() {
		Instant now = Instant.now();

		ZoneId.getAvailableZoneIds().stream() //
				.map(ZoneId::of) //
				.map((ZoneId z) -> ZonedDateTime.ofInstant(now, z)) //
				.sorted() //
				.map(this::format).forEach(System.out::println);
	}

}
