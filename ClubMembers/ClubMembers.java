import java.util.ArrayList;

public class ClubMembers {
    private ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();
    /** Adds new club members to memberList, as described in part (a).
    * Precondition: names is a non-empty array.
    */
    public void addMembers(String[] names, int gradYear) {
        /* to be implemented in part (a) */
        for (String student : names) {
            this.memberList.add(new MemberInfo(student, gradYear, true));
        }
    }
    /** Removes members who have graduated and returns a list of members who have graduated
    * and are in good standing, as described in part (b).
    */
    public ArrayList<MemberInfo> removeMembers(int year) {
        /* to be implemented in part (b) */
        ArrayList<MemberInfo> graduated = new ArrayList<MemberInfo>();
        for (int i = memberList.size() - 1; i >= 0; i--) {
            if (memberList.get(i).getGradYear() <= year) {
                if (memberList.get(i).inGoodStanding()) {
                    graduated.add(memberList.get(i));
                }
                memberList.remove(memberList.remove(i));
            }
        }
        return graduated;
    }

    public void updateStanding(String name) {
        for (MemberInfo member : memberList) {
            if (member.getName().equals(name)) {
                member.setStanding(false);
            }
        }
    }

    public ArrayList<MemberInfo> getMemberList() {
        return this.memberList;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}
