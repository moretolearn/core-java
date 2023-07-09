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
		List<String> slist1 = Arrays.asList("!", "@", "Tanu", "Kamal", "Suman", "Lucky", "Bunty", "Amit", "#", "1", "5",
				"(", "2", " ", "$", "%", "^", "&", "*", ")", "{", "]", "[", "}", "+", "-", "_", "=", "`", "~");
		List<String> slist = Arrays.asList("4", "0", "9", "8", "7", "6", "3", "!", "@", "a", "b", "c", "d", "e", "#",
				"1", "5", "(", "2", " ", "$", "%", "^", "&", "*", ")", "{", "]", "[", "}", "+", "-", "_", "=", "`", "~",
				"g", "f", "h", "j", "i", "k", "l", "m", "n", "o", "p", "q", "r", "t", "s", "v", "w", "y", "z", "x", "A",
				"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C",
				"V", "B", "N", "M", "<", ",", ">", ".", "/", "?", ";", ":", "'", "\\", "|", "");
		List<String> sortedList = slist.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);

		List<Integer> list = Arrays.asList(10, 1, -20, 40, 5, -23, 0);
		Collections.sort(list);

		Collections.sort(list, Collections.reverseOrder());

		list.sort(Comparator.naturalOrder());

		list.sort(Comparator.reverseOrder());

		System.out.println(list);

		List<Person> employees = new ArrayList<>();
		employees.add(new Person("Gauri", 23));
		employees.add(new Person("Gauri", 33));
		employees.add(new Person("Meli", 45));
		employees.add(new Person("Manoj", 32));

		List<Person> collect = employees.stream()
				.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
				.collect(Collectors.toList());
		System.out.println(collect);

		List<String> myList1 = List.of("apple", "", " ", "15", "98.9", "0.0", "94.0", "98", "-0.98", "orange", "0.98",
				"0099", "098", "32", "98.0", "98.019", "-1", "-98.09");
		List<String> myList2 = Arrays.asList(" ", "2000", "apple", "12", "200", " 15", "2 8", "-249", " 25", "98",
				".22", "-22", "32", "22", "-29", " 21");

		List<String> collect2 = myList1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect2);

		slist.stream().sorted().forEach(n -> {
			System.out.println(n + " : " + (int) n.charAt(0));
		});
		
		// Print Special Characters : "[^A-Za-z0-9]"
		// Print Numbers            : "[0-9]"
		// Print Alphabets          : "[a-zA-Z]"
		// Print Lowercase Alphabets: "[a-z]"
		// Print Uppercase Alphabets: "[A-Z]"
		List<String> collect3 = slist.stream().sorted().filter(n -> n.matches("[^A-Za-z0-9]"))
				.collect(Collectors.toList());
		System.out.println(collect3);
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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.name);
		hash = 67 * hash + this.age;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Person other = (Person) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (this.age != other.age) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", age=" + age + '}';
	}
}
