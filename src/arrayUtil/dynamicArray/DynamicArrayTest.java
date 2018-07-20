package arrayUtil.DynamicArray;

import arrayUtil.dynamicArray.DynamicArray;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray dynamicArray=new DynamicArray();
        dynamicArray.add(62);
        dynamicArray.add(65);
        dynamicArray.add(64);
        dynamicArray.add(61);
        dynamicArray.add(60);

        int n = dynamicArray.get(4);
        System.out.println(n*2);
        dynamicArray.print();
        System.out.println(" ");
        dynamicArray.deleteByIndex(2);
        dynamicArray.print();
        System.out.println(" ");
        boolean result = dynamicArray.contains(4);
        System.out.println(result);
        System.out.println(dynamicArray.contains(55));
        System.out.println(dynamicArray.calculateAverage());
        dynamicArray.printIndexByValue(1);


    }
}
