package io.javaalmanac.snippets.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Local dates can be used for various calendar calculations of based on
 * granularity days.
 * 
 * @title Calculate With Local Dates
 * @category api.time
 * @since 8
 */
public class CalculateWithLocalDates {

	void main() {
		LocalDate arrival = LocalDate.of(2021, 12, 28);
		LocalDate departure = LocalDate.of(2022, 1, 2);

		System.out.println("Nights: " + arrival.until(departure, ChronoUnit.DAYS));
		arrival.datesUntil(departure).map("Dinner: %ta %<s"::formatted).forEach(System.out::println);

		departure = departure.plus(3, ChronoUnit.DAYS);
		System.out.printf("Stay 3 more days: %ta %<s%n", departure);

		departure = departure.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.printf("Stay to next sunday: %ta %<s%n", departure);
	}

}
