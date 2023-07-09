package core.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortingTypes {

	public static void main(String[] args) {
		List<String> slist = Arrays.asList("Tanu", "Kamal", "Suman", "Lucky", "Bunty", "Amit");
		List<String> sortedList = slist.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);

		List<Integer> list = Arrays.asList(10, 1, -20, 40, 5, -23, 0);
		
//		Collections.sort(list);

//		Collections.sort(list,Collections.reverseOrder());

//		list.sort(Comparator.naturalOrder());

//		list.sort(Comparator.reverseOrder());
		
//		System.out.println(list);

		List<Person> employees = new ArrayList<>();
		employees.add(new Person("Gauri", 23));
		employees.add(new Person("Gauri", 33));
		employees.add(new Person("Meli", 45));
		employees.add(new Person("Manoj", 32));
		
		List<Person> collect = employees.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).collect(Collectors.toList());
		System.out.println(collect);
	}
}


class Person {
	private final String name;
	private final int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

//	@Override
//	public int hashCode() {
//		int hash = 7;
//		hash = 67 * hash + Objects.hashCode(this.name);
//		hash = 67 * hash + this.age;
//		return hash;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		final Person other = (Person) obj;
//		if (!Objects.equals(this.name, other.name)) {
//			return false;
//		}
//		if (this.age != other.age) {
//			return false;
//		}
//		return true;
//	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", age=" + age + '}';
	}
}
