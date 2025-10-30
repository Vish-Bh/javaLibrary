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
    Auth auther;

    // Testing main method
    public static void main (String[] main){
        System.out.println("Member Database ");
    }
    //Constructor
    public MemberDatabase(Scanner input1, Auth al) {
    this.auther = al;
    this.input = input1;
    this.data = new Data();
    this.memberList =data.loadMembers(); 
}

    public void addMember(){
    if (!auther.can(5)) return;

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

    public void addMember(boolean al){
        if(!auther.can(5)) return;
    System.out.print("Enter member name: ");
    String name = input.nextLine();
    System.out.print("Enter member id: ");
    int memberId = input.nextInt();
    input.nextLine();
    System.out.print("Enter Member pin: ");
    int pin = input.nextInt();
    input.nextLine();
    Member m = searchMemberRaw(memberId);
    if (m!=null){ 
        System.out.println("Member with this ID already exists. Cannot add duplicate member.");
        return;
    }
    memberList.add( new Member(name, memberId, pin,true));
    }

    public Member searchMember(int memberId){
        if (!auther.can(3)) return null;

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
    if (!auther.can(3)) return null;
        for (Member m : memberList){
            if (m.getName().equalsIgnoreCase(memberName)){
                return m;
            }
        }
        System.out.println("No Member with name "+ memberName);
        return null;
    }

    public void updateMemberById(int id){
        if (!auther.can(5)) return;
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
        if (!auther.can(5)) return;
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
     if(!auther.can(5)) return;

        for(Member m: memberList){
            System.out.println(m);
        }
    }
    
    public ArrayList<Member> getMembers(){
            if (!auther.can(5)) return null;

        return memberList;
    }

    public  void saveMemberDatabase(){
            if (!auther.can(5)) return;
        data.saveMembers(this.memberList);
        System.out.println("MemberData Saved!");
    }


    public void loadMemberDatabase(){
            if (!auther.can(5)) return;
        this.memberList=(data.loadMembers());
    }

    public Member searchMemberRaw(int memberId){

        for(Member m: memberList){
            if(m.getMemberId()==memberId){
                System.out.println("Member found: "+m);
                return m;
            }
        }
        System.out.println("No member found with this ID");
        return null;
    }

    public Member searchMemberRaw(String memberName){
        for (Member m : memberList){
            if (m.getName().equalsIgnoreCase(memberName)){
                return m;
            }
        }
        System.out.println("No Member with name "+ memberName);
        return null;
    }


}