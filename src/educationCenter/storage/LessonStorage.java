package educationCenter.storage;

import educationCenter.model.Lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LessonStorage {
    private List<Lesson> lessons = new ArrayList<>();

    public void add(Lesson lesson) {
        lessons.add(lesson);
    }

    public void printLessons() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
    }


    public Lesson getLessonByName(String name) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().equals(name)) {
                return lesson;
            }

        }
        return null;
    }
    public void printLessonsSortedByPrice() {
        Collections.sort(lessons, new Comparator<Lesson>() {
            @Override
            public int compare(Lesson o1, Lesson o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                }
                return 0;
            }
        });

        printLessons();
    }
}

