package chapter7;

public class TestDemo {
    public static void main(String[] args) {


        Test test = new Test(10, 20);
        Test test1 = new Test(11, 20);
        System.out.println(test.equals(test1));
        int k = 0;
        System.out.println("sdf" + ++k);
        Test test2=test.increment();
        System.out.println(test2.a);
    }
}