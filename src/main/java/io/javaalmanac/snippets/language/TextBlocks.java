package io.javaalmanac.snippets.language;

/**
 * Text blocks allow multiline strings literals.
 * 
 * @title Text Blocks
 * @category language
 * @since 15
 */
public class TextBlocks {

	static final String LINK_TEMPLATE = """
			<a href="%s">Click here!</a>""";

	void main() {

		// Text blocks always start with three double quotes and a new line:
		String greeting = """
				Hello
				"World"!
				""";

		System.out.println(greeting);

		System.out.println(LINK_TEMPLATE.formatted("https://javaalmanac.io/"));
	}

}
