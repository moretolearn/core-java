package core.java.stream;

import java.util.Arrays;

public class LongestString {
	
	public static void main(String[] args) {
		String arr[]  = {"ram","mohan","reddy","yanumula"};
		
		//Find the Highest String
		String longestString = Arrays.stream(arr).reduce((a,b)->a.length()>b.length()?a:b).get();
		System.out.println(longestString);
		
		// Find the Lowest String
		String lowestString = Arrays.stream(arr).reduce((a,b)->a.length()<b.length()?a:b).get();
		System.out.println(lowestString);
	}

}
