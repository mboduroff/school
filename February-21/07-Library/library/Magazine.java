package library;

import static library.Author.sc;

public class Magazine extends Issue {
    private String issn;

    public Magazine(String name, Author author, String issn) {
        super(name, author);
        this.issn = issn;
        System.out.println("[НОВО СПИСАНИЕ] " + this);
    }

    public Magazine(String issn) {
        this.issn = issn;
        System.out.println("[НОВО СПИСАНИЕ] " + this);
    }

    public Magazine() {
        System.out.println("\n===< Ново списание >===");
        System.out.print("Въведете ISSN за това списание: ");
        this.issn = sc.next();
        System.out.println("[НОВО СПИСАНИЕ] " + this);
    }

    @Override
    String getId() {
        return this.issn;
    }

    @Override
    void setId(String id) {
        this.issn = id;
    }

    @Override
    public String toString() {
        return "Списание: " + super.toString();
    }
}
