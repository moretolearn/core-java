package core.java.exceptions;

public class Main {

	public static void main(String[] args) {
		Main.display();
	}
	
	static public String display() {
		try {
//			throw new RuntimeException("Run Exception");
		} catch (Exception e) {
			e.printStackTrace();
			return "Catch block";
		}
//		finally {
//			return "finally block";
//		} 
		return "exit"; 
	}
}

class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String exe) {
		super(exe);
	}
}
 