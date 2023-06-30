package core.java;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindCharactersString {

	public static void main(String[] args) {
		String str = "java$^#*^$&#";
		FindCharactersString.findCharacter(str);
	}

	static void findCharacter1(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i))
					&& !Character.isWhitespace(str.charAt(i))) {
				System.out.println("Special Characters : " + str.charAt(i));
			} else {
				System.out.println("Removed Characters : " + str.charAt(i));
			}
		}
	}

	static void findCharacter(String str) {
		Predicate<Character> isDigit = n -> !Character.isDigit(n);
		Predicate<Character> isLetter = n -> !Character.isLetter(n);
		Predicate<Character> isWhitespace = n -> !Character.isWhitespace(n);
		List<Character> specialChar = str.chars().mapToObj(n -> (char) n)
				.filter(isDigit.and(isLetter).and(isWhitespace)).collect(Collectors.toList());
		System.err.println(specialChar);

		List<Character> specialCharRemoved = str.chars().mapToObj(n -> (char) n).filter(n -> Character.isLetter(n))
				.collect(Collectors.toList());
		System.err.println(specialCharRemoved);
	}
}
