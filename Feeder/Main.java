public class Main {
    public static void main(String[] args) {
        System.out.println("Test cases as shown in part a: ");
        Feeder a1 = new Feeder(500);
        a1.simulateOneDay(12);
        System.out.println(a1.getCurrentFood());
        Feeder a2 = new Feeder(1000);
        a2.simulateOneDay(22);
        System.out.println(a2.getCurrentFood());
        Feeder a3 = new Feeder(100);
        a3.simulateOneDay(5);
        System.out.println(a3.getCurrentFood());

        System.out.println("Test cases as shown in part b: ");
        Feeder b1 = new Feeder(2400);
        System.out.println(b1.simulateManyDays(10, 4));
        Feeder b2 = new Feeder(250);
        System.out.println(b2.simulateManyDays(10, 5));
        Feeder b3 = new Feeder(0);
        System.out.println(b3.simulateManyDays(5, 10));
    }
}
