package core.java.stream;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NthHighestLowestMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("ram", "9000");
		map.put("mohan", "2000");
		map.put("reddy", "9000");
		map.put("yanumula", "5000");
		map.put("venkata", "5000");

		Entry<String, String> entry = map.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).skip(1).findFirst().get();
		System.err.println(entry);

		LinkedHashMap<String, String> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (n1, n2) -> n2, LinkedHashMap::new));
		System.err.println(collect);

		String entry3 = map.entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue,
						Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).map(Map.Entry::getKey)
				.collect(Collectors.toList()).get(0);
		System.err.println(entry3);

		List<Entry<String, List<String>>> collect1 = map.entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getKey,
						Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList());

		System.err.println(collect1);
		
		List<Entry<String, List<String>>> collect3 = map.entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getKey,
						Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList());

		System.err.println(collect3);

		List<Entry<String, String>> collect2 = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());
//		System.err.println(collect2);
		
		Map<String, List<String>> collect4 = map.entrySet().stream()
		.collect(Collectors.groupingBy(Map.Entry::getKey,
				Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
		
		System.out.println(collect4);

	}
}
