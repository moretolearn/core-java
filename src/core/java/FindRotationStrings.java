package core.java;

public class FindRotationStrings {

	public static void main(String[] args) {
		String str1 = "ABCD";
		String str2 = "CDAB";
		System.out.println((FindRotationStrings.findRatationString(str1, str2)));
	}
	
	static boolean findRatationString(String str1,String str2) {
		
		return (str1.length() == str2.length() && (str1+str2).indexOf(str2) != -1);
	}
	
}
