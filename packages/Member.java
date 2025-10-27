package packages;
import packages.Book;
import java.util.ArrayList;

public class Member {
    private String name;
    private int memberId;
    private int pin;
    
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    public Member(String name, int memberId, int pin) {
        this.name = name;
        this.memberId = memberId;
        this.pin=pin;

    }   
    // getters and setters
    public String getName() {
        return name;}
    public int getMemberId() {
        return memberId;}
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;}
    public void borrowBook(Book book) {
        if (!(borrowedBooks.size()>3))
        {
        borrowedBooks.add(book);

        }
        System.out.println("U have reached the maximum borrow limit");
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId=" + memberId +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
    
    

    }