package personfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonFilesMain {
    private static List<Person> people = new ArrayList<>();
    private static final String fileName = "D:\\Git\\March-21\\10-PersonFiles\\personfiles\\people.dat";

    public static void main(String[] args) {

        fillDatabase();
        writePeople();

        people.clear();

        readPeople();

        printYoungest();
        printOldest();

    }

    private static void writePeople() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(people);
            System.out.println("\n\tserialised:");
            people.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readPeople() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            people = Collections.unmodifiableList((ArrayList<Person>) in.readObject());

            System.out.println("\n\tdeserialised:");
            people.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void fillDatabase() {
        people.add(new Person("Ivan", 12, "ул. Първа 2"));
        people.add(new Person("Petur", 14, "ул. Втора 3"));
        people.add(new Person("Vanya", 16, "ул. Трета 4"));
        people.add(new Person("Petya", 18, "ул. Четвърта 5"));
        people.add(new Person("Georgi", 15, "ул. Пета 6"));
        people.add(new Person("Gergana", 13, "ул. Шеста 7"));
        people.add(new Person("John", 9, "ул. Седма 8"));
        people.add(new Person("Jane", 8, "ул. Осма 9"));
        people.add(new Person("Jim", 7, "ул. Девета 10"));
        people.add(new Person("Steve", 8, "ул. Десета 11"));
    }

    private static void printYoungest() {
        System.out.printf("%nThe youngest person is %d y. o. %n",
                people.stream()
                        .mapToInt(Person::getAge)
                        .min()
                        .getAsInt());
    }

    private static void printOldest() {
        System.out.printf("The oldest person is %d y. o. %n",
                people.stream()
                        .mapToInt(Person::getAge)
                        .max()
                        .getAsInt());
    }
}
