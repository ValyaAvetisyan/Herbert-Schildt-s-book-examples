package homework;

public class DynamicArrayTest {
    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 0; i < 30; i++) {
            dynamicArray.add(i);
        }

        dynamicArray.print();

        System.out.println(dynamicArray.getNum(-1));

    }
}