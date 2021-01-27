package airport;

public class Airport {
    public static void main(String[] args) {
        Passenger p = new Passenger("Иван Петров");
        Ticket t = new Ticket(p, "SOF", "LTN", 18.90);

        t.print();
        System.out.println(t);
    }
}
