package studentfiles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentsWriting {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ivan", 12));
        studentList.add(new Student("Petur", 14));
        studentList.add(new Student("Vanya", 16));
        studentList.add(new Student("Petya", 18));
        studentList.add(new Student("Georgi", 15));
        studentList.add(new Student("Gergana", 13));
        studentList.add(new Student("John", 9));
        studentList.add(new Student("Jane", 8));
        studentList.add(new Student("Jim", 8));
        studentList.add(new Student("Steve", 8));

        try (PrintWriter out = new PrintWriter("students.txt")) {
            for (Student student : studentList) {
                out.println(student);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }
    }
}
