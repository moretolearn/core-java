package core.java.exceptions;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public String display() {
		System.out.println("");
		try {
			System.err.println();
//			throw new RuntimeException("Exception");
		} catch (Exception e) {
			return "Catch block";
		}finally {
			return "finally block";
		} 
//		return "exit"; 
	}
}
