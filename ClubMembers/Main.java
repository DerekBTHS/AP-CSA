public class Main {
    public static void main(String[] args) {
        ClubMembers club = new ClubMembers();
        String[] names = {"SMITH, JANE"};
        club.addMembers(names, 2019);
        club.updateStanding("SMITH, JANE");
        names[0] = "FOX, STEVE";
        club.addMembers(names, 2018);
        names[0] = "XIN, MICHAEL";
        club.addMembers(names, 2017);
        club.updateStanding("XIN, MICHAEL");
        names[0] = "GRACIA, MARIA";
        club.addMembers(names, 2020);

        for (MemberInfo member : club.getMemberList()) {
            System.out.println(member.getName() + " " + member.getGradYear() + " " + member.inGoodStanding());
        }
        System.out.println();
        for (MemberInfo member : club.removeMembers(2018)) {
            System.out.println(member.getName() + " " + member.getGradYear() + " " + member.inGoodStanding());
        }
        System.out.println();
        for (MemberInfo member : club.getMemberList()) {
            System.out.println(member.getName() + " " + member.getGradYear() + " " + member.inGoodStanding());
        }
    }
}
