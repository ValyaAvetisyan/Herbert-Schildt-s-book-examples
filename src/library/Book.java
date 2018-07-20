package library;

public class Book {
    String title;
    int count;
    Author author;
    double price;
    Book (String title, int count, Author author, double price){
        this.title=title;
        this.count=count;
        this.author=author;
        this.price=price;

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", author=" + author +
                ", price=" + price +
                '}';
    }
}
