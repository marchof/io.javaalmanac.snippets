package io.javaalmanac.snippets.time;

import java.time.LocalDate;
import java.time.chrono.Chronology;

/**
 * There are different calendar systems in the world. Let's write the Java 17
 * release date in the systems known to Java.
 * 
 * @title Calendar Systems
 * @category api.time
 * @since 8
 */
public class CalendarSystems {

	void main() {

		LocalDate java25release = LocalDate.of(2025, 9, 16);

		Chronology.getAvailableChronologies().stream() //
				.sorted() //
				.map(c -> c.date(java25release)) //
				.forEach(System.out::println);

	}

}
