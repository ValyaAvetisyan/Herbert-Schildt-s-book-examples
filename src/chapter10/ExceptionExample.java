package chapter10;

import myExceptions.UserNotFoundException;

import java.util.Random;

public class ExceptionExample {
    public static void main(String[] args) {
        method();
        try {
            getUserByName("karen");
        } catch (UserNoFoundException e) {
            System.out.println(e.getMessage());
        }
//        String str = "55d55";
//        try {
//            int number = Integer.parseInt(str);
//            System.out.println(number);
//        } catch (IllegalArgumentException e) {
//            System.out.println("invalid str:" + str);
//        }
//
//
//        System.out.println("end program");

        {
            try {
               demoproc();
            } catch (NullPointerException e) {
                System.out.println("Recaught: " + e);
            }
        }
    }


    static void getUserByName(String name) throws UserNoFoundException {
        if (name.equals("poxos")) {
            throw new UserNoFoundException("poxos chka");
        } else {
            System.out.println("user with name " + name);
        }

    }

    static void method() {
        int a = 0, b = 0, c = 0;
        Random r = new Random();
        for (int i = 0; i < 32; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b / c);
            } catch (ArithmeticException e) {
                System.out.println("Division by zero.");
                a = 0; // set a to zero and continue
            }
            System.out.println("a: " + a);
        }
    }

        static void demoproc() {
            try {
                throw new NullPointerException("demo");
            } catch (NullPointerException e) {
                System.out.println("Caught inside demoproc.");
                throw e; // rethrow the exception
            }
        }


}