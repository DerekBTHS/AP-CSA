public class Main {
    public static void main(String[] args) {
        String NAME = "Derek Chen";
        boolean LIKESPENGUINS = true;
        double PAYCHECK = 338.36;
        int WEEKS = 6;
        double moneyTotal = PAYCHECK * WEEKS;
        String intro = "My name is " + NAME + ".\nThe statement I like penguins is: " + LIKESPENGUINS + "\nThis summer I worked " + WEEKS + " earning $" + PAYCHECK + "/week earning me a total of $" + moneyTotal;
        System.out.println(intro);
    }
}
