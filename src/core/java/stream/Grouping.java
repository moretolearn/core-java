package core.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grouping {

	public static void main(String[] args) {

		List<Student1> myList = new ArrayList<>();
		myList.add(new Student1("ram", 92L, "CSE"));
		myList.add(new Student1("mohan", 22L, "CSE"));
		myList.add(new Student1("ram", 82L, "CSE"));
		myList.add(new Student1("ram", 82L, "IT"));
		myList.add(new Student1("ram", 69L, "IT"));
		myList.add(new Student1("ram", 19L, "IT"));

		Map<String, Student1> collect = myList.stream().collect(Collectors.groupingBy(Student1::getDepart, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student1::getSalary)), Optional::get)));
//		System.out.println(collect);

		myList.stream().sorted(Comparator.comparing(Student1::getSalary))
				.collect(Collectors.groupingBy(Student1::getDepart)).entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().subList(0, 2), (a, b) -> a))
				.forEach((k, v) -> System.out.println("K " + k + " - V " + v));

	}
}

class Student1 {
	String name;
	Long salary;
	String depart;

	public Student1(String name, Long salary, String depart) {
		this.name = name;
		this.salary = salary;
		this.depart = depart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", salary=" + salary + ", depart=" + depart + "]";
	}

}
