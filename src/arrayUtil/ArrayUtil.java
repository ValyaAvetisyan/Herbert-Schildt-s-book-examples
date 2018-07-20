package arrayUtil;

import classWork1.Array;

public class ArrayUtil {
    //        Task is to find the average of the following numbers
    public void findAverage(double[] numbers) {
        double arrNew[] = numbers;
        double average = 0;
        for (int i = 1; i < arrNew.length; i++)

        {
            average += arrNew[i];
        }
        System.out.println("The average number is: " + average / arrNew.length);
    }

    //        Task is to find the biggest number
    public void maxNumber(int[] number) {
        int arr[] = number;
        int result = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (result < arr[k]) {
                result = arr[k];
            }
        }
        System.out.println("The biggest number is " + result);
    }

    //        Task is to find the smallest num
    public void minNumber(int[] number) {
        int sum = number[0];
        for (int j = 0; j < number.length; j++) {
            if (sum > number[j]) {
                sum = number[j];
            }
        }
        System.out.println("The smallest number is " + sum);
    }

    //Task is to find all odd numbers
    public void printOdds(int[] numbers) {
        System.out.println("The odd numbers are:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                System.out.print(" " + numbers[i]);
            }
        }
        System.out.println();
    }

    /**
     * Task is to find all evens
     *
     * @param numbers bookArray of numbers
     */
    public void printEvens(int[] numbers) {
        System.out.println("The even numbers are:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)

                System.out.print(" " + numbers[i]);

        }
        System.out.println(" ");
    }

    /**
     * Task is to calculate the count of odds
     *
     * @param numbers
     */
    public void calculateOddsCount(int[] numbers) {
        int countOdds = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                countOdds++;
            }
        }
        System.out.println("There are " + countOdds + " odds ");
    }

    //    task is to calculate the count of evens
    public void calculateEvensCount(int[] numbers) {
        int countEvens = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                countEvens++;
            }
        }
        System.out.println("There are " + countEvens + " evens");
    }

    public void numbersInOrder(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;


                }

            }

        }

        for (int k = 0; k < numbers.length; k++) {
            System.out.print(" " + numbers[k]);

        }
        System.out.println(" ");
    }

    public void keepOrder(int[] number) {
        int temp;
        for (int i = 0; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                if (number[i] > number[j]) {
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }

        for (int k = 0; k < number.length; k++) {
            System.out.print(" " + number[k]);

        }


    }

    //Task is to find common elements from 2 arrays and print
    public void commonElement(int[] array1, int[] array2) {
        System.out.print("The common elements are: ");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    System.out.print(array1[i] + " ");
                }

            }

        }
    }

    //task is to remove all dublicates from bookArray and print bookArray without them
    public int[] removeDublicates(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    array[j] = array[size - 1];
                    size--;
                    j--;
                }
            }

        }
        int[] result = new int [size];
        for (int i = 0; i <size ; i++) {
            result[i]=array[i];

        }
return result;
    }
}



