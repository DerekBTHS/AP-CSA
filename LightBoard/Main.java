public class Main {
    public static void main(String[] args) {
        LightBoard sim = new LightBoard(7, 5);
        sim.showBoard();
        System.out.println(sim.evaluateLight(0, 3));
        System.out.println(sim.evaluateLight(6, 0));
        System.out.println(sim.evaluateLight(4, 1));
        System.out.println(sim.evaluateLight(5, 4));
    }
}
