package packages;
import packages.Book;
import java.util.ArrayList;
import java.io.Serializable;

public class Member implements Serializable {

    
    private static final long serialVersionUID = 1L;
    private String name;
    private int memberId;
    private int pin;
    private int accessLevel =1;
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
        this.accessLevel= 5; }
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

    public void setAccessLevel(int al) {
    if (al == 1 || al == 3 || al == 5){
        this.accessLevel = al;
        return ;
    }
    
    System.out.println("Invalid access level");
    }
    public int getAccessLevel() {
return accessLevel;
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