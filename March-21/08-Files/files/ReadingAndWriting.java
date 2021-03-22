package files;

import java.io.*;

public class ReadingAndWriting {
    public static void main(String[] args) throws IOException {
        try (PrintWriter out = new PrintWriter("D:\\Git\\March-21\\08-Files\\files\\text.txt")) {
            out.println("7777" + "666");
            out.println(5.6);
            out.println(15.6 + 78.2323);
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }

        StringBuilder str = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("D:\\Git\\March-21\\08-Files\\files\\text.txt")) ;
            String temp = reader.readLine();
            while (temp != null) {
                str.append(temp).append("\n");
                temp = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        } catch (IOException e) {
            System.err.println("Входно-изходна грешка!");
        } catch (NullPointerException e) {
            System.err.println("Грешка в указателите.");
        } finally {
            System.out.println(str);
        }
    }
}
