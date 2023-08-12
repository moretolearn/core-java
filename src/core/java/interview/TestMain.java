package core.java.interview;

public class TestMain {

    public static void main(String[] args) {

        String str1 = new String("ABC");
        String str2 = new String("ABC");
        
        String str3 = "ABC"; 
        
        String str4 = "ABC"; 

        System.out.println(str1 == str2);
        
        System.out.println(str1 == str3);  
        
        System.out.println(str1.equals(str2)); 
        
        System.out.println(str1.intern() == str3); 
        
        

    }

}
