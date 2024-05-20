package GFG_DSA;

public class TestClass {
    int orbbase =1;

    public static void main(String[] args) {
        ClassA object = new ClassA();

        object.obj1 = 1;
        object.obj2 = "Hi";
        object.method1();
        object.obj1 = 11;
        object.method1();
        TestClass orb = new TestClass();
        System.out.println(orb.orbbase);
    }

}
