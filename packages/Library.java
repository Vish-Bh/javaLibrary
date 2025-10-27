package  packages;
import java.util.ArrayList;
import packages.Book;
import packages.Data;
import java.util.Scanner;



//Methods implemented so far
//addBook, getBooks, searchBookByGenre, removeBookByTitle, searchBookByTitle,searchBookByGenre,
//  saveLibraryData, loadLibraryData, updateBookData, printBooksData, preloadBooks
public class Library{

    private ArrayList<Book> books;
    private Scanner input;
    private Data dataHandler = new Data();

    //Main Method for testing
    public static void main(String[] args) {
    System.out.println("Library MAIN FUNCTION.");  
    }
    
    // Constructor
    public Library(Scanner input1) {
        input =input1;
        books = new ArrayList<>();
        loadLibraryData();
        
    }
    
    //sample data to test
    public void preloadBooks() {
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 4.8f, Book.Genre.FANTASY, Book.Genre.ADVENTURE));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 4.5f, Book.Genre.ROMANCE));
        books.add(new Book("Dune", "Frank Herbert", 1965, 4.7f, Book.Genre.SCIENCE_FICTION, Book.Genre.ACTION));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997, 4.9f, Book.Genre.FANTASY, Book.Genre.ADVENTURE));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 4.4f, Book.Genre.ROMANCE));
        books.add(new Book("1984", "George Orwell", 1949, 4.6f, Book.Genre.SCIENCE_FICTION, Book.Genre.ACTION));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 4.2f, Book.Genre.ROMANCE));
        books.add(new Book("Moby Dick", "Herman Melville", 1851, 4.1f, Book.Genre.ADVENTURE));
        books.add(new Book("The Odyssey", "Homer", -700, 4.3f, Book.Genre.ADVENTURE, Book.Genre.FANTASY));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 4.5f, Book.Genre.SCIENCE_FICTION));
        books.add(new Book("Jane Eyre", "Charlotte Bronte", 1847, 4.4f, Book.Genre.ROMANCE));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 4.9f, Book.Genre.FANTASY, Book.Genre.ADVENTURE));
        books.add(new Book("Animal Farm", "George Orwell", 1945, 4.6f, Book.Genre.SCIENCE_FICTION, Book.Genre.ACTION));
        books.add(new Book("Wuthering Heights", "Emily Bronte", 1847, 4.3f, Book.Genre.ROMANCE));
        books.add(new Book("Frankenstein", "Mary Shelley", 1818, 4.4f, Book.Genre.SCIENCE_FICTION, Book.Genre.FANTASY));
        books.add(new Book("The Alchemist", "Paulo Coelho", 1988, 4.2f, Book.Genre.ADVENTURE));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, 4.1f, Book.Genre.ACTION, Book.Genre.ADVENTURE));
        books.add(new Book("Twilight", "Stephenie Meyer", 2005, 4.0f, Book.Genre.ROMANCE, Book.Genre.FANTASY));
        books.add(new Book("Ender's Game", "Orson Scott Card", 1985, 4.7f, Book.Genre.SCIENCE_FICTION, Book.Genre.ACTION));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, 4.6f, Book.Genre.ACTION, Book.Genre.ADVENTURE));
    }

    // Add a new book to the library
    // Get book details from user input
    // Create a new Book object and add it to the books list
    //
    public void addBook() {
        String title, author;
        // input.nextLine();
        System.out.print("Enter book title: ");
        title = input.nextLine();
        System.out.print("Enter book author: ");
        author = input.nextLine();
        int publishYear;
        float ratings;
        System.out.print("Enter publication year: ");
        publishYear = input.nextInt();
        System.out.print("Enter book ratings: ");
        ratings = input.nextFloat();
        ArrayList<Book.Genre> genreList= new ArrayList<>();
        int i=1;
        while(i>0){
            System.out.println("Select genre: 1. FANTASY 2. ROMANCE 3. SCIENCE_FICTION 4. ADVENTURE 5. ACTION");
            int genreChoice = input.nextInt();
            Book.Genre genre;
            switch (genreChoice) {
                case 1 -> genre = Book.Genre.FANTASY;
                case 2 -> genre = Book.Genre.ROMANCE;
                case 3 -> genre = Book.Genre.SCIENCE_FICTION;
                case 4 -> genre = Book.Genre.ADVENTURE;
                case 5 -> genre = Book.Genre.ACTION;
                default->{
                    System.out.println("Invalid choice, defaulting to FANTASY.");
                    genre = Book.Genre.FANTASY;
                }
            } 
            genreList.add(genre);
            System.out.print("Do you want to add another genre? (1 for Yes / 0 for No): ");
            i = input.nextInt();
        }
        input.nextLine(); 
        if(searchBookByTitle(title)){
            System.out.println("Book with this title already exists. Not adding duplicate.");
            return;
        }
        books.add(new Book(title, author, publishYear, ratings, genreList.toArray(new Book.Genre[0])));
    }

    public ArrayList<Book> getBooks() {return books;   }
    //Books are arraylist of book objects
    public void printBooksData() {
        System.out.println("Retrieving all books from the database.");
        System.out.println(books);
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
    }

    public void searchBookByGenre() {
        System.out.println("Enter genre to filter books: 1. FANTASY 2. ROMANCE 3. SCIENCE_FICTION 4. ADVENTURE 5. ACTION");
        int genreChoice = input.nextInt();
        Book.Genre g;
        switch (genreChoice) {
            case 1 -> g = Book.Genre.FANTASY;
            case 2 -> g = Book.Genre.ROMANCE;
            case 3 -> g = Book.Genre.SCIENCE_FICTION;
            case 4 -> g = Book.Genre.ADVENTURE;
            case 5 -> g = Book.Genre.ACTION;
            default -> {
                System.out.println("Invalid choice, defaulting to FANTASY.");
                g = Book.Genre.FANTASY;
            }
        }
        //
        System.out.println("Books in genre: " + g);
        boolean flag=false;
        for (Book book : books) {
            if (book.hasGenre(g)) {
                System.out.println(book.getInfo());
                flag=true;
            }

        }
        if(!flag){
        System.out.println("No books found in this genre.");
        }
    }

    public void removeBookByTitle() {
        System.out.print("Enter book title to remove: ");
        String title = input.nextLine();
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Book with title \"" + title + "\" has been removed from the library.");
    }

    public boolean searchBookByTitle() {
        System.out.print("Enter book title to search: ");
        String title = input.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getInfo());
                return true;
            }
        }
        System.out.println("Book not found in the library.");
        return false;
    }
    
    public boolean searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getInfo());
                return true;
            }
        }
        System.out.println("Book not found in the library.");
        return false;
    }
    
    public boolean updateBookData(String title, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, updatedBook);
                System.out.println("Book data updated for title: " + title);
                return true;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
        return false;
    }

    public void saveLibraryData() {
        dataHandler.saveBooks(this.books);
    }
    
    public void loadLibraryData() {
        this.books.addAll(dataHandler.loadBooks());
    }
}
