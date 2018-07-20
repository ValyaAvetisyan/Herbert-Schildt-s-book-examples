package educationalCenter.storage;

import educationalCenter.model.Lesson;

public class LessonStorage {
    private Lesson less[] = new Lesson[16];
    private int size = 0;

    public void addLs(Lesson lessons) {
        if (less.length == size) {
            extend();
        }
        less[size++] = lessons;
    }

    private void extend() {
        Lesson temp[] = new Lesson[less.length + 10];
        System.arraycopy(less, 0, temp, 0, less.length);
        less = temp;
    }

    public void printAllLessons() {
        for (int i = 0; i < size; i++) {
            System.out.println(less[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public Lesson getLesson(int index) {
        if (index <= size) {
            return less[index];
        }
        return null;
    }

    public Lesson[] getLessons() {
        Lesson[] l = new Lesson[size];
        for (int i = 0; i < size; i++) {
            l[i] = less[i];
        }
        return l;
    }
}