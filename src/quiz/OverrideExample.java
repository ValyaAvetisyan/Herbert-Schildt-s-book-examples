package quiz;

class A {
    public void m(int k) {
        System.out.println("class A, method m : " + ++k);
    }

    public void xasiat() {
        System.out.println("parent xasiat ");
    }
}

class B extends A {

    @Override
    public void xasiat() {
        System.out.println("child xasiat");
    }

    public void m(int k) {
        System.out.println("class B, method m : " + k++);
//        return k;
    }


    public void myMethod() {

    }


}

public class OverrideExample {
    public static void main(String args[]) {
        A a = new B();
        a.xasiat();
    }
}
