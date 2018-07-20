package classWork1;

public class Array {
    public static void main(String[] args) {

        int month_days[] = {30, 31, 31, 30, 30, 34};
        System.out.println("April has " + month_days[3] + " days.");


        int arr[] = {10, 51, 2, 67, 24, 15, 94, 35, 45, 75};
        int result = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (result < arr[k]) {
                result = arr[k];
            }
        }
        System.out.println("The biggest number is " + result);

        int sum = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (sum > arr[j]) {
                sum = arr[j];
            }
        }
        System.out.println("The smallest number is " + sum);

//        int [] odds=new int [numberOdds];
//        int count=0;
//        for (int i = 1; i <authorArray.length ; i++) {
//            if(authorArray[i]%2==1){
//                odds[count]=authorArray[i];
//                count ++;
//            }
//
//        }


        double arrNew[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        double calculateSum = 0;
        for (
                int i = 1;
                i < arrNew.length; i++)

        {
            calculateSum += arrNew[i];
        }
        System.out.println(calculateSum / arrNew.length);
        Array.printOdds(arr);
        Array.printEvens(arr);
        Array.calculateOddsCount(arr);
        Array.calculateEvensCount(arr);
    }

    public static void printOdds(int[] numbers) {
        System.out.println("The odd numbers is:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                System.out.print(" " + numbers[i]);
            }
        }
        System.out.println();
    }

    static void printEvens(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)

                System.out.print(" " + numbers[i]);

        }
        System.out.println(" ");
    }

    static void calculateOddsCount(int[] numbers){
        int countOdds=0;
        for (int i = 0; i <numbers.length ; i++) {
           if(numbers[i]%2==1){
            countOdds++;
           }
        }
        System.out.println(countOdds);
    }
    static void calculateEvensCount(int[]numbers){
        int countEvens=0;
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]%2==0){
                countEvens++;
            }
        }
        System.out.println(countEvens);
    }
}

