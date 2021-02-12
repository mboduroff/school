package library;

import static library.Author.sc;

public class Book extends Issue {
    private String isbn;

    public Book(String name, Author author, String isbn) {
        super(name, author);
        this.isbn = isbn;
        System.out.println("[НОВА КНИГА] " + this);
    }

    public Book(String isbn) {
        this.isbn = isbn;
        System.out.println("[НОВА КНИГА] " + this);
    }

    public Book() {
        System.out.println("===< Нова книга >===");
        System.out.print("Въведете ISBN за тази книга: ");
        this.isbn = sc.next();
        System.out.println("[НОВА КНИГА] " + this);
    }

    @Override
    String getId() {
        return isbn;
    }

    @Override
    void setId(String id) {
        this.isbn = id;
    }

    @Override
    public String toString() {
        return "Книга: " + super.toString();
    }
}
