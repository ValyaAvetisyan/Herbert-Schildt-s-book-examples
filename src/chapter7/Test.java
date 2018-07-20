package chapter7;

public class Test {
    int a;
    int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    Test increment() {
        Test test = new Test(a + 10, b + 10);
        return test;
    }

    boolean equals(Test test) {
        if (a == test.a && b == test.b) {
            return true;
        }
        return false;
    }

    int c;

    Test(int i) {
        c = i;
    }

    Test incrByTen() {
        Test temp = new Test(c + 10);
        return temp;
    }
}

class RetOb {
    public static void main(String args[]) {
        Test ob1 = new Test(2);
        Test ob2;

        ob2 = ob1.incrByTen();
        System.out.println("ob1.c: " + ob1.c);
        System.out.println("ob2.c: " + ob2.c);
        ob2 = ob2.incrByTen();
        System.out.println( ob2.c);
    }

}

