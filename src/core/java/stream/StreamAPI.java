package core.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		List<EmployeeD> employees = StreamAPI.getData();

		// Joining
		// Concat the first names of all emplyees by -
		String joining = employees.stream().map(e -> e.getFname() + ", " + e.getLname())
				.collect(Collectors.joining("-"));
		// System.out.println(joining);

		// Partitioning
		// Split the data by salary
		Map<Boolean, List<EmployeeD>> partitioning1 = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() > 250000));

		Map<Boolean, Set<EmployeeD>> partitioning = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() > 250000, Collectors.toSet()));

		Map<Boolean, Long> partitioning2 = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() > 250000, Collectors.counting()));
//		System.out.println(partitioning2);

		// Grouping
		// Group the employees by depart
		Map<String, List<EmployeeD>> grouping1 = employees.stream().collect(Collectors.groupingBy(EmployeeD::getDeprt));
		// Group the employees by the depart and count the depart
		Map<String, Long> grouping2 = employees.stream()
				.collect(Collectors.groupingBy(EmployeeD::getDeprt, Collectors.counting()));
		// Group the employees by the depart and list the fname
		Map<String, List<String>> grouping3 = employees.stream().collect(Collectors.groupingBy(EmployeeD::getDeprt,
				Collectors.mapping(EmployeeD::getFname, Collectors.toList())));
		// Group the employees by the depart and sum the salary
		Map<String, Optional<Double>> grouping4 = employees.stream().collect(Collectors.groupingBy(EmployeeD::getDeprt,
				Collectors.mapping(EmployeeD::getSalary, Collectors.reducing((a, b) -> a + b))));
		Map<String, Double> grouping5 = employees.stream()
				.collect(Collectors.groupingBy(EmployeeD::getDeprt, Collectors.summingDouble(EmployeeD::getSalary)));
		Map<String, DoubleSummaryStatistics> grouping6 = employees.stream().collect(
				Collectors.groupingBy(EmployeeD::getDeprt, Collectors.summarizingDouble(EmployeeD::getSalary)));
		DoubleSummaryStatistics grouping7 = employees.stream().collect(Collectors
				.filtering(e -> e.getDeprt().equals("IT"), Collectors.summarizingDouble(EmployeeD::getSalary)));
		// System.out.println(grouping7);

		// Employee with highest salary
		Optional<EmployeeD> highest1 = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(EmployeeD::getSalary)));

		// Name of the employee with higest salary
//		Optional<String> highest2 = employees.stream().collect(Collectors.collectingAndThen(
//				Collectors.maxBy(Comparator.comparing(EmployeeD::getSalary)), emp -> emp.map(EmployeeD::getFname)));
		EmployeeD highest3 = employees.stream().collect(Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparing(EmployeeD::getSalary)), Optional::get));
//		System.err.println(highest3);

		// Converting to map
		Map<String, String> map = employees.stream()
				.collect(Collectors.toMap(k -> k.getFname(), v -> v.getLname(), (a, b) -> a));
		System.out.println(map);

	}

	public static List<EmployeeD> getData() {
		List<EmployeeD> arrayList = new ArrayList<>();
		arrayList.add(new EmployeeD(1, "ram", "yanumula", "IT", 200000D));
		arrayList.add(new EmployeeD(1, "mohan", "y", "CALL", 300000D));
		arrayList.add(new EmployeeD(1, "reddy", "ya", "IT", 500000D));
		arrayList.add(new EmployeeD(1, "mohan", "yan", "SUPPORT", 100000D));
		arrayList.add(new EmployeeD(1, "ram", "yanumula", "IT", 600000D));
		return arrayList;
	}
}

class EmployeeD {

	private Integer id;

	private String fname;

	private String lname;

	private String deprt;

	private Double salary;

	public EmployeeD(Integer id, String fname, String lname, String deprt, Double salary) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.deprt = deprt;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDeprt() {
		return deprt;
	}

	public void setDeprt(String deprt) {
		this.deprt = deprt;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeD [id=" + id + ", fname=" + fname + ", lname=" + lname + ", deprt=" + deprt + ", salary="
				+ salary + "]";
	}

}