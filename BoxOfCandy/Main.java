public class Main {
    public static void main(String[] args) {
        Candy[][] box = new Candy[4][3];
        box[0][1] = new Candy("lime");
        box[1][1] = new Candy("orange");
        box[2][2] = new Candy("cherry");
        box[3][1] = new Candy("lemon");
        box[3][2] = new Candy("grape");
        BoxOfCandy box1 = new BoxOfCandy(box);
        box1.showBox();
        System.out.println(box1.moveCandyToFirstRow(0));
        box1.showBox();
        System.out.println();
        BoxOfCandy box2 = new BoxOfCandy(box);
        box2.showBox();
        System.out.println(box2.moveCandyToFirstRow(1));
        box2.showBox();
        System.out.println();
        BoxOfCandy box3 = new BoxOfCandy(box);
        box3.showBox();
        System.out.println(box3.moveCandyToFirstRow(2));
        box3.showBox();
        System.out.println();
        
        box = new Candy[3][5];
        box[0][0] = new Candy("lime");
        box[0][1] = new Candy("lime");
        box[0][3] = new Candy("lemon");
        box[1][0] = new Candy("orange");
        box[1][3] = new Candy("lime");
        box[1][4] = new Candy("lime");
        box[2][0] = new Candy("cherry");
        box[2][2] = new Candy("lemon");
        box[2][4] = new Candy("orange");
        BoxOfCandy box4 = new BoxOfCandy(box);
        box4.showBox();
        System.out.println();
        Candy removed;
        removed = box4.removeNextByFlavor("cherry");
        box4.showBox();
        System.out.println(removed);
        if (removed != null) {
            System.out.println(removed.getFlavor());
        }
        System.out.println();
        removed = box4.removeNextByFlavor("lime");
        box4.showBox();
        System.out.println(removed);
        if (removed != null) {
            System.out.println(removed.getFlavor());
        }
        System.out.println();
        removed = box4.removeNextByFlavor("grape");
        box4.showBox();
        System.out.println(removed);
        if (removed != null) {
            System.out.println(removed.getFlavor());
        }
        System.out.println();
    }
}