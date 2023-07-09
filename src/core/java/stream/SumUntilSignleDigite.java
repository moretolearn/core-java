package core.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumUntilSignleDigite {
	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 3, 4, 119 };
		int reduce = Arrays.stream(String.valueOf(Arrays.stream(arr).sum()).split("")).mapToInt(n -> Integer.valueOf(n)).sum();
		System.err.println(reduce);
//		var<String> k = new ArrayList<>();
		// Sum of arrya
		Arrays.stream(arr).boxed().reduce(0, (a, b) -> a + b);

		List<Integer> collect = Stream.iterate(new int[] { 0, 1}, t -> new int[] { t[1], t[0] + t[1] }).limit(5)
				.map(n -> n[0]).collect(Collectors.toList());

		System.out.println(collect);
		
//		Stream<int[]> iterate = Stream.iterate(new int[] { 0, 1}, t -> new int[] { t[1], t[0] + t[1] }).limit(5);
		
//		Iterator<int[]> iterator = iterate.iterator();
//		while (iterator.hasNext()) {
//			int[] is = (int[]) iterator.next();
//			for (int i = 0; i < is.length; i++) {
//				System.out.println(is[i]);
//			}
//		}
//		
//		{0,1}
//		{1,1}
//		{1,2}
//		{2,3}
//		{3,5}
		
		long  d1 = System.currentTimeMillis();
		//Given Number is Prime or not
		boolean noneMatch = IntStream.range(2, 5).noneMatch(n->5%n==0);
		System.out.println(noneMatch);
		System.err.println(System.currentTimeMillis()-d1);
//		IntStream.range(2, 5).forEach(System.out::println);
		
		// Given String Palindrome or not
		String name = "121";
		boolean range = IntStream.rangeClosed(0, name.length()/2).noneMatch(n->name.charAt(n)!=name.charAt(name.length()-n-1));
		System.out.println(range);
		
		//Given Number is Angstrom or not
		List<Integer> collect2 = Stream.iterate(1, i -> ++i)
        .filter(i -> i == Stream.of(String.valueOf(i).split(""))
                .map(Integer::valueOf)
                .map(n -> (n*n*n))
                .mapToInt(n -> n)
                .sum())
        .limit(5)
        .collect(Collectors.toList());
		
		System.out.println(collect2);
		
		IntStream.range(1, 10).skip(1).limit(5).forEach(System.out::println);
		
	}
}
