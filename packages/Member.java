package packages;
import packages.Book;
import java.util.ArrayList;
import java.io.Serializable;

public class Member implements Serializable {

    enum AccessLevel{
        L1,
        L3,
        L5
    }
    private static final long serialVersionUID = 1L;
    private String name;
    private int memberId;
    private int pin;
    private AccessLevel accessLevel =AccessLevel.L1;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    
    //Constructor
    public Member(String name, int memberId, int pin) {
        this.name = name;
        this.memberId = memberId;
        this.pin=pin;
    }
    public Member(String name, int memberId, int pin, Boolean isAdmin) {
        if(isAdmin){this.name = name;
        this.memberId = memberId;
        this.pin=pin;
        this.accessLevel=AccessLevel.L5; }
        else{
            this.name = name;
        this.memberId = memberId;
        this.pin=pin;
        }
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
            book.borrowing();
            borrowedBooks.add(book);
        }
        System.out.println("U have reached the maximum borrow limit");
    }
    
    public void returnBook(Book book) {
        book.returning();
        borrowedBooks.remove(book);
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isPin(int pin){
        if (this.pin==pin){
            return true;
        }
        return false;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
    
    //When a member object is printed, this method is called
    //Example System.out.println(memberObject);
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId=" + memberId +
                ", pin ="+pin+
                ", borrowedBooks=" + borrowedBooks +
                '}';}

    }