package newLibrary;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore(new DynamicArray(),new Scanner(System.in));
        bookStore.startApplication();
    }
}
