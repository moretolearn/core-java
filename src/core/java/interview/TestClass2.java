package core.java.interview;

class ClassA {
    public ClassA() {
        System.out.println("Class A");
    }
}
 
class ClassB extends ClassA{
    public ClassB() {
        System.out.println("Class B");
    }
}
 
class ClassC extends ClassB{
    public ClassC() {
        System.out.println("Class C");
    }
}
 
 
public class TestClass2 {
    public static void main(String[] args) {
        ClassC classC = new ClassC();
    }
}
