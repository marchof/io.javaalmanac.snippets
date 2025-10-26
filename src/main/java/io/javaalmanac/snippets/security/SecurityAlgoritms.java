package io.javaalmanac.snippets.security;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;

import java.security.Provider.Service;
import java.security.Security;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * The JDK comes with a long list of cryptographic algorithms for different
 * {@link java.security.Provider$Service} types. This snippet lists all service
 * types together with the algorithms implemented in the current JDK.
 * 
 * @title JDK Security Algorithms
 * @category api.security
 * @since 1.1
 */
public class SecurityAlgoritms {

	Stream<Service> getAllSecurityServices() {
		return Arrays.stream(Security.getProviders()).flatMap(p -> p.getServices().stream());
	}

	void main() {

		var grouped = getAllSecurityServices().collect(
				// Group algorithms by type
				groupingBy(Service::getType,
						// Sort types and algorithms using tree collections
						TreeMap::new, mapping(Service::getAlgorithm, toCollection(TreeSet::new))));

		grouped.forEach((type, algorithms) -> {
			IO.println(type);
			algorithms.forEach(a -> IO.println("* " + a));
		});

	}

}
