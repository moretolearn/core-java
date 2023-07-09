package core.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SortingPrimitiveObjects {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2, 8, 3, 2, 5, 21, 7, 9, 4, 6);
		List<Integer> listPritiveObjectsAes = list.stream().sorted().collect(Collectors.toList());
		System.out.println(listPritiveObjectsAes);
		List<Integer> listPritiveObjectsDesc = list.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(listPritiveObjectsDesc);

		List<Integer> linkedList = new LinkedList<>(list);

		List<Integer> linkedListPritiveObjectsAes = linkedList.stream().sorted().collect(Collectors.toList());
		System.out.println(linkedListPritiveObjectsAes);

		List<Integer> linkedListPritiveObjectsDesc = linkedList.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(linkedListPritiveObjectsDesc);

		// Set

		Set<Integer> set = new HashSet<>(list);
		Set<Integer> setPritiveObjectsAes = set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(setPritiveObjectsAes);

		Set<Integer> setPritiveObjectsDesc = set.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(setPritiveObjectsDesc);

		Set<Integer> linkedhashSet = new LinkedHashSet<>(set);
		Set<Integer> linkedhashSetPrimitiveObjectsAes = linkedhashSet.stream().sorted()
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(linkedhashSetPrimitiveObjectsAes);

		Set<Integer> linkedhashSetPrimitiveObjectsDesc = linkedhashSet.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(linkedhashSetPrimitiveObjectsDesc);

		Set<Integer> treeSet = new TreeSet<>(set);
		Set<Integer> treeSetPrimitiveObjectsAes = treeSet.stream().sorted()
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(treeSetPrimitiveObjectsAes);

		Set<Integer> treeSetPrimitiveObjectsDesc = treeSet.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(treeSetPrimitiveObjectsDesc);

		// Map

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 4);
		map.put(5, 2);
		map.put(3, 6);
		map.put(6, 9);
		map.put(4, 5);
		map.put(2, 1);

		Map<Integer, Integer> mapPrimitiveObjectsAes = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(mapPrimitiveObjectsAes);

		Map<Integer, Integer> mapPrimitiveObjectsDesc = map.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(mapPrimitiveObjectsDesc);

		Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>(map);

		Map<Integer, Integer> linkedHashMapPrimitiveObjectsAes = linkedHashMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(linkedHashMapPrimitiveObjectsAes);

		Map<Integer, Integer> linkedHashMapPrimitiveObjectsDesc = linkedHashMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(linkedHashMapPrimitiveObjectsDesc);

		Map<Integer, Integer> treeMap = new TreeMap<>(linkedHashMap);

		Map<Integer, Integer> treeMapPrimitiveObjectsAes = treeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(treeMapPrimitiveObjectsAes);

		Map<Integer, Integer> treeMapPrimitiveObjectsDesc = treeMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(treeMapPrimitiveObjectsDesc);
		
		Map<Integer, Integer> hashtable = new Hashtable<>(map);
		
		Map<Integer, Integer> hashtablePrimitiveObjectsAes = hashtable.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(hashtablePrimitiveObjectsAes);

		Map<Integer, Integer> hashtablePrimitiveObjectsDesc = hashtable.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(hashtablePrimitiveObjectsDesc);

	}

}
