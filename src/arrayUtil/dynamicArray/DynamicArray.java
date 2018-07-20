package arrayUtil.dynamicArray;

public class DynamicArray {
    private int[] array = new int[16];
    private int size = 0;
    int[] arr = {5, 6, 1, 3, 12};

    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    private void extend() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];

        }
        array = temp;
    }

    public int get(int index) {

        return array[index];
    }

    public void deleteByIndex(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];

        }
        size--;

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");

        }
    }

    public boolean contains(int number) {

        for (int i = 0; i < size; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    public int calculateAverage() {
        int average = 0;
        for (int i = 0; i < arr.length; i++) {

            average += arr[i];
        }
        return average / arr.length;
    }

    public void printIndexByValue(int value) {
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] ==value){
                System.out.println(i);
            }

        }


    }


}
