package library;

import static library.Author.sc;

public class Magazine extends Issue {
    private long issn;

    public Magazine(String name, Author author, long issn) {
        super(name, author);
        this.issn = issn;
        System.out.println("[НОВО СПИСАНИЕ] " + this);
    }

    public Magazine(long issn) {
        this.issn = issn;
        System.out.println("[НОВО СПИСАНИЕ] " + this);
    }

    public Magazine() {
        System.out.println("\n===< Ново списание >===");
        System.out.print("Въведете ISSN за това списание: ");
        this.issn = sc.nextLong();
        System.out.println("[НОВО СПИСАНИЕ] " + this);
    }

    @Override
    long getId() {
        return this.issn;
    }

    @Override
    void setId(long id) {
        this.issn = id;
    }

    @Override
    public String toString() {
        return "Списание: " + super.toString();
    }
}
