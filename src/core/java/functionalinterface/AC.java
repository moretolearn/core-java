package core.java.functionalinterface;

interface AI {
	void display();

	default void dispaly1() {
		System.out.println("This is functional interface display1 method");
	}

	static void dispaly2() {
		System.out.println("This is functional interface display2 method");
	}
}

class AC1 implements AI {

	@Override
	public void display() {
		System.out.println("This is functional interface display1 method from AC1");
	}

	@Override
	public void dispaly1() {
		AI.super.dispaly1();
		System.out.println("This is functional interface display1 method from AC1");
	}

	public static void main(String[] args) {
		AI ai = new AC1();
		ai.display();
		ai.dispaly1();
		AI.dispaly2();
	}

}

public class AC {

	public static void main(String[] args) {
		AI ai = () -> {
			System.out.println("This is functional interface display method");
		};

		ai.display();

		ai.dispaly1();

		AI.dispaly2();
	}

}
