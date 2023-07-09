package core.java.stream;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingCustomObjects {

	public static void main(String[] args) {

		// List
		List<Employee> list = EmployeeSData.getDataList();

		List<Employee> listCustomObjectsAes = list.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(listCustomObjectsAes);

		List<Employee> listCustomObjectsDesc = list.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(listCustomObjectsDesc);

		// Set
		Set<Employee> set = new HashSet<>(list);

		List<Employee> setCustomObjectsAes = set.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(setCustomObjectsAes);

		List<Employee> setCustomObjectsDesc = set.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(setCustomObjectsDesc);
		
		
	}
}
