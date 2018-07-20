package sorting;

public class ArraySorting {
    public void sortFromMax(int[]array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 1; j <array.length ; j++) {
                if (array[j]>array[j-1]){
                    int temp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }

            }

        }

    }
    public void sortFromMin(int[]array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j]< array[i]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }

            }

        }

    }
    public void print (int[]array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");


        }
    }
}
