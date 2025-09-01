import java.util.ArrayList;

class Book{
    private String title;
    private String author;
    private int publication_year;
    double rating;
    ArrayList<String> reviews = new ArrayList<String>();

    public Book(String title, String author, int publication_year){
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
    }

    public void getInfo(){
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.author);
        System.out.println("Publication year: "+this.publication_year);
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public void addReview(String review){
        this.reviews.add(review);
    }

    @Override
    public String toString() {
        return this.title;
    }

}

class Library{
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public void getUsers(){
        for(User user : users){
            System.out.println(user.name+" Borrowed Books:"+ user.borrowed_books.toString());
        }
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void getBooks(){
        System.out.println("Books:");
        for(Book book:books){
            book.getInfo();
        }
    }

    public void findBooksByAuthor(String author){
        System.out.println("Books by Author "+author+" :");
        for(Book book:books){
            if(book.getAuthor().equals(author)){
            book.getInfo();}
        }
    }

    public void borrowBook(String title, User user){
        for(Book book:books){
            if(book.getTitle().equals(title)){
                user.borrowed_books.add(book);
            }
        }
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public void returnBook(Book book,User user){
        books.add(book);
        user.borrowed_books.remove(book);
    }

    public boolean isBookAvailable(String title){
        for(Book book:books){
            if(book.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public Double getAverageBookRating(){
        double sum = 0;
        for (Book book:books){
            sum += book.rating;
        }
        return sum/books.size();
    }

    public Book getMostReviewedBook(){
        int MaxReviews = 0;
        Book mostReviewedBook = null;
        for(Book book:books){
            if (book.reviews.size() > MaxReviews){
                MaxReviews = book.reviews.size();
                mostReviewedBook = book;
            }
        }
        return mostReviewedBook;
    }
}

class User {
    String name;
    int age;
    ArrayList<Book> borrowed_books;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowed_books = new ArrayList<>();
    }
}

class LibraryMain{
    public static void main(String[] args){
        Book book1 = new Book("Introduction to Java Programming","John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms","Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction","Alice Johnson", 2019);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.getBooks();
        library.findBooksByAuthor("Jane Doe");

        User user1 = new User("Jane Smith", 18);

        library.addUser(user1);
        library.borrowBook("Introduction to Java Programming",user1);
        library.getBooks();
        library.returnBook(book1,user1);
        library.getBooks();
        System.out.println(library.isBookAvailable("Introduction to Java Programming"));

        book1.setRating(5);
        System.out.println(library.getAverageBookRating());
        book2.addReview("test1");
        book1.addReview("test2");
        book1.addReview("test3");
        System.out.println(library.getMostReviewedBook().getTitle());
        library.borrowBook("Introduction to Java Programming",user1);
        library.getUsers();
    }
}
