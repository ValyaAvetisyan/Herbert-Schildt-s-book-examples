package newLibrary;

public class Book {
    public static final String DEFAULT_CUURENCY = "AMD";
    private Author author;
    private int price;
    private int count;
    private String name;
    private String currency;

    Book(Author author, int price, int count, String name) {
        this.author = author;
        this.price = price;
        this.count = count;
        this.name = name;
        currency = DEFAULT_CUURENCY;
    }

    Book(Author author, int price, int count, String name, String currency) {

        this.author = author;
        this.price = price;
        this.count = count;
        this.name = name;
        this.currency = currency;

    }

    public Author getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public int setPrice(int price) {
        return this.price;
    }

    public int setCount(int count) {
        return this.count;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", price=" + price +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }


}
