public class Main {
    public static void main(String[] args) {
        Thread spool = new Thread(15, "blue");
        System.out.println(spool.getLength());
        System.out.println(spool.getColor());

        Car car = new Car("Tesla", "Cybertruck");
        System.out.println(car.getMake());
        System.out.println(car.getModel());

        Date date = new Date(4, 4, 2007);
        date.print();
        date.changeMonth(12);
        date.changeDay(12);
        date.changeYear(2024);
        date.print();

        Player player = new Player("Pendoof", 0);
        System.out.println(player.getName());
        System.out.println(player.getScore());
        player.updateScore(100);
        System.out.println(player.getScore());
    }
}