public class Thread {
    private int length;
    private String color;

    public Thread (int len, String col) {
        length = len;
        color = col;
    }
    
    public int getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }
}