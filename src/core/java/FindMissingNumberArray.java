package core.java;

import java.util.Arrays;

public class FindMissingNumberArray {

	public static void main(String[] args) {
		int arr[] = new int[] {2,3,4};
		int missingNo = FindMissingNumberArray.getMissingNo1(arr);
		System.err.println(missingNo);
	}
	
	
	static void findMissingNumberArray(int arr[]) {
		int sumA = 0;
		int sum = (arr[arr.length-1])*(arr[arr.length-1]+1)/2;
//		System.err.println(arr[arr.length-1]);
//		int sum = (9*10)/2;
		System.err.println(sum);
		for (int i = 0; i < arr.length; i++) {
			sumA = sumA + arr[i];
		}
		System.err.println(sum - sumA);
	}
	
	static int getMissingNo(int[] nums)
    {
        int sum = ((nums.length + 1) * (nums.length + 2)) / 2;
        for (int i = 0; i < nums.length; i++)
            sum -= nums[i];
        return sum;
    }
	
	static int getMissingNo1(int[] nums)
    {
		int max = Arrays.stream(nums).max().getAsInt();
		int sum = max*(max+1)/2;
		int actualSum = Arrays.stream(nums).sum();
		return sum -actualSum;
        
    }
}
