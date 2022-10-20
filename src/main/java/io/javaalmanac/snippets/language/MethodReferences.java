package io.javaalmanac.snippets.language;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * Functional interface instances can be directly created from methods and
 * constructors.
 * 
 * @title Method References
 * @category language
 * @since 8
 */
public class MethodReferences {

	static class Foo {

		Foo() {
			System.out.println("constructor");
		}

		void instanceMethod() {
			System.out.println("instanceMethod");
		};

		void instanceMethod(String parameter) {
			System.out.println("instanceMethod " + parameter);
		};

		static void classMethod() {
			System.out.println("classMethod");
		};

	}

	public static void main(String[] args) {

		// Constructor as reference
		Supplier<Foo> supplier = Foo::new;
		Foo foo = supplier.get();

		// Bound instance method as reference
		Runnable runnable = foo::instanceMethod;
		runnable.run();

		// Unbound instance method as reference
		Consumer<Foo> consumer = Foo::instanceMethod;
		consumer.accept(foo);

		// Unbound instance method with parameter as reference
		BiConsumer<Foo, String> biconsumer = Foo::instanceMethod;
		biconsumer.accept(foo, "hello");

		// Class method as reference
		Runnable runnable2 = Foo::classMethod;
		runnable2.run();

		// Array constructor as reference
		IntFunction<Foo[]> function = Foo[]::new;
		Foo[] array = function.apply(42);
		System.out.println(array.length);

	}

}
