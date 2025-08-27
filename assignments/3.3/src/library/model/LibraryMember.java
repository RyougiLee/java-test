package library.model;

import java.util.ArrayList;

public class LibraryMember {
    String name;
    int memberID;
    public ArrayList<Book> borrowed_books = new ArrayList<>();
    ArrayList<Book> reserved_books = new ArrayList<>();

    public LibraryMember(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public boolean hasReservedBook(Book book){
        return reserved_books.contains(book);
    }

    public void removeReservedBook(Book book){
        reserved_books.remove(book);
    }

    public void addReservedBook(Book book){
        reserved_books.add(book);
    }

    public ArrayList<Book> getReservedBooks() {
        return reserved_books;
    }

    @Override
    public String toString() {
        return name;
    }
}
