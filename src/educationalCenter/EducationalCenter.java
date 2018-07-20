package educationalCenter;

import educationalCenter.model.Lesson;
import educationalCenter.model.Student;
import educationalCenter.storage.LessonStorage;
import educationalCenter.storage.StudentStorage;
import myExceptions.LessonNotFoundException;
import myExceptions.UserNotFoundException;

import java.util.Date;
import java.util.Scanner;

public class EducationalCenter implements Commands {
    private StudentStorage studentsStorage = new StudentStorage();
    private LessonStorage lessonStorage = new LessonStorage();
    private Scanner scanner = new Scanner(System.in);


    public void runApplication() {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            int commands = Integer.parseInt(scanner.nextLine());
            switch (commands) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_STUDENT:
                    addStudents();
                    break;
                case ADD_LESSON:
                    addLessons();
                    break;
                case PRINT_STUDENTS:
                    printStudents();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENTS_BY_LESSON_NAME:
                    printStudentsByLessonName();
                    break;
            }
        }

    }

    public Long getNumberFromInput(Scanner scanner) {
        Long num = null;
        try {
            num = new Long(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Error during converting the input to number");
        }
        return num;
    }

    public void getStringFromInput(Scanner scanner) {

    }

    private void addStudents() {
        System.out.println("Please input Student's name, surname, phone, email");
        try {
            String str = scanner.nextLine();
            String[] stud = str.split(",");
            Student students = new Student(stud[0], stud[1], stud[2], stud[3], new Date());
            studentsStorage.addSt(students);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You should have 5 inputs separated ");
            addStudents();
        }
    }

    private void addLessons() {
        System.out.println("Please input name, duration, price, lecturerName ");
        try {
            String str = scanner.nextLine();
            String[] less = str.split(",");
            int duration = Integer.parseInt(less[1]);
            double price = Double.parseDouble(less[2]);
            Lesson lessons = new Lesson(less[0], duration, price, less[3]);
            lessonStorage.addLs(lessons);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("You should have 5 inputs separated");
        } catch (NumberFormatException | NullPointerException f) {
            System.err.println("wrong input arguments, please try again!!");
            addLessons();

        }

    }

    private void printStudents() {
        studentsStorage.printAllStudents();
    }

    private void printLessons() {
        lessonStorage.printAllLessons();
    }

    private Student getStudentByName(String name) throws UserNotFoundException {
        for (int i = 0; i < studentsStorage.getSize(); i++) {
            if (studentsStorage.getStudent(i).getName().equals(name.trim())) {
                return studentsStorage.getStudent(i);
            } else {
                throw new UserNotFoundException();
            }

        }
        return null;
    }


    private Lesson getLessonByName(String name) throws LessonNotFoundException {
        for (int i = 0; i < lessonStorage.getSize(); i++) {
            if (lessonStorage.getLesson(i).getName().equalsIgnoreCase(name.trim())) {
                return lessonStorage.getLesson(i);
            } else {
                throw new LessonNotFoundException();
            }
        }
        return null;
    }

    private void changeStudentLesson() {
        studentsStorage.printAllStudents();
        Student studentByName = null;
        try {
            studentByName = getStudentByName(scanner.nextLine());
        } catch (UserNotFoundException e) {
            System.err.println("User not found, please try again");
            changeStudentLesson();
        }
//        if (studentByName == null) {
//            System.out.println("user not exist, please try again");
//            changeStudentLesson();
//        }
        lessonStorage.printAllLessons();
        String line = scanner.nextLine();
        String[] lessonNames = line.split(",");
        LessonStorage studentLessons = null;
        if (lessonNames.length > 0) {
            studentLessons = new LessonStorage();
        }
        for (String str : lessonNames) {
            Lesson lessonByName = null;
            try {
                lessonByName = getLessonByName(str);
            } catch (LessonNotFoundException e) {
                System.err.println("No Lesson founded, please try again");
                changeStudentLesson();
            }
            if (lessonByName != null) {
                studentLessons.addLs(lessonByName);
            }
        }
        studentByName.setLessons(studentLessons.getLessons());
        studentsStorage.setStudent(studentByName);
        for (Lesson l : studentByName.getLessons()) {
            System.out.println("Student name >>>  " + studentByName.getName() + "  <<<lesson name  >> " + l.getName());
        }
    }


    private void printStudentsByLessonName() {
        System.out.println("Please input Lesson's name");
        String lessonName = scanner.nextLine().trim();
        for (int i = 0; i < studentsStorage.getSize(); i++) {
            Lesson[] lessons = studentsStorage.getStudent(i).getLessons();
            for (Lesson l : lessons) {
                if (l.getName().equals(lessonName)) {
                    System.out.println(studentsStorage.getStudent(i));
                }
            }
        }
    }

    private void printCommands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_STUDENT + " for adding students");
        System.out.println("Please input " + ADD_LESSON + " for adding lesson");
        System.out.println("Please input " + PRINT_STUDENTS + " for printing students");
        System.out.println("Please input " + PRINT_LESSONS + " for printing lessons ");
        System.out.println("Please input " + CHANGE_STUDENT_LESSON + " for changing student's lesson");
        System.out.println("Please input " + PRINT_STUDENTS_BY_LESSON_NAME + " for printing students by lesson name");
    }
}
//Add users to user storage I mean create new user
//print all user names. Make application user friendly
//terminalic mutqagrel user i anun@ vorin piti avelacnenq lessonner
//heto tpel bolor lessonner@
//terminalic mutqagrel lessonnei anunner@ bajanvac storaketnerov ','
//lesson storage ic vercnel bolor lessonner@ irenc anunnerov
// stercel lessonsForUser  LessonStorage@ ev ete lesson@ ka avelacnel aidter
// ete chka chavelacnel
// lesson storage i lessonner@ tal user in




