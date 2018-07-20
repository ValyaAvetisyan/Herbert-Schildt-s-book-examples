package chapter6;

public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker("(a){s}[((]]}");
        braceChecker.check();
    }

}
