package io.javaalmanac.snippets;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class ConsoleGrabber {

	public interface MainMethod<T> {
		void main(T instance) throws Exception;
	}

	private static final Charset ENC = StandardCharsets.UTF_8;

	private final ByteArrayOutputStream content = new ByteArrayOutputStream();

	private final PrintStream out = new PrintStream(content, false, ENC);

	@SafeVarargs
	public final <T> void run(MainMethod<T> main, T... type) throws Exception {
		PrintStream origout = System.out;
		System.setOut(out);
		try {
			@SuppressWarnings("unchecked")
			T instance = (T) type.getClass().getComponentType().getConstructor().newInstance();
			main.main(instance);
			out.flush();
		} finally {
			System.setOut(origout);
		}
	}

	public String content() {
		return new String(content.toByteArray(), ENC);
	}

	public List<String> lines() {
		return Arrays.asList(content().split("\n"));
	}

	public void assertOutEquals(String expected) {
		Assertions.assertEquals(expected, content());
	}

	@SafeVarargs
	public static <T> void assertOutEquals(MainMethod<T> main, String expected, T... type) throws Exception {
		ConsoleGrabber grabber = new ConsoleGrabber();
		grabber.run(main, type);
		grabber.assertOutEquals(expected);
	}

}
