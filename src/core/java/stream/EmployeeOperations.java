package core.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeOperations {

	public static void main(String[] args) {
//		List<Employee> m1 = new ArrayList<>();
//		List<Employee> m2 = new ArrayList<>();
//		List<Employee> m3 = new ArrayList<>();
//		Map<Manager, List<Employee>> hashMap = new HashMap<>();
		Map<Manager, List<Employee>> data = EmployeeSData.getData();
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
		
		//-------------------------------------------------------
		
		data.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Manager::getTitle).reversed())).forEach(System.out::println);
		 

		HashMap<Integer, String> hashMap = new HashMap<Integer,String>();
		hashMap.put(10, "a");
		hashMap.put(20, "b");
		hashMap.put(30, "c");
		
		List<String> collect = hashMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
		System.out.println(collect);
		
		Map<Student,Integer> map = new HashMap<>();
	    Student s1=new Student(1,"A",2);
	    Student s2=new Student(1,"A",2);
	    Student s3=new Student(3,"C",1);
	    
	    map.put(s1,1);
	    map.put(s2,2);
//	    map.put(s3,3);
	    
	    System.out.println(map.get(s1));
	    System.out.println(IntStream.range(0, 100).parallel().findAny());
	    
	    List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
	    List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

	    Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
	    Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

	    System.out.println(findFirst.get()); //Always print David
	    System.out.println(fidnAny.get()); //Print Jack/Jill/Julia :behavior of this operation is explicitly nondeterministic

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

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
//	}
//	
//	@Override
//	public int hashCode() {
//		return id;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}

}