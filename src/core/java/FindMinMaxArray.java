package core.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindMinMaxArray {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 7, 3, 7, 5, 9, 4 };
//		int[] findMinMaxValue = FindMinMaxArray.findMinMaxValue1(arr);
//		for (int i = 0; i < findMinMaxValue.length; i++) {
//			System.out.println(findMinMaxValue[i]);
//		}
		FindMinMaxArray.findMinMaxValue(arr);
	}

	static int[] findMinMaxValue1(int arr[]) {
		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			} else if (max < arr[i]) {
				max = arr[i];
			}
		}
		int mm[] = { min, max };
		return mm;
	}

	static void findMinMaxValue(int arr[]) {
		Collector collector = Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(String::length)),
				s -> s.orElse("?"));
		Comparator reversed = Comparator.comparing(String::valueOf).reversed();
		Integer max = Arrays.stream(arr).boxed().max(Comparator.comparing(Integer::valueOf)).get();
		System.err.println(max);
		Integer min = Arrays.stream(arr).boxed().min(Comparator.comparing(Integer::valueOf)).get();
		System.err.println(min);

		Integer max1 = Arrays.stream(arr).boxed().max(Integer::compare).get();
		System.err.println(max1);

		Integer min1 = Arrays.stream(arr).boxed().min(Integer::compare).get();
		System.err.println(min);

		int asMax = Arrays.stream(arr).max().getAsInt();
		System.err.println(asMax);
		int asMin = Arrays.stream(arr).min().getAsInt();
		System.err.println(asMin);

		boolean anyMatch = Arrays.stream(arr).anyMatch(n -> n == 9);

		double asDouble = Arrays.stream(arr).average().getAsDouble();
	}
}
