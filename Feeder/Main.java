public class Main {
    public static void main(String[] args) {
        // simulate cases as shown in part a
        Feeder a1 = new Feeder(500);
        a1.simulateOneDay(12);
        System.out.println(a1.getCurrentFood());
        Feeder a2 = new Feeder(1000);
        a2.simulateOneDay(22);
        System.out.println(a2.getCurrentFood());
        Feeder a3 = new Feeder(100);
        a3.simulateOneDay(5);
        System.out.println(a3.getCurrentFood());
    }
}
