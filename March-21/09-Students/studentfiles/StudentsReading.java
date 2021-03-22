package studentfiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsReading {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new FileReader("D:\\Git\\March-21\\09-Students\\studentfiles\\students.txt"));

            while (reader.hasNextLine()) {
                String[] tokens = reader.nextLine().split("\\s++");
                studentList.add(new Student(tokens[0], Integer.parseInt(tokens[1])));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }

        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
