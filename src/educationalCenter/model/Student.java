package educationalCenter.model;

import java.util.Arrays;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private String  phone;
    private String email;
    private Date registerDate;
    private Lesson[] lessons;

    public Student(String name, String surname, String phone, String email, Date registerDate, Lesson[] lessons) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.registerDate = registerDate;
        this.lessons = lessons;
    }
    public Student(String name, String surname, String phone, String email, Date registerDate) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Lesson[]
    getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", lessons=" + Arrays.toString(lessons) +
                '}';
    }
}
