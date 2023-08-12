package core.java.interfaces;

class MethodOverriding1 {

	void display() {
		System.err.println("MethodOverriding1");
	}
	
	static void display1() {
		System.err.println("MethodOverriding1");
	}
}

class MethodOverriding2 extends MethodOverriding1{
	void display() {
		System.err.println("MethodOverriding2");
	}
	
	static void display1() {
		System.err.println("MethodOverriding1");
	}
}

public class Main{
	public static void main(String[] args) {
		MethodOverriding1 m1 = new MethodOverriding2();
		
		m1.display();
	}
}