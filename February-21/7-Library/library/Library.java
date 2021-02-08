package library;

import java.time.LocalDate;

public class Library {
    public static void main(String[] args) {
        Author a = new Author("Иван Тонов",
                LocalDate.of(1970, 10, 10),
                true,
                null);
//        a.print();

        Book b = new Book("Математика за 11. клас: Геометрия (модул 1)", a, "9789547453302");
        b.print();
        Magazine m = new Magazine();
        m.print();
    }
}
