package calculator;

public class CalculatorTestClass {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        System.out.println(calculator.sum(5,9*2));
//         long sum = calculator.sum(a*2);
//        ctl+alt+v

        calculator.substraction(10,5);
        calculator.division(20,5);
        calculator.multiplication(15,7);
        int a=20;
//        int b=a++;
        System.out.println(a+=5);
        System.out.println(++a);
    }
}
