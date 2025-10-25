package io.javaalmanac.snippets.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.stream.Stream;

/**
 * To find all Friday 13th we iterate over a range of YearMonth and check
 * whether the LocalDate with day 13 is a Friday.
 * 
 * @title Friday 13th
 * @category api.time
 * @since 8
 */
public class Friday13th {

	void main() {

		YearMonth start = YearMonth.of(2000, 1);
		YearMonth end = YearMonth.of(2030, 12);

		Stream.iterate(start, m -> m.isBefore(end), m -> m.plusMonths(1)) //
				.map(m -> m.atDay(13)) //
				.filter(this::isFriday) //
				.map("%ta %<s"::formatted) //
				.forEach(System.out::println);
	}

	boolean isFriday(LocalDate date) {
		return DayOfWeek.FRIDAY.equals(date.getDayOfWeek());
	}

}
