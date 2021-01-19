package Airport;

public class Ticket extends Passenger {
    private String departingFrom;
    private String destination;
    private double ticketPrice;

    public Ticket(String name, String departingFrom, String destination, double ticketPrice) {
        super(name);
        this.departingFrom = departingFrom;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Ticket(String departingFrom, String destination, double ticketPrice) {
        super();
        this.departingFrom = departingFrom;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Ticket() {
        super();
        System.out.print("Лети от: ");
        this.departingFrom = sc.next();
        System.out.print("Лети до: ");
        this.destination = sc.next();
        System.out.print("Цена на билета: ");
        this.ticketPrice = sc.nextDouble();
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Ticket(Passenger p) {
        super(p.getName());
        System.out.println("===: Нов пътник :===");
        System.out.println("(към " + super.toString() + ")");
        System.out.print("Лети от: ");
        this.departingFrom = sc.next();
        System.out.print("Лети до: ");
        this.destination = sc.next();
        System.out.print("Цена на билета: ");
        this.ticketPrice = sc.nextDouble();
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Ticket(Passenger p, String departingFrom, String destination, double ticketPrice) {
        super(p.getName());
        this.departingFrom = departingFrom;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public void print() {
        super.print();
        System.out.printf(" ще лети от %s до %s с билет на цена %.2f лв.%n",
                this.getDepartingFrom(),
                this.getDestination(),
                this.getTicketPrice());
    }

//    Getters and setters below this line.

    public String getDepartingFrom() {
        return departingFrom;
    }

    public void setDepartingFrom(String departingFrom) {
        this.departingFrom = departingFrom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" / Лети от: %s / Лети до: %s / Цена на билета: %.2f лв%n",
                this.getDepartingFrom(),
                this.getDestination(),
                this.getTicketPrice());
    }
}
