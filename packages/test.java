package packages;
import java.util.ArrayList;
import packages.Book;
import java.util.HashSet;
public class test {
    public static void main(String[] args) {
        HashSet<Book> a = new HashSet<>
        ();
        ArrayList<Book> b = new ArrayList<>(); 

        a.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 4.8f, Book.Genre.FANTASY, Book.Genre.ADVENTURE));
        b.add(new Book("The Hobbit", "J.R.R. Tolkien",  1937, 4.8f, Book.Genre.FANTASY, Book.Genre.ADVENTURE));
        
        // System.out.println(book1.getInfo());
        for(Book book : a) {
            System.out.println(book.getInfo());
        }

    }
    
}
