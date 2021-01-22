package Company;

import java.util.ArrayList;
import java.util.List;

import static Company.Employee.*;

public class Company {
    static List<Employee> list = new ArrayList<>();
    public static void main(String[] args) {
        Employee e = new Employee("Иван Петров", "Software Engineer",
                26, 4_500);
        list.add(e);
        Employee e1 = new Employee("Александър Иванов", "QA Engineer",
                21, 2_900);
        list.add(e1);
        Employee e2 = new Employee("Петър Димитров", "Sr. Java Developer",
                34, 4_000);
        list.add(e2);
        Employee e3 = new Employee("Димитър Петров", "Jr. Go Developer",
                23, 3_100);
        list.add(e3);
        Employee e4 = new Employee("Георги Иванов", "Project manager",
                36, 5_000);
        list.add(e4);

        filterBySalaryRange(2_900, 3_999); // Вместо между 500 и 800 лв (по усл.),
        // избрах тези числа, защото в моята фирма няма ниско-платени служители :)

        sortBySalary();

        filterByJobPosition("Software Engineer");

        Employee e5 = new Employee();
        list.add(e5);

        // Използване на методите без подадени параметри (с въвеждане от клавиатурата)
        sortBySalary();
        filterByJobPosition();
        filterBySalaryRange();

    }
}
