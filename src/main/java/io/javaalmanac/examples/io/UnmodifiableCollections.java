package io.javaalmanac.examples.io;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The collection interfaces {@link Set}, {@link List} and {@link Map} have
 * several static <code>of(...)</code> methods to create unmodifiable instances
 * of the respective collection types. Collections created this way do not allow
 * <code>null</code> elements and any mutation method throws an
 * {@link UnsupportedOperationException}. Also as these methods are designed to
 * declare constants duplicate set entries or map keys are considered as an
 * error.
 * 
 * @category util
 * @since Java 9
 */
public class UnmodifiableCollections {

	// Name/Type
	static final Set<String> EMPTY_SET = Set.of();

	static final Set<Color> BAVARIAN_COLORS = Set.of(Color.WHITE, Color.BLUE);

	// TODO
	static final List<String> LIST_EXAMPLE = List.of("Wildspitze", "Matterhorn");

	static final Map<String, Integer> PEAK_ELEVATIONS = Map.of( //
			"Mauna Key", 4205, //
			"Matterhorn", 4478, //
			"Makalu", 8485);

	public static void main(String[] args) {

		System.out.println("Is the empty set empty? " + EMPTY_SET.isEmpty());

		System.out.println("The elevation of Matterhorn is " + PEAK_ELEVATIONS.get("Matterhorn"));

		// Invalid usages:

		try {
			List.of("null", null);
		} catch (NullPointerException e) {
			System.out.println("null is not allowed in constant collections.");
		}

		try {
			Set.of("same", "same");
		} catch (IllegalArgumentException e) {
			System.out.println("Duplicate entries are not allowed for contant sets.");
		}

		try {
			Map.of("key", 1, "key", 2);
		} catch (IllegalArgumentException e) {
			System.out.println("Duplicate keys are not allowed for contant maps.");
		}

	}

}
