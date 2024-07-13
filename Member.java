
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String contactInfo;
    private String password;
    public static List<Member> membersList = new ArrayList<>();

    public Member(String contactInfo, String password) {
        this.contactInfo = contactInfo;
        this.password = password;
        membersList.add(this);
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getPassword() {
        return password;
    }
}
