package io.javaalmanac.snippets.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 * A date-based amount of time can be represented with the
 * {@link java.time.Period} type. With this data type a time span is expressed
 * as a number of years, months and days.
 * 
 * @title Time Period
 * @category api.time
 * @since 8
 */
public class HowOldIsJava {

	static final LocalDate BIRTHDAY_OF_JAVA = LocalDate.of(1995, 5, 23);

	static final ZoneId TIMEZONE_OF_BIRTH = ZoneId.of("America/Los_Angeles");

	public static void main(String[] args) {

		var today = LocalDate.now(TIMEZONE_OF_BIRTH);
		var age = Period.between(BIRTHDAY_OF_JAVA, today);
		System.out.println("As of today Java is %s old".formatted(fmt(age)));

		var nextAnivesary = BIRTHDAY_OF_JAVA.plus(Period.ofYears(age.getYears() + 1));
		var tillAnivesary = Period.between(today, nextAnivesary);
		System.out.println("Java's next birthday is in %s".formatted(fmt(tillAnivesary)));

	}

	static String fmt(Period p) {
		// Unfortunately there is no built-in formatter for Period objects
		return "%d years, %d months and %d days".formatted(p.getYears(), p.getMonths(), p.getDays());
	}

}
