package chapter8;

public class ABCTest {
    public static void main(String[] args) {
//        C c =new C();
//        c.tA=90;
//        System.out.println(c.tA);
//        c.hello();
//        A a = new B();
//        a.hello();
        A a1= new A();
        B b1 = new B();
        a1.i=20;
        a1.j=30;
        a1.showij();
        b1.i=5;
        b1.j=7;
        b1.k=9;
        b1.sum();
        b1.showij();
    }
}
