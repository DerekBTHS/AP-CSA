public class Main {
    public static void main(String[] args) {

        Level levelOne = new Level(true, 200);
        Level levelTwo = new Level(true, 100);
        Level levelThree = new Level(true, 500);
        Game game1 = new Game(levelOne, levelTwo, levelThree, true);
        System.out.println(game1.getScore());

        levelOne = new Level(true, 200);
        levelTwo = new Level(true, 100);
        levelThree = new Level(false, 500);
        Game game2 = new Game(levelOne, levelTwo, levelThree, false);
        System.out.println(game2.getScore());

        levelOne = new Level(true, 200);
        levelTwo = new Level(false, 100);
        levelThree = new Level(true, 500);
        Game game3 = new Game(levelOne, levelTwo, levelThree, true);
        System.out.println(game3.getScore());
        
        levelOne = new Level(false, 200);
        levelTwo = new Level(true, 100);
        levelThree = new Level(true, 500);
        Game game4 = new Game(levelOne, levelTwo, levelThree, false);
        System.out.println(game4.getScore());
    }
}
