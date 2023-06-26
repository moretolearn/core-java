package core.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartsWithNth {
	
	public static void main(String[] args) {
		
		String arr[]  = {"ram","mohan","reddy","yanumula"};
		
		List<Integer> asList = Arrays.asList(21,26,14,28,15);

		Set<String> startsWith = Arrays.stream(arr).filter(n->n.startsWith("r")).collect(Collectors.toSet());
		System.out.println(startsWith);
		
		Set<String> endsWith = Arrays.stream(arr).filter(n->n.endsWith("n")).collect(Collectors.toSet());
		System.out.println(endsWith);
		
		asList.stream().map(n-> String.valueOf(n)).filter(n->n.startsWith("2")).map(n->Integer.valueOf(n)).forEach(System.out::println);
		
		IntStream rangeClosed = IntStream.rangeClosed(1, 5);
		rangeClosed.skip(1).limit(4).forEach(System.out::println);
		
	}

}
