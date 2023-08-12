package core.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindWithPrefixandDublicates {
	
	public static void main(String[] args) {
		
		List<String> myList1 = Arrays.asList(" ","2000","apple","12","200"," 15","2 8","-249"," 25","98",".22","-22","32","22","-29"," 21");
		List<String> myList2 = List.of("apple",""," ","15","98.9","0.0","94.0","98","-0.98","orange","0.98","0099","098","32","98.0","98.019","-1","-98.09");
		 String string = myList2.stream().filter(n->n.isEmpty()||n.matches("[0-9]+")).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.err.println(string);
		 //FindWithPrefixandDublicates.findPrefixAndDubplicates1();
	}

	static void findWithPrefixandDublicates1(List<String> list){
		HashSet<String> hashSet = new HashSet<>();
		Set<String> collect = list.stream().filter(n -> n.charAt(0)=='2').filter(n->!hashSet.add(n)).collect(Collectors.toSet());
		
		System.err.println(hashSet);
	}
	
	static void findWithPrefixandDublicates2(List<String> list){
		String string = list.stream().sorted(Comparator.reverseOrder()).skip(4).findFirst().get();

		System.out.println(string);
	}
	
	
	static void findPrefixAndDubplicates() {
		List<String> myList2 = List.of("apple",""," ","15","98.9","0.0","94.0","98","-0.98","orange","0.98","0099","098","32","98.0","98.019","-1","-98.09");
		Set<String> set = new HashSet<String>();
		List<String> list = Arrays.asList("2","5","3","200","2","-200","6","216","200");
		Predicate<String> value1 = n -> n.startsWith("2");
		Predicate<String> value2 = n -> !set.add(n);
		Set<String> collect = list.stream().filter(value1.and(value2)).collect(Collectors.toSet());
	}
	
	static void findPrefixAndDubplicates1() {
		List<String> myList1 = Arrays.asList(" ","2000","apple","12","200"," 15","2 8","-249"," 25","98",".22","-22","32","22","-29"," 21");

		List<String> list = Arrays.asList("2","5","3","2001","22- ","-200","6","216","200");
		Set<String> collect = myList1.stream().filter(n -> Collections.frequency(myList1, n) > 1).collect(Collectors.toSet());
		System.out.println(collect);
	}
}
