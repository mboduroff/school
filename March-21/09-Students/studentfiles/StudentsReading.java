package studentfiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsReading {

    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
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

        System.out.println("\n\tВсички ученици:");
        for (Student student : studentList) {
            System.out.println(student);
        }

        printFilteredStudents(10, 14);
    }

    private static void printFilteredStudents() {
        Scanner sc = new Scanner(System.in);
        int limit1 = 0, limit2 = 0;
        System.out.println("\n\tФилтрирам учениците по възраст. Моля, въведете граници:");
        try {
            System.out.println("Долна граница:");
            limit1 = sc.nextInt();
            System.out.println("Горна граница:");
            limit2 = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Моля, въвеждайте само цели числа!");
        }

        if (limit1 > limit2) {
            System.out.println("Долната граница не може да бъде по-голяма от горната!\n" +
                    "Разменям стойностите...");
            int temp = limit1;
            limit1 = limit2;
            limit2 = temp;
        }

        System.out.printf("%n\tВсички ученици на възраст между %d и %d г.:%n",
                limit1,
                limit2);
        for (Student student : studentList) {
            if (student.getAgeInYears() > limit1 && student.getAgeInYears() < limit2) {
                System.out.println(student);
            }
        }
    }

    private static void printFilteredStudents (int lowerLimit, int upperLimit) {
        System.out.println("\n\tФилтрирам учениците по възраст:");

        if (lowerLimit > upperLimit) {
            System.out.println("Долната граница не може да бъде по-голяма от горнта!" +
                    "Разменям стойностите...");
            int temp = lowerLimit;
            lowerLimit = upperLimit;
            upperLimit = temp;
        }

        System.out.printf("%n\tВсички ученици на възраст между %d и %d г.:%n",
                lowerLimit,
                upperLimit);
        for (Student student : studentList) {
            if (student.getAgeInYears() >= lowerLimit && student.getAgeInYears() <= upperLimit) {
                System.out.println(student);
            }
        }
    }
}
