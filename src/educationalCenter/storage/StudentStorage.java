package educationalCenter.storage;

import educationalCenter.model.Student;

public class StudentStorage {
    private Student studs[] = new Student[16];
    private int size = 0;

    public void addSt(Student students) {
        if (studs.length == size) {
            extend();
        }
        studs[size++] = students;
    }

    private void extend() {
        Student temp[] = new Student[studs.length + 10];
        System.arraycopy(studs, 0, temp, 0, studs.length);
        studs = temp;
    }

    public void printAllStudents() {
        for (int i = 0; i < size; i++) {
            System.out.println(studs[i]);

        }

    }

    public int getSize() {
        return size;
    }

    public Student getStudent(int index) {
        if (index <= size) {
            return studs[index];
        }
        return null;
    }
    public void setStudent(Student student) {
        for (int i = 0; i < size; i++) {
            if (studs[i].getName().equals(student.getName())) {
                studs[i] = student;
                break;
            }

        }
    }
}


