package core.java;

//Java code for the approach

import java.util.*;

public class FindPositiveNegitiveNumbers {
	// Function to find the largest
	// number k such that both k and
	// -k are present in the array
	static int largestNum(ArrayList<Integer> arr, int n)
	{
		// to store maximum k
		int maxK = 0;

		// loop through all elements and find it's negative
		// in array after it's index
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// if found and is greater than previous
				// maxK then update maxK with it
				if (arr.get(i) == -arr.get(j)
					&& Math.abs(arr.get(i)) > maxK)
					maxK = Math.abs(arr.get(i));
			}
		}

		return maxK;
	}

	// Driver Code
	public static void main(String[] args)
	{
		// Input array
		ArrayList<Integer> arr = new ArrayList<>(
			Arrays.asList(3, 1, -2, 5, 3));
		int n = arr.size();

		// Function Call
		System.out.println(largestNum(arr, n));
	}
	
}

