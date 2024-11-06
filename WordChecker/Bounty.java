import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Bounty {
    public static void main(String[] args) {
        try {
            File myObj = new File("/Users/Derek/Desktop/BTHS Repos/AP CSA/WordChecker/WordChecker.txt");
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                WordChecker check = new WordChecker();
                check.listAdd(data.split("[ ]")[0]);
                check.listAdd(data.split("[ ]")[1]);
                if (check.isWordChain()) {
                    count++;
                }
            }
            myReader.close();
            System.out.println(count + " word chains");
        }
        catch (FileNotFoundException e) {
        System.out.println("File was not found.");
        e.printStackTrace();
    }
    }
}
