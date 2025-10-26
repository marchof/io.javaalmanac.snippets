package io.javaalmanac.snippets.util;

import java.util.Optional;

/**
 * Instead of passing using `null` references optional values can be wrapped in
 * a {@link java.util.Optional} instances. This type is typically used in APIs
 * to express the possibility that a method may not return a value, for example
 * {@link java.util.stream.Stream#max(java.util.Comparator)} may not have a
 * return value on an empty stream.
 *
 * The `Optional` type is designed to be used in a functional way: It owns the
 * control flows, we simply declare what to do if a value is present or missing.
 * If you find yourself writing code like `if (optional.isPresent()) { ... }` or
 * you are calling {@link java.util.Optional#get()} you're most likely on the
 * wrong track.
 * 
 * @title Optional Values
 * @category api.util
 * @since 8
 */
public class OptionalValues {

	void work(Optional<String> task) {

		// Obtain a fixed default
		var myTask1 = task.orElse("Clean the kitchen.");
		IO.println(myTask1);

		// Calculate the default value if required
		var myTask2 = task.orElseGet(this::createTask);
		IO.println(myTask2);

		// Perform an operation if a value exist:
		task.ifPresent(IO::println);

		// Perform an operation if a value exist or do something else:
		task.ifPresentOrElse(IO::println, this::idle);

		// The optional value can be mapped (if it exists):
		task.map(String::toUpperCase).ifPresent(IO::println);

		// The optional value can be filtered (if it exists):
		task.filter(t -> t.contains("coding")).ifPresent(IO::println);

	}

	String createTask() {
		return "Find random Task.";
	}

	void idle() {
		IO.println("Just lazy today.");
	}

	void main() {
		IO.println("Our task today:");
		work(Optional.of("Do some coding."));

		IO.println("No Task today:");
		work(Optional.empty());
	}

}
