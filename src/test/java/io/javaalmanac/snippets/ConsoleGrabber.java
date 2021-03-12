package io.javaalmanac.snippets;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class ConsoleGrabber {

	public interface MainMethod {
		void main(String... args) throws Exception;
	}

	private static final Charset ENC = StandardCharsets.UTF_8;

	private final ByteArrayOutputStream content = new ByteArrayOutputStream();

	private final PrintStream out = new PrintStream(content, false, ENC);

	public void run(MainMethod main) throws Exception {
		PrintStream origout = System.out;
		System.setOut(out);
		try {
			main.main();
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

	public static void assertOutEquals(MainMethod main, String expected) throws Exception {
		ConsoleGrabber grabber = new ConsoleGrabber();
		grabber.run(main);
		grabber.assertOutEquals(expected);
	}

}
