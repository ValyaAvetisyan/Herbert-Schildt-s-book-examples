package classWork1;

public class Chapter4 {
    public static void main(String[] args) {
//        int a=20;
//        Integer i= new Integer(20);
        Integer i = 20;
        Long l = 40L;
        System.out.println(Integer.MAX_VALUE);
        String n="5214";
        int number =Integer.parseInt(n);
        System.out.println(number);
//       Boolean b =true;
//        Boolean b= new Boolean("truedfvdfv");
//        System.out.println(b);
//        int a = 1;
//        int b = 2;
//        int c;
//        int d;
//        c = ++b;
//        d = a++;
//        System.out.println("a="+a);
//        System.out.println("b="+b);
//        System.out.println("c="+c);
//        System.out.println(d);
//
//        int a = 1;
//        int b = 2;
//        int c;
//        int d;
//        c = ++b;
//        d = a++;
//        c++;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("c = " + c);
//        System.out.println("d = " + d);
        String binary[] = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        int a = 3; //0 + 2 + 1 or 0011 in binary
        int b = 6; // 4 + 2 + 0 or 0110 in binary
        int c = a | b;
        int d = a & b;
        int e = a ^ b;
        int f = (~a & b) | (a & ~b);
        int g = ~a & 0x0f;

        System.out.println("        a = " + binary[a]);
        System.out.println("        b = " + binary[b]);
        System.out.println("      a|b = " + binary[c]);
        System.out.println("      a&b = " + binary[d]);
        System.out.println("      a^b = " + binary[e]);
        System.out.println("~a&b|a&~b = " + binary[f]);
        System.out.println("       ~a = " + binary[g]);
//        int n = ~0;
//        n >>>= 1;
//        int m = ~n;
        System.out.println(n);
        if ((1&0)==0 && 10 < 100) {
            System.out.println(">>>>>>>>>>>>>>>>>??????????????");
        }
        int j, k;
        j = -10;
        k = j < 0 ? -j : j;
        System.out.print("Absolute value of ");
        System.out.println(j + " is " + k);
    }
}

