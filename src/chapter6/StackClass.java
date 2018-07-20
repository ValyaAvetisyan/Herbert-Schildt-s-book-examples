package chapter6;

public class StackClass {
    private int array[] = new int[10];
    private int size;

    public StackClass() {
        size = -1;
    }

    public void push(int value) {
        if (size == 9) {
            System.out.println("stack-ը վերջացավ");
        } else {
            array[++size] = value;
        }
    }

    public int pop() {
        if (size < 0) {
            System.out.println("stack-ը դատարկ է");
            return 0;
        } else {
            return array[size--];
        }
    }

}
