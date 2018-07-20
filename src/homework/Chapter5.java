package homework;

public class Chapter5 {
    public static void main(String[] args) {
        int month = 5;
        String Season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                Season = "winter";
                break;
            case 3:
            case 4:
            case 5:
                Season = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                Season = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                Season = "Autumn";
                break;
            default:
                Season = "Unknown month";
        }
        System.out.println("May is in the " + Season);
        int n = 10;
        while (n > 0) {
            System.out.println(n);
            n--;
        }
        int i, j;

        i = 100;
        j = 200;

        while (++i < --j) ;

        System.out.println("Midpoint is " + i);
        int m = 10;

//        do {
//            System.out.println("tick " + m);
//            m--;
//        } while (m > 0);

        do {
            System.out.println("tick " + m);
        } while (--m > 0);


        String lang = "arm";
        switch (lang) {
            case "arm":
                System.out.println("barev");
                break;
            case "rus":
                System.out.println("privet");
                break;
            case "en":
                System.out.println("hello");
                break;
            default:
                System.out.println("language is not valid");
        }

        int num = 14;
        boolean isPrime;
        isPrime = true;
        for (int k = 2; k <= num / i; k++) {
            if (num % k == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) System.out.println("Prime");
        else System.out.println("Not Prime");
        int a, b;

        b = 4;
        for (a = 1; a < b; a++) {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            b--;
        }
        int l;
        boolean done = false;

        l = 0;
        for (; !done; ) {
            System.out.println("l is " + l);
            if (l == 10) done = true;
            l++;
        }
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (x == 5) {
                break;
            }

        }
        System.out.println("Sum is " + sum);
        int sums = 0;
        int numb[][] = new int[3][5];
        for (int d = 0; d < 3; d++)
            for (int c = 0; c < 5; c++)
                numb[d][c] = (d + 1) * (c + 1);
        for (int d[] : numb) {
            for (int c : d) {
                sums += c;

            }
        }
        System.out.println(sums);
    }
}

