package core.java.interview;

class TestClass1{

    public static void print(String s){
        System.out.println("String -> "+s); 
    }

}



public class TestClient{
public static void main(String[] args) { 

        TestClass1 TC = null;

        TC.print("ABC");

    }

}
