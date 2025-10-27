import java.util.Scanner;
import packages.*;
public class Main{
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try{

        Library lib = new Library(input);
        MemberDatabase memberDb = new MemberDatabase(input);
        boolean whileFlag=true;
        while(whileFlag){
        System.out.println("Welcome to the Library Management System!");
        System.out.println("You can add, remove, search books and view all books in the library.");
        System.out.println("Let's get started!");
        System.out.println();
        System.out.println("Enter 1 to add a book.");
        System.out.println("Enter 2 to view all books.");   
        System.out.println("Enter 3 to search a book by title.");
        System.out.println("Enter 4 to filter books by genre.");
        System.out.println("Enter 5 to remove a book by title.");
        System.out.println("Enter 6 to save library data.");
        System.out.println("Enter 7 to load library data.");
        System.out.println("Enter 8  to load sample data into library.");
        System.out.println("Enter 9 to create a member.");
        System.out.println("Enter 10 to view all members.");
        System.out.println();
        int choice = input.nextInt();
        input.nextLine(); 
        switch(choice){
            case 1:
                lib.addBook();
                break;
            case 2:
                lib.printBooksData();
                break;
            case 3:
                lib.searchBookByTitle();
                break;
            case 4:
                lib.searchBookByGenre();
                break;
            case 5:
                lib.removeBookByTitle();
                break;
            case 6:
                lib.saveLibraryData();
                break;
            case 7:
                lib.loadLibraryData();
                break;
            case 8:
                lib.preloadBooks();
                break;
            case 9:
                memberDb.addMember();
                break;
            case 10:
                memberDb.printMembers();
                break;
            
            case 999:
                whileFlag=false;
                System.out.println("Closing lib");
                return;
        }

    
    }


        }
        catch  (Exception e) {
            System.out.println("WHY u crached my program :< ");
            System.out.println("Something unexpected happen " + e.getMessage());
            e.printStackTrace();
        }
    }
}