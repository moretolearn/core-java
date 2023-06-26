package core.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDublicateArray {

	public static void main(String[] args) {
		
		Set<Integer> uniques = new HashSet<>();
		
		List<Integer> asList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		Set<Integer> collect = asList.stream().filter(n-> !uniques.add(n)).collect(Collectors.toSet());
		
		System.out.println(uniques);
		System.out.println(collect);
		
      int arr[] = {2,5,3,4,2,6,4,5,4,9,3,2};
      long start = System.currentTimeMillis();
      FindDublicateArray.findDublicates(arr);
      System.out.println(System.currentTimeMillis()-start);
	}

	static void findDublicates(int arr[]){
		Stream<Integer> boxed = Arrays.stream(arr).boxed();
		Map<Integer, Long> collect = boxed.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		for (Map.Entry<Integer, Long> entry : collect.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + "s : " + entry.getValue());
			} else {
//				System.out.println(entry.getKey() + "s : " + entry.getValue());
			}
		}
	}
	
	static void findDublicates1(int arr[]) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			if (hashMap.containsKey(a)) {
				hashMap.put(a, hashMap.get(a) + 1);
			} else {
				hashMap.put(a, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + "s : " + entry.getValue());
			} else {
//				System.out.println(entry.getKey() + "s : " + entry.getValue());
			}
		}
	}
}
