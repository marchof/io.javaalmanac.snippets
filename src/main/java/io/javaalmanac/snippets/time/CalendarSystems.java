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

	public static void main(String[] args) {

		LocalDate java17release = LocalDate.of(2021, 9, 14);

		Chronology.getAvailableChronologies().stream() //
				.sorted() //
				.map(c -> c.date(java17release)) //
				.forEach(System.out::println);

	}

}
