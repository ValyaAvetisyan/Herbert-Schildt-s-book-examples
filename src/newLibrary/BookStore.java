package newLibrary;

import java.util.Scanner;

public class BookStore {
    private DynamicArray dynamicArray;
    private Scanner scanner;
    private static final String FEMALE = "female";

    public BookStore(DynamicArray dynamicArray, Scanner scanner) {
        this.dynamicArray = dynamicArray;
        this.scanner = scanner;

    }

    public void startApplication() {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case 0:
                    isRun = false;
                    break;
                case 1:
                    inputAuthor();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    bookSearch();
                    break;
                case 4:
                    authorSearch();
                    break;
                case 5:
                    printFemaleAuthors();
                    break;
                case 6:
                    printAuthorByEmail(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Please input price from-to ");
                    priceFromTo(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("Please input author name for deleting");
                    deleteAuthor(scanner.nextLine());
                    break;
                case 9:
                    System.out.println("Please input count for searching book");
                    printBookByCount(scanner.nextLine());
                    break;
                default:
                    System.out.println("wrong command");
            }
        }

    }

    private void inputAuthor() {
        System.out.println("Please input Author's name,email,gender");
        String authorData = scanner.nextLine();
        String[] split = authorData.split(",");
        System.out.println("Thank you the author is added");
        Author author1 = new Author(split[0], split[1], split[2]);
        dynamicArray.add(author1);
    }

    private void inputBook() {
        System.out.println("Please input book's author, price, count, name ");
        String bookData = scanner.nextLine();
        String[] splitForBook = bookData.split(",");
        int price = Integer.parseInt(splitForBook[1]);
        int count = Integer.parseInt(splitForBook[2]);
        Author authorByName = dynamicArray.getAuthorByName(splitForBook[0]);
        Book book4 = new Book(authorByName, price, count, splitForBook[3]);
        System.out.println("Thank you the book is added");
        dynamicArray.add(book4);
        dynamicArray.printBook();
    }

    private void bookSearch() {
        System.out.println("Please input book name for searching");
        String findBook = scanner.nextLine();
        Book bookByName1 = dynamicArray.getBookByName(findBook);
        if (bookByName1 == null) {
            System.out.println("no book by name");
        } else {
            System.out.println(bookByName1);
        }
    }

    private void authorSearch() {
        System.out.println("Please input author name for searching");
        String findAuthor = scanner.nextLine();
        Author authorByName1 = dynamicArray.getAuthorByName(findAuthor);
        if (authorByName1 == null) {
            System.out.println("no author by name");
        } else {
            System.out.println(authorByName1);
        }
    }

    private void printAuthorByEmail(String author) {
        for (int i = 0; i < dynamicArray.authorSize; i++) {
            if (dynamicArray.authorArray[i].getName().equals(author)) {
                System.out.println(dynamicArray.authorArray[i].getEmail());
            }
        }
    }

    private void priceFromTo(String priceFromToString) {
        String[] prices = priceFromToString.split("-");
        int from = Integer.parseInt(prices[0]);
        int to = Integer.parseInt(prices[1]);
        for (int i = 0; i < dynamicArray.bookSize; i++) {
            if (dynamicArray.bookArray[i].getPrice() >= from || dynamicArray.bookArray[i].getPrice() <= to) {
                System.out.println(dynamicArray.bookArray[i].toString());
            } else {
                System.out.println("no book at that price");
            }

        }
    }

    private void printBookByCount(String printBookByCountString) {
        String[] prices = printBookByCountString.split("");
        int a = Integer.parseInt(prices[0]);
        int b = 5;
        for (int i = 0; i < dynamicArray.bookSize; i++) {
            if (dynamicArray.bookArray[i].getCount() >= 5) {
                System.out.println(dynamicArray.bookArray[i].toString());
            }

        }
    }

    private void printFemaleAuthors() {
        int count = 0;
        for (int i = 0; i < dynamicArray.authorSize; i++) {
            if (dynamicArray.authorArray[i].getGender().equals(FEMALE)) {
                ++count;
                System.out.println(dynamicArray.authorArray[i].toString());
            }
        }
        if (count == 0) {
            System.out.println("No female author");
        }

    }

    private void deleteAuthor(String name) {
        for (int i = 0; i < dynamicArray.authorSize; i++) {
            if (dynamicArray.authorArray[i].getName().equals(name)) {
                dynamicArray.authorArray[i] = dynamicArray.authorArray[i + 1];
                dynamicArray.authorSize--;
                System.out.println("Author is deleted");
            }
            System.out.println("no author at that name");
        }
    }


    private static void printCommands() {
        System.out.println("Please input 0 for exit");
        System.out.println("Please input 1 for adding author");
        System.out.println("Please input 2 for adding book");
        System.out.println("Please input 3 for searching book name");
        System.out.println("Please input 4 for searching author name");
        System.out.println("Please input 5 for  searching female authors");
        System.out.println("Please input 6 for searching author by email");
        System.out.println("Please input 7 for searching book by given price");
        System.out.println("Please input 8 for deleting author by name");
        System.out.println("Please input 9 for searching book by count");


    }

    private static String hasNextLine(Scanner scanner) {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }


}