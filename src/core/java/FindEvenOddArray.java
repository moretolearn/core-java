package core.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindEvenOddArray {

	public static void main(String[] args) {
		int arr[] = {1,3,2,6,4,8,6,9};
		long start = System.currentTimeMillis();
		FindEvenOddArray.findEvenOddArray(arr);
		System.out.println(System.currentTimeMillis()-start);
	}
	
	static void findEvenOddArray(int arr[]) {
		
		List<Integer> even = Arrays.stream(arr).boxed().filter(n->n%2==0).collect(Collectors.toList());
		List<Integer> odd = Arrays.stream(arr).boxed().filter(n->n%2!=0).collect(Collectors.toList());
		even.addAll(odd);
		System.err.println(even);
	}
	
	static void findEvenOddArray1(int arr[]) {
		int intdex = 0;
		int a[] = new int[arr.length];
		for (int i = 0; i < a.length; i++) {
			if(arr[i]%2==0) {
				a[intdex] = arr[i];
				intdex++;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if(arr[i]%2!=0) {
				a[intdex] = arr[i];
				intdex++;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.err.print(a[i]+" ");
		}
	}
}
