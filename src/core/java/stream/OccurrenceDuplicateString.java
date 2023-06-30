package core.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurrenceDuplicateString {
	public static void main(String[] args) {
		String name = "rammohanreddyyanumula";

		List<String> asList1 = Arrays.asList(name.split(""));

		List<String> of = List.of(name);

		List<Integer> asList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		// Find the occurrence
		Map<Integer, Long> map = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		// Find the duplicates - 1
		Set<Integer> duplicates = asList.stream().filter(n -> Collections.frequency(asList, n) > 1)
				.collect(Collectors.toSet());
		System.out.println("duplicates - 1: " + duplicates);

		// Find the unique - 1
		Set<Integer> unique = asList.stream().filter(n -> Collections.frequency(asList, n) == 1)
				.collect(Collectors.toSet());
		System.out.println("unique - 1 : " + unique);

		// Find the duplicates - 2
		List<Integer> duplicates1 = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(n -> n.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("duplicates - 2: " + duplicates1);

		// Find the unique - 2
		List<Integer> unique1 = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(n -> n.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("unique - 1 : " + unique1);

		// Find the Non reaped first element - 2
		Integer reaped = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(n -> n.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println("Non Repeated " + reaped);

		// Find the reaped first element - 2
		Integer reapedSe = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(n -> n.getValue() > 1).map(Map.Entry::getKey).skip(1).findFirst().get();
		System.out.println("Repeated " + reapedSe);

		Map<String, Long> collect = name.chars().mapToObj(n -> (char) n)
				.collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
		System.out.println(collect);

		Map<Character, Long> d = name.chars().mapToObj(n -> Character.valueOf((char) n))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(d);
		Set<Integer> distinct = asList.stream().distinct().collect(Collectors.toSet());

		System.out.println(distinct);
	}
}
