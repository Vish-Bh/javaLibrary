package packages;
import packages.Member;
import packages.MemberDatabase;

public class Auth {
public static final int GUEST = 1;
public static final int STAFF = 3;
public static final int ADMIN = 5;

private Member currentUser;
private MemberDatabase memberDatabase;



public void setMemberDatabase(MemberDatabase memberDatabase) {
    this.memberDatabase = memberDatabase;
}

public void getCurrentUser() {
    if (currentUser != null)
        System.out.println("Current user: " + currentUser.getName() + " (Level " + currentUser.getAccessLevel() + ")");
    else
        System.out.println("No user logged in.");
}

public void logIn(int id, int pin) {
    
    Member m = memberDatabase.searchMemberRaw(id);
    if (m == null) {
        System.out.println("User with ID " + id + " does not exist.");
        return;
    }

    if (m.isPin(pin)) {
        currentUser = m;
        System.out.println(m.getName() + " is logged in.");
    } else {
        System.out.println("Invalid PIN.");
    }
}

public void logIn(String name, int pin) {
    Member m = memberDatabase.searchMemberRaw(name);
    if (m == null) {
        System.out.println("User with name " + name + " does not exist.");
        return;
    }

    if (m.isPin(pin)) {
        currentUser = m;
        System.out.println(m.getName() + " is logged in.");
    } else {
        System.out.println("Invalid PIN.");
    }
}

public void logOut() {
    if (currentUser != null) {
        System.out.println(currentUser.getName() + " has logged out.");
        currentUser = null;
    } else {
        System.out.println("No user is logged in.");
    }
}

public boolean can(int requiredLevel) {
    if (currentUser == null) {
        System.out.println("Access denied. No user logged in.");
        return false;
    }
    if (currentUser.getAccessLevel() >= requiredLevel) {
        return true;
    }
    System.out.println("Access denied. Insufficient privilege level.");
    return false;
}

}
