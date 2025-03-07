public class Main {
    public static void main(String[] args) {
        SingleTable t1 = new SingleTable(4, 74, 60.0);
        SingleTable t2 = new SingleTable(8, 74, 70.0);
        SingleTable t3 = new SingleTable(12, 76, 75.0);
        CombinedTable ct1 = new CombinedTable(t1, t2);

        System.out.println(ct1.canSeat(9));
        System.out.println(ct1.canSeat(11));
        System.out.println(ct1.getDesirability());
        
        CombinedTable ct2 = new CombinedTable(t2, t3);

        System.out.println(ct2.canSeat(18));
        System.out.println(ct2.getDesirability());

        t2.setViewQuality(80);
        System.out.println(ct2.getDesirability());
    }
}
