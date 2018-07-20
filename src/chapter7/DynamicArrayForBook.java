package chapter7;

public class DynamicArrayForBook {

    private Book[] array = new Book[16];

    private int size = 0;

    public void add(Book value) {
        if (size == array.length) {
            extend();
        }
        array[size] = value;
        size++;
    }

    public Book get(int index) {
        return array[index];
    }

    private void extend() {
        Book[] tmp = new Book[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public void deleteByIndex(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public String getAuthorNameByBookName(String bookName){
        for (int i = 0; i < size; i++) {
            if(array[i].getName().equals(bookName)){
                return array[i].getAuthor().getName();
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i] + " ");
        }
    }


}
