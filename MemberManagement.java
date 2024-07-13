
public class MemberManagement {

    public void addMember(String email, String password) {
        new Member(email, password);
    }

    public boolean authenticate(String email, String password) {
        for (Member member : Member.membersList) {
            if (member.getContactInfo().equals(email) && member.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
