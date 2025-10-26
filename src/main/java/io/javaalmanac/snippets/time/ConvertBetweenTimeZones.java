package io.javaalmanac.snippets.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * With time zones a given timestamp can be represented in different local dates
 * and times.
 * 
 * @title Convert Between Time Zones
 * @category api.time
 * @since 8
 */
public class ConvertBetweenTimeZones {

	void main() {
		ZonedDateTime lunarEclipse = ZonedDateTime.of(LocalDate.of(2025, 03, 14), LocalTime.of(6, 59), ZoneOffset.UTC);
		List<String> places = List.of( //
				"Asia/Tokyo", "Asia/Kolkata", "Europe/Paris", "America/Fortaleza", "Pacific/Honolulu");

		for (String place : places) {
			IO.println("Lunar Eclipse at " + lunarEclipse.withZoneSameInstant(ZoneId.of(place)));
		}
	}

}
