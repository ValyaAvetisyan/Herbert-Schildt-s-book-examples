package quiz;

public class Test {
    public static void main(String[] args) {


        int i = 0;
        i++;
        System.out.print(i);
        i = i++;
        System.out.println(i);

        Integer i1 = 127;
        Integer i2 = 127;

        Double d1 = 10d;
        Double d2 = 10d;

        System.out.println(i1 == i2);
        System.out.println(d1 == d2);
// furadonin zolikton
String str = "ABCDEF";
StringBuilder stringBuilder = new StringBuilder(str);
stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
        System.out.println(str.replaceAll("B",""));

    }
}