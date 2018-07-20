package library;

public class Author {
    String name;
    String surname;
    int age;
    Author (String name,String surname, int age){
        this.name = name;
        this.surname= surname;
        this.age=age;

    }


    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

