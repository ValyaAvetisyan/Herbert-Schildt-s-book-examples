package chapter7.student;

public class Student {
    static final int bachelorYear = 4;
    static String KGname="Levon Mktrtchyan";
    static {
        printHello(KGname);
    }
    String name;
    String surname;
    int age;
    String passportID;
    final int a=5;
    final int BACHELOR_YEAR=4;

    public Student(String name, String surname, int age, String passportID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.passportID = passportID;
    }
    static void printHello(String teacherName){
        System.out.println("Բարև ձեզ "+teacherName);
    }
}
