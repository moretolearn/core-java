package core.java.stream;

import java.util.Arrays;
import java.util.Comparator;

public class NthHighestLowestArray {

	public static void main(String[] args) {
		int arr[] = { 2, 9, 4, 7, 8, 6, 3, 8, 1, 3 };

		// Find Second Highest
		Integer secondHighest = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondHighest);

		// Find Second Lowest
		Integer secondLowest = Arrays.stream(arr).boxed().sorted().skip(1).findFirst().get();
		System.out.println(secondLowest);

	}

}
