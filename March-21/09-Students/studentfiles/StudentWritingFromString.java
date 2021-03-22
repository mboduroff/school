package studentfiles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StudentWritingFromString {
    public static void main(String[] args) {
        String data = "Ivan 12\n"
                + "Petur 14\n"
                + "Vanya 16\n"
                + "Petya 18\n"
                + "Georgi 15\n"
                + "Gergana 13\n"
                + "John 9\n"
                + "Jane 8\n"
                + "Jim 8\n"
                + "Steve 8";

        try (PrintWriter out = new PrintWriter("H:\\students.txt")) {
                out.println(data);
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }
    }
}
