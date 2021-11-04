import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public ReadFile() {
        Scanner readFile = null;

        try {
            readFile = new Scanner(new File("ReadFile.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

}
