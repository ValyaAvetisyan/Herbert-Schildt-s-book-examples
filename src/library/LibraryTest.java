package library;

public class LibraryTest {
    public static void main(String[] args) {
        Author author =new Author("Charles","Dickens",45);
        Author author1 = new Author("Ella", "Fidzerald", 55);
        Author author2= new Author("George", "Bayron", 96);
        Book book= new Book("Oliver Twist",5, author,54);
        Book book1 = new Book("Great Gatsby", 12,author1,9);
        Book book2= new Book("Don Juan",45, author2,6);
        System.out.println(author.name+author.surname+ author.age+ book.title+book.count+book.price);
        System.out.println(book1);
    }
}
