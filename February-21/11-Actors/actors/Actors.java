package actors;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Actors {
    public static List<Production> productionList = new LinkedList<>();
    public static void main(String[] args) {
        Actor fullTimeActor = new FullTimeActor("Иван Петров",
                LocalDate.of(1995, 10, 12),
                fillDatabaseWithProductions(),
                "кино актьор");

        fullTimeActor.printAllData();


        Actor partTimeActor = new PartTimeActor("Петър Иванов",
                LocalDate.of(1908, 6, 6),
                LocalDate.of(2019, 12, 6),
                null,
                "театрален актьор");

        partTimeActor.printAllData();


        Actor test = new FullTimeActor();
        double salary = test.calculateSalary();
        System.out.printf("Заплатата на тестовия актьор е %.2f лв.%n",
                salary);

    }

    public static List<Production> fillDatabaseWithProductions() {
        productionList.add(new Play("Ромео и Жулиета",
                LocalDate.of(1957, 2, 3),
                "Уилям Шекспир"));

        productionList.add(new Play("Хамлет",
                LocalDate.of(1609, 4, 5),
                "Уилям Шекспир"));

        productionList.add(new Movie("The Shawshank Redemption",
                LocalDate.of(1994, 12, 21),
                9.2));

        productionList.add(new Movie("The Godfather",
                LocalDate.of(1972, 4, 5),
                9.1));

        productionList.add(new Movie("Interstellar",
                LocalDate.of(2014, 3, 6),
                9.1));

        return productionList;
    }
}
