package io.javaalmanac.snippets.function;

import static java.util.function.Predicate.not;

import java.util.List;

/**
 * With the static method
 * {@link java.util.function.Predicate#not(java.util.function.Predicate)} we can
 * invert conditions. This is particular useful in combination with method
 * references.
 * 
 * @title Not Predicate
 * @category api.function
 * @since 11
 */
public class NotPredicate {

	void main() {

		List.of("", "venus", "   ", "mars", " ", "earth") //
				.stream() //
				.filter(not(String::isBlank)) //
				.forEach(IO::println);

	}

}
