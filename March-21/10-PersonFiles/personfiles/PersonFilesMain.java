package personfiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonFilesMain {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

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

        try (PrintWriter out = new PrintWriter("people.txt")) {
            for (Person person : people) {
                out.println(person);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }

        people.clear();

        try {
            Scanner reader = new Scanner(new FileReader("people.txt"));

            while (reader.hasNextLine()) {
                String[] tokens = reader.nextLine().split("\\s++");
                people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }

        System.out.printf("The oldest person is %d y. o. \n",
                people.stream()
                        .mapToInt(Person::getAge)
                        .min()
                        .getAsInt());

    }
}
