package library;

import static library.Author.sc;

abstract class Issue {
    private String name;
    private Author author;

    public Issue(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public Issue() {
        System.out.println("\n===< Ново издание >===");
        System.out.println("Име на изданието:");
        this.name = sc.nextLine();
        this.author = new Author();
    }

    abstract String getId();
    abstract void setId(String id);

    void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Издание %s (от %s) е с идентификатор %s",
                this.name,
                this.author,
                this.getId());
    }
}
