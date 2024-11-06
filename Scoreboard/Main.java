public class Main {
    public static void main(String[] args) {
        String info;
        /*
         * game is a new Scoreboard for
         * a game played between team 1, whose
         * name is "Red", and team 2, whose
         * name is "Blue". The active team
         * is set to team 1.
         */
        Scoreboard game = new Scoreboard("Red", "Blue");
        info = game.getScore();
        System.out.println(info);
        /*
         * Team 1 earns 1 point because the
         * game always begins with team 1 as
         * the active team.
        */
        game.recordPlay(1);
        info = game.getScore();
        System.out.println(info);
        /* 
         * Team 1’s play failed, so team 2 is
         * now active.
         */
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info);
        /*
         * The score and state of the game are
         * unchanged since the last call to
         * getScore.
         */
        info = game.getScore();
        System.out.println(info);
        // Team 2 earns 3 points.
        game.recordPlay(3);
        info = game.getScore();
        System.out.println(info);
        // Team 2 earns 1 point.
        game.recordPlay(1);
        /* 
         * Team 2’s play failed, so team 1 is
         * now active.
         */
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info);
        /* 
         * Team 1’s play failed, so team 2 is
         * now active.
         */
        game.recordPlay(0);
        // Team 2 earns 4 points.
        game.recordPlay(4);
        /*
         * Team 2’s play failed, so team 1 is
         * now active.
         */
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info);
        /*
         * match is a new and independent
         * Scoreboard object.
         */
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        info = match.getScore();
        System.out.println(info);
        info = game.getScore();
        System.out.println(info);
    }
}
