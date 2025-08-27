package library;

import library.system.Library;
import library.model.Book;
import library.model.LibraryMember;

public class Main{
    public static void main(String[] args){
        Library library = new Library();
        Book book1 = new Book("Introduction to Java Programming","John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms","Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction","Alice Johnson", 2019);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        LibraryMember user1 = new LibraryMember(1,"Jane Smith");
        library.addMember(user1);
        library.borrowBook(book1,user1);
        library.returnBook(book1,user1);

        library.reserveBook(book2,user1);
        library.displayReservedBooks(user1);
        library.cancelReservation(book2,user1);
    }
}