package chapter7.student;

public class StudentTest {
    public static void main(String[] args) {
        String name = "asd"+"we";
        StringBuilder sb = new StringBuilder();
        String substring=name.substring(2,5);
        sb.append("asd");
        sb.append("we");
        System.out.println(sb.toString());
        Student student= new Student("Valya","Avetisyan",23,"Am0246435");
        System.out.println(student.name);
        System.out.println(Student.bachelorYear);
        Student.printHello("Poghosyan");
    }
}
