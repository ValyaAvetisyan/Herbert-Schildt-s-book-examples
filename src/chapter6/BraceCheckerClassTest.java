package chapter6;

public class BraceCheckerClassTest {
    public static void main(String[] args) {
        BarceCheckerClass barceCheckerClass= new BarceCheckerClass("hello(([Java])})");
        barceCheckerClass.check();
    }
}
