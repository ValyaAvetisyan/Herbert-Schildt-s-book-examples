package sorting;

public class ArraySortingTest {
    public static void main(String[] args) {
        ArraySorting arraySorting=new ArraySorting();
        int[] array={1,9,5,4,6,7,3,2,8};
        arraySorting.print(array);
        System.out.println(" ");
        arraySorting.sortFromMax(array);
        arraySorting.print(array);
        System.out.println(" ");
        arraySorting.sortFromMin(array);
        arraySorting.print(array);
        System.out.println(" ");

    }
}
