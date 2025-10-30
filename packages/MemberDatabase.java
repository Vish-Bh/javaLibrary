package packages;
import packages.Member;
import java.util.Scanner;
import java.util.ArrayList;
import packages.Data;
//Methods to implement
// addMember, removeMemberById interactive and no, searchMember, updateMemberById, printMembers
public class MemberDatabase{
    private Scanner input;
    Data data = new Data();
    private ArrayList<Member> memberList;

    // Testing main method
    public static void main (String[] main){
        System.out.println("Member Database ");
    }
    //Constructor
    public MemberDatabase(Scanner input1){
        input = input1;
        memberList=data.loadMembers();
    }
    
    public void addMember(){
    System.out.print("Enter member name: ");
    String name = input.nextLine();
    System.out.print("Enter member id: ");
    int memberId = input.nextInt();
    input.nextLine();
    System.out.print("Enter Member pin: ");
    int pin = input.nextInt();
    input.nextLine();
    Member m = searchMember(memberId);
    if (m!=null){ 
        System.out.println("Member with this ID already exists. Cannot add duplicate member.");
        return;
    }
    memberList.add( new Member(name, memberId, pin));
    }

    public Member searchMember(int memberId){
        for(Member m: memberList){
            if(m.getMemberId()==memberId){
                System.out.println("Member found: "+m);
                return m;
            }
        }
        System.out.println("No member found with this ID");
        return null;
    }

    public Member searchMember(String memberName){
        for (Member m : memberList){
            if (m.getName().equalsIgnoreCase(memberName)){
                return m;
            }
        }
        System.out.println("No Member with name "+ memberName);
        return null;
    }

    public void updateMemberById(int id){
        for(Member m: memberList){
            if(m.getMemberId()==id){
                System.out.print("Enter new name: ");
                String newName = input.nextLine();
                m.setName(newName);
                System.out.print("Enter new pin: ");
                int newPin = input.nextInt();
                input.nextLine();
                m.setPin(newPin);
                System.out.println("Member updated: "+m);
                return;}
            }
            System.out.println("No member found with this ID");
    }
    
    public void removeMemberById(){
        System.out.print("Enter member id to remove: ");
        int memberId = input.nextInt();
        input.nextLine();
        boolean flag=false;
        for(Member m: memberList){
            if(m.getMemberId()==memberId){
                memberList.remove(m);
                System.out.println("Member removed: "+m);
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("No member found with this ID");
        }
    }

    public void printMembers(){
        for(Member m: memberList){
            System.out.println(m);
        }
    }
    
    public ArrayList<Member> getMembers(){
        return memberList;
    }

    public  void saveMemberDatabase(){
        data.saveMembers(this.memberList);
        System.out.println("MemberData Saved!");
    }


    public void loadMemberDatabase(){
        this.memberList=(data.loadMembers());
    }


}