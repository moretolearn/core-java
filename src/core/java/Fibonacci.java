package core.java;

public class Fibonacci {

	public static void main(String[] args) {
		int fibonacci1 = Fibonacci.fibonacci1(10);
		System.out.println(fibonacci1);
	}
	
	static void fibonacci(int count) {
		int n1=0,n2=1,n3;
		for (int i = 0; i < count; i++) {
			n3 = n1 + n2;
			System.err.println(n3);
			n1=n2;
			n2=n3;
		}
	} 
	
	static int fibonacci1(int count) {
//		if(count == 0) {return 0;}
		if(count==0||count==1) {return count;}else {
			return fibonacci1(count-1)+fibonacci1(count-2);
		}
		
	} 
}
