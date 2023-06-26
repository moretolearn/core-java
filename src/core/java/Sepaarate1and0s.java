package core.java;

public class Sepaarate1and0s {
	
	public static void main(String[] args) {
		int arr[] = {1,0,1,0,0,1,1};
		Sepaarate1and0s.sepaarate1and0s(arr);
		for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);	
		}
	}
	
	
	static void sepaarate1and0s(int arr[]){
		int left = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0) {
				int temp = arr[left];
				arr[left]  = arr[i];
				arr[i] = temp;
				left++;
			}
		}
	}
}
