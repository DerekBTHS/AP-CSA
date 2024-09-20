public class Scoreboard {

    private int activeTeam;
    private String teamName1;
    private String teamName2;
    private int score1;
    private int score2;

    public Scoreboard(String team1, String team2) {
        activeTeam = 1;
        teamName1 = team1;
        teamName2 = team2;
    }
    
    public String getScore() {
        if (activeTeam == 1) {
            return (score1 + "-" + score2 + "-" + teamName1);
        } else if (activeTeam == 2) {
            return (score1 + "-" + score2 + "-" + teamName2);
        }
        return null;
    }

    public void recordPlay(int point) {
        if (point == 0) {
            if (activeTeam == 1) {
                activeTeam = 2;
            } else if (activeTeam == 2) {
                activeTeam = 1;
            }
        } else if (activeTeam == 1) {
            score1 += point;
        } else if (activeTeam == 2) {
            score2 += point;
        }
    }
}
