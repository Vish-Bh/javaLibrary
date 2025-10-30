package packages;
import packages.MemberDatabase;

public class Auth {
    public Member currentUser;
    private MemberDatabase memberDatabase;

    public Auth(MemberDatabase mdb){
        memberDatabase=mdb;
    }
    public static void main(String[] args) {
        System.out.println("AUTH CLASS");
    }
    public void getCurrentUser(){
        System.out.println(currentUser);
    }

    public void logIn(int id , int pin){
        Member m=memberDatabase.searchMember(id);
        if (m!=null){
            if (m.isPin(pin)){
                currentUser=m;
                System.out.println(m.getName()+"is logged in.");
                return;
            }
            System.out.println("Invalid pin");
        }
        System.out.println("USER WITH ID "+id+"DOES NOT EXIST");
    }

    public void logIn(String name , int pin){
        Member m=memberDatabase.searchMember(name);
        if (m!=null){
            if (m.isPin(pin)){
                currentUser=m;
                System.out.println(m.getName()+"is logged in.");
                return;
            }
            System.out.println("Invalid pin");
        }
        System.out.println("USER WITH NAME "+name+"DOES NOT EXIST");
    }

    public void logOut(){
        currentUser=null;
    }
}
