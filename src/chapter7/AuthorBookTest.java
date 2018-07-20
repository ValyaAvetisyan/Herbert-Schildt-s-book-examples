package chapter7;

import java.util.Scanner;

public class AuthorBookTest {
    public static void main(String[] args) {
        DynamicArrayForBook da = new DynamicArrayForBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Author's name,email,gender");
        String authorData = scanner.nextLine();
        String[] splitAuthor = authorData.split(",");

        System.out.println("Thank you, the author is added");
        Author author = new Author(splitAuthor[0], splitAuthor[1], splitAuthor[2]);
        System.out.println("Please input Book's name,price,count");
        String bookData = scanner.nextLine();
        String[] splitBook = bookData.split(",");
        double price = Double.parseDouble(splitBook[1]);
        int count = Integer.parseInt(splitBook[2]);
        Book book = new Book(splitBook[0], author, price, count);
        System.out.println("Thank you, Book is added to DA");
        da.add(book);
        da.print();
        scanner.close();

    }
}
