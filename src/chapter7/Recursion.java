package chapter7;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(notRecursiveFactorial(4));
        System.out.println(recursiveFactorial(5));

    }

    /**
     * orinak 4 i faktorial@ klini 1*2*3*4
     */
    private static int recursiveFactorial(int number) {
        if (number == 1) return 1;
        return recursiveFactorial(number - 1) * number;
    }

    private static int notRecursiveFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;// result = result*i

        }

        return result;
    }

}


