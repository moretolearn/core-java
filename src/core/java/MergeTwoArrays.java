package core.java;

public class MergeTwoArrays {

	public static void main(String[] args) {
		int arr1[]= {2,4,6,2,5,8,4};
		int arr2[] = {1,4,7,2,5,9,0,4};
		int[] mergeArrays = MergeTwoArrays.mergeArrays(arr1, arr2);
		for (int i = 0; i < mergeArrays.length; i++) {
			System.out.println(mergeArrays[i]);
		}
	}
	
	static int[] mergeArrays(int arr1[],int arr2[]){
		int arr[] = new int[arr1.length+arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			arr[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			arr[arr1.length+i] = arr2[i];
		}
		return arr;
	}
}
