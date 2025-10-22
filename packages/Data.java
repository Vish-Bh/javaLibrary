package packages;
import packages.Book;
import packages.Library;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Data{
    public void saveData(Library lib){
        try{
            FileOutputStream fos = new FileOutputStream("data/books.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lib.getBooks());
            oos.close();
            fos.close();
            System.out.println("Library data saved successfully.");
        }catch(Exception e){
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }
    public ArrayList<Book> loadData(){
        ArrayList<Book> books = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("data/books.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            books = (ArrayList<Book>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Library data loaded successfully.");
        }catch(Exception e){
            System.out.println("Error loading library data: " + e.getMessage());
        }
        return books;
    }
}