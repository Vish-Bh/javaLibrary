package packages;

import java.io.*;
import java.util.ArrayList;

public class Data {
    public Data(){
    }

    private void ensureDir() {
        new File("data").mkdirs();
    }

    public void saveBooks(ArrayList<Book> books) {
        saveObject("data/books.ser", books, "books");
    }

    public void saveMembers(ArrayList<Member> members) {
        saveObject("data/members.ser", members, "members");
    }

    public ArrayList<Book> loadBooks() {
        return (ArrayList<Book>) loadObject("data/books.ser", "books");
    }

    public ArrayList<Member> loadMembers() {
        return (ArrayList<Member>) loadObject("data/members.ser", "members");
    }

    private void saveObject(String path, Object obj, String label) {
        ensureDir();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            System.out.println(label + " data saved.");
        } catch (Exception e) {
            System.out.println("Error saving " + label + " data: " + e.getMessage());
        }
    }

    private Object loadObject(String path, String label) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object data = ois.readObject();
            System.out.println(label + " data loaded.");
            return data;
        } catch (Exception e) {
            System.out.println("Error loading " + label + " data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
