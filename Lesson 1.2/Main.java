public class Main {
    public static void main(String[] args) {
        String NAME = "Derek Chen";
        boolean LIKESPENGUINS = true;
        double PAYCHECK = 338.36;
        int WEEKS = 5;
        WEEKS = WEEKS + 1;
        final double moneyTotal = PAYCHECK * WEEKS;
        System.out.print("My name is ");
        System.out.println(NAME);
        System.out.print("The statement I like penguins is: ");
        System.out.println(LIKESPENGUINS);
        System.out.print("This summer I worked ");
        System.out.print(WEEKS);
        System.out.print(" weeks earning $");
        System.out.print(PAYCHECK);
        System.out.print("/week earning me a total of $");
        System.out.println(moneyTotal);
    }
}
