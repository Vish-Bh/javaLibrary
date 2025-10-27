package packages;
import packages.Member;
import java.util.Scanner;
import java.util.ArrayList;

public class MemberDatabase{
    private Scanner input;
    private ArrayList<Member> memberList;
    public static void main (String[] main){
        System.out.println("Member Database ");
    }
    public MemberDatabase(Scanner input1){
        input = input1;
        memberList= new ArrayList<>();
    }
    public void addMember(){
    // Member consructer
    // public Member(String name, int memberId, int pin) {
    //         this.name = name;
    //         this.memberId = memberId;
    //         this.pin=pin;

    //     }  
    System.out.print("Enter member name: ");
    String name = input.nextLine();
    System.out.print("Enter member id: ");
    int memberId = input.nextInt();
    input.nextLine();
    System.out.print("Enter Member pin");
    int pin = input.nextInt();
    input.nextLine();
    memberList.add( new Member(name, memberId, pin));
    }

    public void printMembers(){
        for(Member m: memberList){
            System.out.println(m);
        }
    }
}