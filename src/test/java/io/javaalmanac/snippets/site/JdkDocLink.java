package io.javaalmanac.snippets.site;

import io.javaalmanac.javadoclink.JavaDocLink;

class JdkDocLink {

	private static final JavaDocLink JAVADOC = JavaDocLink //
			.forVersion("17") //
			.withBaseUrl("https://docs.oracle.com/en/java/javase/17/docs/api/");

	private final String label;
	private final String link;

	private JdkDocLink(String label, String link) {
		this.label = label;
		this.link = link;
	}

	String getLabel() {
		return label;
	}

	String getLink() {
		return link;
	}

	static JdkDocLink of(String ref) {
		if (ref.contains("#")) {
			return ofMethod(ref);
		}
		return ofClass(ref);
	}

	private static JdkDocLink ofClass(String ref) {
		var c = getJDKClass(ref);
		return new JdkDocLink(c.getSimpleName(), JAVADOC.classLink(c));
	}

	private static JdkDocLink ofMethod(String ref) {
		int seppos = ref.indexOf('#');
		var c = getJDKClass(ref.substring(0, seppos));
		for (var m : c.getDeclaredMethods()) {
			if (!m.isSynthetic()) {
				String link = JAVADOC.methodLink(m);
				if (link.endsWith(ref.substring(seppos))) {
					String label = String.format("%s.%s()", c.getSimpleName(), m.getName());
					return new JdkDocLink(label, link);
				}
			}
		}
		throw new IllegalArgumentException("Unresolveable platform method name: " + ref);
	}

	private static Class<?> getJDKClass(String name) {
		try {
			return Class.forName(name, false, ClassLoader.getPlatformClassLoader());
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Unresolveable platform class name: " + name);
		}
	}

}
