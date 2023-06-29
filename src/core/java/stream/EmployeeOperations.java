package core.java.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeOperations {

	public static void main(String[] args) {
//		List<Employee> m1 = new ArrayList<>();
//		List<Employee> m2 = new ArrayList<>();
//		List<Employee> m3 = new ArrayList<>();
//		Map<Manager, List<Employee>> hashMap = new HashMap<>();
//		Map<Manager, List<Employee>> data = EmployeeSData.getData();
//		
//		List<Employee> collect = data.entrySet().stream().map(Map.Entry::getValue).map(n -> n.get(0))
//				.filter(n -> n.getSalary() < 10000).collect(Collectors.toList());
//		data.forEach((k, v) -> {
//			
//			List<Employee> collect2 = v.stream().filter(n -> n.getSalary() < 10000).collect(Collectors.toList());
//			List<Employee> collect3 = v.stream().filter(n -> n.getSalary() > 10000 && n.getSalary() < 20000)
//					.collect(Collectors.toList());
//			List<Employee> collect4 = v.stream().filter(n -> n.getSalary() > 20000).collect(Collectors.toList());
//						
//		});
//		
//		
//
//		List<Employee> collect1 = data.entrySet().stream().map(Map.Entry::getValue)
//				.map(t -> t.stream().filter(n -> n.getSalary() < 10000)).flatMap(n -> n).collect(Collectors.toList());
//		List<Employee> collect2 = data.entrySet().stream().map(Map.Entry::getValue)
//				.map(t -> t.stream().filter(n -> n.getSalary() > 10000 && n.getSalary() < 20000)).flatMap(n -> n)
//				.collect(Collectors.toList());
//		List<Employee> collect3 = data.entrySet().stream().map(Map.Entry::getValue)
//				.map(t -> t.stream().filter(n -> n.getSalary() > 20000)).flatMap(n -> n).collect(Collectors.toList());
//		System.out.println(collect1);

//		System.out.println(collect2);
//		System.out.println(collect3);
//		System.out.println(data);

		List<Student> list = List.of(new Student(1, "ram", 75811L), new Student(2, "mohan", 65811L),
				new Student(3, "reddy", 95811L), new Student(4, "yanumula", 55811L));

		String string = list.stream()
				.sorted(Collections.reverseOrder((o1, o2) -> Double.compare(o1.getMarks(), o2.getMarks())))
				.map(Student::getName).skip(1).findFirst().get();
		System.out.println(string);

		String string2 = list.stream().sorted((o1, o2) -> Double.compare(o2.getMarks(), o1.getMarks()))
				.map(Student::getName).skip(1).findFirst().get();
		System.out.println(string2);

		list.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);
		
		String string3 = list.stream()
				.sorted(Comparator.comparing(Student::getMarks).reversed()).map(Student::getName).skip(1).findFirst().get();
		System.err.println(string3);

	}
}

class Student {
	int id;
	String name;
	double marks;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	public Student(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

}