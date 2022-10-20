package io.javaalmanac.snippets.site;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class Generator {

	private static final Charset MD_ENCODING = StandardCharsets.UTF_8;

	private static final Path SRC_FOLDER = Paths.get("./src/main/java/io/javaalmanac/snippets");

	private static final String JAVA_EXT = ".java";

	private static final String MD_TEMPLATE = """
			---
			title: %s
			type: sandbox
			---

			%s

			Since [Java %s](/jdk/%s/)

			{{< sandbox version="java17" mainclass="%s" >}}
			{{< sandboxsource "%s" >}}
			%s
			{{< /sandboxsource >}}
			{{< /sandbox >}}

			This [snippet at GitHub](%s)
			""";

	private static List<Function<SnippetSource, String>> VALUE_EXTRACTORS = List.of( //
			SnippetSource::getTitle, //
			SnippetSource::getDescription, //
			SnippetSource::getSince, //
			SnippetSource::getSince, //
			SnippetSource::getMainName, //
			SnippetSource::getSourceName, //
			SnippetSource::loadPlainSource, //
			SnippetSource::getGitHubLink);

	private static void addExample(Path srcfile, Path snippetsdir) {
		try {
			var source = new SnippetSource(srcfile);
			Path outpath = snippetsdir
					.resolve(SRC_FOLDER.relativize(srcfile).toString().replace(JAVA_EXT, ".md").toLowerCase());
			String content = MD_TEMPLATE.formatted(VALUE_EXTRACTORS.stream().map(e -> e.apply(source)).toArray());

			Files.writeString(outpath, content, MD_ENCODING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		Path sitedir = Paths.get(args[0]);
		Path snippetsdir = sitedir.resolve("content/snippets");
		Files.walk(SRC_FOLDER) //
				.filter(Files::isRegularFile) //
				.filter(p -> p.toString().endsWith(JAVA_EXT)) //
				.forEach(p -> addExample(p, snippetsdir));

	}

}
