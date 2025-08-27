package library.system;
import library.model.LibraryMember;
import library.model.Book;
import java.util.ArrayList;

public class Library {
    ArrayList<LibraryMember> members = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void addMember(LibraryMember member) {
        members.add(member);
    }
    public void borrowBook(Book book, LibraryMember member) {
        if(members.contains(member) && books.contains(book)) {
            System.out.println(member+ " borrowed book " + book);
            member.borrowed_books.add(book);
            books.remove(book);
        }
    }
    public void returnBook(Book book, LibraryMember member) {
        if(members.contains(member) && member.borrowed_books.contains(book)) {
            System.out.println(member+ " returned book " + book);
            member.borrowed_books.remove(book);
            books.add(book);
        }
    }
    public void reserveBook(Book book, LibraryMember member) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void cancelReservation(Book book, LibraryMember member) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book);
        }
    }
}
