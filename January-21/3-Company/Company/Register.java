package Company;

import java.time.LocalDate;

public class Register {
    public static void main(String[] args) {
        Company c = new Company("Google Inc.",
                LocalDate.of(1998, 9, 4),
                "0001288776");
        SoleTrader s = new SoleTrader(c,
                "Sergey Brin & Larry Page",
                10, 1000000);
        s.print();
        s.analyse();
        System.out.println(s);
    }
}
