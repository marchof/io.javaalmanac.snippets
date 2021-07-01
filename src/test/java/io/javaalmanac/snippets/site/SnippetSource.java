package io.javaalmanac.snippets.site;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.tools.DocumentationTool;
import javax.tools.DocumentationTool.DocumentationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.EndElementTree;
import com.sun.source.doctree.LinkTree;
import com.sun.source.doctree.SinceTree;
import com.sun.source.doctree.StartElementTree;
import com.sun.source.doctree.TextTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import com.sun.source.util.DocTreeScanner;
import com.sun.source.util.DocTrees;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;

public class SnippetSource {

	private static final Set<String> JAVA_VERSIONS = //
			Set.of("1.4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17");

	private static final Charset SOURCE_ENCODING = StandardCharsets.UTF_8;

	private static final Pattern JAVADOC_PATTERN = //
			Pattern.compile("[ \\t]*/\\*\\*(?s:(?!\\*/).)*\\*/\\n", Pattern.DOTALL);

	private static final Pattern PACKAGE_PATTERN = //
			Pattern.compile("package[^;]*;\\n", Pattern.DOTALL);

	private static final ThreadLocal<SnippetSource> CURRENT = new ThreadLocal<>();

	private final Path srcpath;

	private String title;

	private String since;

	private String description;

	public SnippetSource(Path srcpath) {
		this.srcpath = srcpath;
		CURRENT.set(this);
		DocumentationTool doctool = ToolProvider.getSystemDocumentationTool();
		StandardJavaFileManager fileManager = doctool.getStandardFileManager(null, Locale.ENGLISH, SOURCE_ENCODING);
		Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjects(srcpath);
		DocumentationTask task = doctool.getTask(null, fileManager, null, ExampleGenerator.class,
				Collections.emptySet(), files);
		task.call();

		assertTag(title != null, "Title must be specified");
		assertTag(JAVA_VERSIONS.contains(since), "Valid since tag must be specified");
	}

	private void assertTag(boolean condition, String msg) {
		if (!condition) {
			throw new IllegalArgumentException(msg + " in " + srcpath);
		}
	}

	public String getMainName() {
		return srcpath.getFileName().toString().replace(".java", "");
	}

	public String getSourceName() {
		return srcpath.getFileName().toString();
	}

	public String getTitle() {
		return title;
	}

	public String getSince() {
		return since;
	}

	public String getDescription() {
		return description;
	}

	public String getGitHubLink() {
		return "https://github.com/marchof/io.javaalmanac.snippets/tree/master" + srcpath.toString().substring(1);
	}

	/**
	 * Loads the source without JavaDoc
	 */
	public String loadPlainSource() {
		try {
			var src = Files.readString(srcpath, SOURCE_ENCODING);
			src = remove(src, JAVADOC_PATTERN);
			src = remove(src, PACKAGE_PATTERN);
			return src;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String remove(String src, Pattern pattern) {
		return pattern.matcher(src).replaceAll("");
	}

	public static class ExampleGenerator implements Doclet {

		@Override
		public String getName() {
			return getClass().getSimpleName();
		}

		@Override
		public Set<? extends Option> getSupportedOptions() {
			return Set.of();
		}

		@Override
		public SourceVersion getSupportedSourceVersion() {
			return SourceVersion.RELEASE_17;
		}

		@Override
		public void init(Locale locale, Reporter reporter) {
		}

		@Override
		public boolean run(DocletEnvironment environment) {
			DocTrees trees = environment.getDocTrees();
			for (var e : environment.getIncludedElements()) {
				if (ElementKind.CLASS.equals(e.getKind())) {
					TypeElement type = (TypeElement) e;
					if (NestingKind.TOP_LEVEL.equals(type.getNestingKind())) {
						processExampleTypeDoc(trees.getDocCommentTree(type), CURRENT.get());
					}
				}
			}
			return true;
		}

		private void processExampleTypeDoc(DocCommentTree tree, SnippetSource source) {
			source.description = tree.accept(new Visitor(), source);
		}

		static class Visitor extends DocTreeScanner<String, SnippetSource> {

			public String visitDocComment(DocCommentTree node, SnippetSource src) {
				scan(node.getBlockTags(), src);
				return scan(node.getFullBody(), src);
			}

			@Override
			public String visitText(TextTree node, SnippetSource src) {
				return node.getBody();
			}

			@Override
			public String visitStartElement(StartElementTree node, SnippetSource src) {
				switch (node.toString()) {
				case "<code>":
					return "`";
				}
				return "";
			}

			@Override
			public String visitEndElement(EndElementTree node, SnippetSource src) {
				switch (node.toString()) {
				case "</code>":
					return "`";
				}
				return "";
			}

			@Override
			public String visitLink(LinkTree node, SnippetSource src) {
				var link = JavaDocLink.of(node.getReference().toString());
				return "[`" + link.getLabel() + "`](" + link.getLink() + ")";
			}

			// Block Tags

			@Override
			public String visitSince(SinceTree node, SnippetSource src) {
				src.since = node.getBody().toString();
				return null;
			}

			@Override
			public String visitUnknownBlockTag(UnknownBlockTagTree node, SnippetSource src) {
				switch (node.getTagName().toString()) {
				case "title":
					src.title = node.getContent().toString();
					break;
				}
				return null;
			}

			@Override
			public String reduce(String r1, String r2) {
				return r2 + r1;
			}

		}

	}

}
