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
        System.out.println("Enter 11 to remove a member by ID.");
        System.out.println("Enter 12 to update member details by ID.");
        System.out.println("Enter 13 to search a member by ID.");
        System.out.println("Enter 14 to save the member database");
        System.out.println("ENter 15 to load the member database");
        System.out.println("Enter 999 to exit.");
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
            case 11:
                memberDb.removeMemberById();
                break;
            case 12:
                System.out.println("Enter the id oof the member");
                choice =input.nextInt();
                input.nextLine();
                memberDb.updateMemberById(choice);
                break;
            case 13:
                System.out.println("Enter the id oof the member");
                choice =input.nextInt();
                memberDb.searchMemberById(choice);
                break;
            case 14:
                memberDb.saveMemberDatabase();
                break;
            case 15:
                memberDb.loadMemberDatabase();
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

//Bug
// Enter 1 to add a book.
// Enter 2 to view all books.
// Enter 3 to search a book by title.
// Enter 4 to filter books by genre.
// Enter 5 to remove a book by title.
// Enter 6 to save library data.
// Enter 7 to load library data.
// Enter 8  to load sample data into library.
// Enter 9 to create a member.
// Enter 10 to view all members.
// Enter 11 to remove a member by ID.
// Enter 12 to update member details by ID.
// Enter 13 to search a member by ID.
// Enter 14 to save the member database
// ENter 15 to load the member database
// Enter 999 to exit.

// 12
// Enter the id oof the member
// 12
// No member found with this ID
// No member found with this ID
// No member found with this ID
// Enter new name: Enter new pin: