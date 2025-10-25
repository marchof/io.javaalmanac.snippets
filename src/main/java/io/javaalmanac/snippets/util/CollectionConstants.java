package io.javaalmanac.snippets.util;

import java.awt.Color;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The collection interfaces {@link java.util.Set Set}, {@link java.util.List
 * List} and {@link java.util.Map} have several static <code>of(...)</code>
 * methods to create constant instances of the respective collection types.
 * Collections created this way do not allow <code>null</code> elements and any
 * mutation method throws an {@link java.lang.UnsupportedOperationException}.
 * Also as these methods are designed to declare constants duplicate set entries
 * or map keys are considered as an error.
 * 
 * @title Collection Constants
 * @category api.util
 * @since 9
 */
public class CollectionConstants {

	static final Set<Color> BAVARIAN_COLORS = Set.of(Color.WHITE, Color.BLUE);

	static final List<DayOfWeek> LONG_WEEKEND = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

	static final Map<String, Integer> PEAK_ELEVATIONS = Map.of( //
			"Mauna Key", 4205, //
			"Matterhorn", 4478, //
			"Makalu", 8485);

	void main() {

		System.out.println("The elevation of Matterhorn is " + PEAK_ELEVATIONS.get("Matterhorn"));

		// Invalid usages:

		try {
			BAVARIAN_COLORS.add(Color.BLACK);
		} catch (UnsupportedOperationException e) {
			System.out.println("Constant collections cannot be modified");
		}

		try {
			List.of("null", null);
		} catch (NullPointerException e) {
			System.out.println("null is not allowed in constant collections");
		}

		try {
			Set.of("same", "same");
		} catch (IllegalArgumentException e) {
			System.out.println("Duplicate entries are not allowed for constant sets");
		}

		try {
			Map.of("key", 1, "key", 2);
		} catch (IllegalArgumentException e) {
			System.out.println("Duplicate keys are not allowed for constant maps");
		}

	}

}
