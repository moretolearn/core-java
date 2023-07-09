package core.java.stream;

import java.util.ArrayList;
import java.util.List;

class Employees {
	String name;
	int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employees(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
}

public class ParallelStream {

	public static void main(String[] args) {

		long t1, t2;
		List<Employees> eList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			eList.add(new Employees("A", 20000));
			eList.add(new Employees("B", 3000));
			eList.add(new Employees("C", 15002));
			eList.add(new Employees("D", 7856));
			eList.add(new Employees("E", 200));
			eList.add(new Employees("F", 50000));
		}

		/***** Here We Are Creating A 'Sequential Stream' & Displaying The Result *****/
		t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream Count?= " + eList.stream().filter(e -> e.getSalary() > 15000).count());

		t2 = System.currentTimeMillis();
		System.out.println("Sequential Stream Time Taken?= " + (t2 - t1) + "\n");

		/***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
		t1 = System.currentTimeMillis();
		System.out.println(
				"Parallel Stream Count?= " + eList.parallelStream().filter(e -> e.getSalary() > 15000).count());

		t2 = System.currentTimeMillis();
		System.out.println("Parallel Stream Time Taken?= " + (t2 - t1));

		/*****
		 * Here We Are Creating A 'Parallel Stream with Collection.stream.parallel' &
		 * Displaying The Result
		 *****/
		t1 = System.currentTimeMillis();
		System.out.println(
				"stream().parallel() Count?= " + eList.stream().parallel().filter(e -> e.getSalary() > 15000).count());

		t2 = System.currentTimeMillis();
		System.out.println("stream().parallel() Time Taken?= " + (t2 - t1));

	}

}
