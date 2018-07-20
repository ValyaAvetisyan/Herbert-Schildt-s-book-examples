package chapter6;

public class Stack {
    private char[] array = new char[10];
    private int size;

    Stack() {
        size = 0;
    }

    Stack(int length) {
        array = new char[length];
        size = 0;
    }

    public void push(char value) {
        if (size == array.length) {
            extend();
        } else {
            array[size] = value;
            ++size;
        }
    }

    private void extend() {
        char[] newArray = new char[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public char pop() {
        if (size <= 0) {
            return '0';
        } else {

            char temporaryElement = array[--size];
            array[size+1] = 0;
            return temporaryElement;
        }
    }
    public char get() {

        if (size <= 0) {
            return '0';
        }
        char temp = array[--size];
        size++;
        return temp;
    }
}
