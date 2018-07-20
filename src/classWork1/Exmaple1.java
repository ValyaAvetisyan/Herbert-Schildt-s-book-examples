package classWork1;

public class Exmaple1 {
    //    psvm
    public static void main(String[] args) {
//        sout
//        System.out.println("Hello world");
//        System.out.println(2+2);
//        int a = 6;
//        int b = 2;
//        int c = a + b;
//        if (c > 11) {
//            System.out.println("c-n mec e 11ic");
//        } else {
//            System.out.println("c-n poqr e 11ic");
//        }
////        fori+ enter
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//            if(i==50){
//                System.out.println("Hello");
//
//            for (int j = 5; j >0 ; j--) {
//                System.out.println("*");
//
////            }
//        for (int i = 0; i <10 ; i++) {
//            System.out.println("i="+i);
//            for (int j = 0; j < i; j++) {
//                System.out.println("j="+j);
//            }
        //one more for loop here
        //first one will print spaces
        //second one stars
        for (int i = 1; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        for (int i = 4; i > 1; i--) {
            for (int j = 4; j < 5; j++) {
                System.out.print(" ");

                for (int k = 1; k < i; k++) {
                    System.out.print("* ");

                }
                System.out.println("");
            }
        }
    }
}

