import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welome to my calculator!");
        System.out.println("Enter your first number.");
        Scanner s = new Scanner(System.in);
        double first = s.nextDouble();
        System.out.println("What operation would you like to do? ( + - * / % ^ )");
        String operation = s.next();
        System.out.println("Enter your second number.");
        double second = s.nextDouble();
        if(operation.equals("+")) {
            System.out.println("Answer: " + (first + second));
        } else if (operation.equals("-")){
            System.out.println("Answer: " + (first - second));
        } else if (operation.equals("*")){
            System.out.println("Answer: " + (first * second));
        } else if (operation.equals("/")) {
            if (second == 0) {
                System.out.println("Divide by 0 error");
            } else {
                System.out.println("Answer: " + (first / second));
            }
        } else if (operation.equals("%")){
            System.out.println("Answer: " + (first % second));
        } else if (operation.equals("^")){
            System.out.println("Answer: " + (Math.pow(first, second)));
        } else {
            System.out.println("Invalid operation");
        }
        s.close();
    }
}