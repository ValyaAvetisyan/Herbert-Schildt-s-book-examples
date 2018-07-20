package educationCenter.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public class User implements UserType {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date registerDate;
    private String type;
    private String username;
    private String password;
    private Set<Lesson> lessons;

    public User(String name, String surname, String phone, String email, Date registerDate, String type, String username, String password, Set<Lesson> lessons) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.registerDate = registerDate;
        this.type = type;
        this.username = username;
        this.password = password;
        this.lessons = lessons;
    }

    public User(String name, String surname, String type, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public User(String name, String surname, String phone, String email, Date registerDate) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.registerDate = registerDate;
    }

    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<Lesson> getLessons() {

        return lessons;
    }

    @Override
    public String toString() {
        if (getType().equalsIgnoreCase(ADMIN)) {
            return
                    "User{" +
                            "name='" + name + '\'' +
                            ", surname='" + surname + '\'' +
                            ", username='" + username + '\'' +
                            ", password='" + password + '\'' +
                            '}';
        } else
            return "User{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", phone='" + phone + '\'' +

                    ", email='" + email + '\'' +
                    ", registerDate=" + registerDate +
                    ", type='" + type + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", lessons=" + (lessons) +
                    '}';
    }

    public void setLessons(String less) {

    }
}
