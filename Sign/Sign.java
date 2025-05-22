import java.lang.Math;

public class Sign {

    private String message;
    private int width;

    public Sign(String msg, int w) {
        message = msg;
        width = w;
    }
    
    public int numberOfLines() {
        if (message.equals("")) {
            return 0;
        } else if (message.length() == width) {
            return 1;
        } else {
            return (int) Math.ceil(message.length() / (double) width);
        }
    }

    public String getLines() {
        String output = "";
        if (message.length() == 0) {
            return null;
        }
        for (int i = 1; i < message.length() + 1; i++) {
            output += message.charAt(i - 1);
            if (i % width == 0 && i != message.length()) {
                output += ';';
            }
        }
        return output;
    }
}
