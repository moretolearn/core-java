package core.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDublicatesString {

	public static void main(String[] args) {
		String value = "MADAM";
		HashMap<Character, Integer> findDublicates1 = FindDublicatesString.findDublicates1(value);
//		System.out.println(findDublicates1);
		FindDublicatesString.findDublicates5(value);
	}

	static void findDublicates(String value) {
		Map<String, Long> collect = value.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
		for (Map.Entry<String, Long> entry : collect.entrySet()) {
			if (entry.getValue() > 1) {
				System.err.println(entry.getKey() + " : " + entry.getValue());
			} else {
				System.err.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}

	static HashMap<Character, Integer> findDublicates1(String value) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < value.length(); i++) {
			char charAt = value.charAt(i);
			if (hashMap.containsKey(charAt)) {
				hashMap.put(charAt, hashMap.get(charAt) + 1);
			} else {
				hashMap.put(charAt, 1);
			}
		}
		return hashMap;
	}

	static void findDublicates5(String value) {
		HashSet<Character> uniques = new HashSet<>();
		Set<Character> duplicates = value.chars().mapToObj(i -> (char) i).filter(f -> !uniques.add(f))
				.collect(Collectors.toSet());
		System.out.println(uniques);
		System.out.println(duplicates);
	}
}
