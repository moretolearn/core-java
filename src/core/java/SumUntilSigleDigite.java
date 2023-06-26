package core.java;

public class SumUntilSigleDigite {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sumUntilSingleDigite = SumUntilSigleDigite.sumUntilSingleDigite(123);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(sumUntilSingleDigite);
	}

	static int sumUntilSingleDigite(int n) {
		int sum = 0;
		while (n > 0 || sum > 9) {
			if (n == 0) {
				n = sum;
				sum = 0;
			}
			sum = sum + n % 10;
			n = n / 10;
		}
		return sum;
	}
}
