package studentfiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StudentReadingFromString {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new FileReader("H:\\students.txt"));

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }
    }
}
