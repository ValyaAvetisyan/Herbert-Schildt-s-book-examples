package arrayUtil;

import arrayUtil.ArrayUtil;

public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int arr[] = {10, 51, 2, 67, 7, 15, 94, 3, 45, 75};
        arrayUtil.printEvens(arr);
        arrayUtil.printOdds(arr);
        arrayUtil.calculateOddsCount(arr);
        arrayUtil.calculateEvensCount(arr);
        double arrNew[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        arrayUtil.findAverage(arrNew);
        arrayUtil.maxNumber(arr);
        arrayUtil.minNumber(arr);
        int array[]={2,1,8,6,0,3,5,4,9,7};
        arrayUtil.numbersInOrder(array);
        arrayUtil.keepOrder(array);
        System.out.println();
        arrayUtil.commonElement(array,arr);
        int arrayNew[]={5,5,9,7,5,3,7,5,5};
        System.out.println(" ");
//        System.out.println(arrayUtil.removeDublicates());
        int[]result =arrayUtil.removeDublicates(arrayNew);
        arrayUtil.removeDublicates(arrayNew);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
