package library;

import static library.Author.sc;

public class Book extends Issue {
    private long isbn;

    public Book(String name, Author author, long isbn) {
        super(name, author);
        this.isbn = isbn;
        System.out.println("[НОВА КНИГА] " + this);
    }

    public Book(long isbn) {
        this.isbn = isbn;
        System.out.println("[НОВА КНИГА] " + this);
    }

    public Book() {
        System.out.println("===< Нова книга >===");
        System.out.print("Въведете ISBN за тази книга: ");
        this.isbn = sc.nextLong();
        System.out.println("[НОВА КНИГА] " + this);
    }

    @Override
    long getId() {
        return isbn;
    }

    @Override
    void setId(long id) {
        this.isbn = id;
    }

    @Override
    public String toString() {
        return "Книга: " + super.toString();
    }
}
