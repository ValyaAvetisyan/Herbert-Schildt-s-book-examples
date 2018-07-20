package newLibrary;

import java.util.Scanner;

public class DynamicArray {

    public Book[] bookArray = new Book[16];
    public Author[] authorArray = new Author[15];
    public int bookSize = 0;
    public int authorSize = 0;
    Scanner scanner = new Scanner(System.in);

    public void add(Author author) {
        if (authorSize == authorArray.length) {
            extendBook();
        }
        authorArray[authorSize++] = author;
    }

    private void extendAuthor() {
        Author[] temp = new Author[authorArray.length + 10];
        for (int i = 0; i < authorArray.length; i++) {
            temp[i] = authorArray[i];
        }
        authorArray = temp;
    }


    public void add(Book book) {
        if (bookSize == bookArray.length) {
            extendBook();
        }
        bookArray[bookSize++] = book;
    }

    private void extendBook() {
        Book[] temp = new Book[bookArray.length + 10];
        for (int i = 0; i < bookArray.length; i++) {
            temp[i] = bookArray[i];

        }
        bookArray = temp;
    }


    public Author getAuthorByName(String name) {
        for (int i = 0; i < authorSize; i++) {
            if (authorArray[i].getName().equals(name)) {
                return authorArray[i];
            }
        }
        return null;
    }

    public Book getBookByName(String name) {
        for (int i = 0; i < bookSize; i++) {
            if (bookArray[i].getName().equals(name)) {
                return bookArray[i];
            }
        }
        return null;
    }

    public void printBook() {
        for (int i = 0; i < bookSize; i++) {
            System.out.println(bookArray[i]);
        }
    }

    public void printAuthor() {
        for (int i = 0; i < authorSize; i++) {
            System.out.println(authorArray);
        }
    }
}
