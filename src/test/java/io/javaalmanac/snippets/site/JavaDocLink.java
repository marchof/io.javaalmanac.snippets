package io.javaalmanac.snippets.site;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

class JavaDocLink {

	private static final String JAVADOC_BASE = "https://docs.oracle.com/en/java/javase/17/docs/api/";

	private static final String CLASS_LINK = JAVADOC_BASE + "%s/%s.html";

	private final String label;
	private final String link;

	private JavaDocLink(String label, String link) {
		this.label = label;
		this.link = link;
	}

	String getLabel() {
		return label;
	}

	String getLink() {
		return link;
	}

	static JavaDocLink of(String ref) {
		if (ref.contains("#")) {
			return ofMethod(ref);
		}
		return ofClass(ref);
	}

	private static JavaDocLink ofClass(String ref) {
		Class<?> c = getJDKClass(ref);
		String label = c.getSimpleName();
		String link = CLASS_LINK.formatted(c.getModule().getName(), c.getName().replace('.', '/'));
		return new JavaDocLink(label, link);
	}

	private static JavaDocLink ofMethod(String ref) {
		int seppos = ref.indexOf('#');
		Class<?> c = getJDKClass(ref.substring(0, seppos));
		for (Method m : c.getDeclaredMethods()) {
			if (!m.isSynthetic()) {
				String anchor = getMethodAnchor(m);
				if (ref.endsWith(anchor)) {
					String link = CLASS_LINK.formatted(c.getModule().getName(), c.getName().replace('.', '/'));
					String label = String.format("%s.%s()", c.getSimpleName(), m.getName());
					return new JavaDocLink(label, link + anchor);
				}
			}
		}
		throw new IllegalArgumentException("Unresolveable platform method name: " + ref);
	}

	private static String getMethodAnchor(Method m) {
		String params = Arrays.stream(m.getParameterTypes()) //
				.map(Class::getName) //
				.collect(Collectors.joining(","));
		return String.format("#%s(%s)", m.getName(), params);

	}

	private static Class<?> getJDKClass(String name) {
		try {
			return Class.forName(name, false, ClassLoader.getPlatformClassLoader());
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Unresolveable platform class name: " + name);
		}
	}
}
