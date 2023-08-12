package core.java.interview;

class TestClass {

	public static void main(String[] args) {

		print(null);

	}

	public static void print(Object o) {
		System.out.println("Object -> " + o);
	}

	public static void print(String s) {
		System.out.println("String -> " + s);
	}

//	public static void print(Integer s) {
//		System.out.println("Integer -> " + s);
//	}

}
