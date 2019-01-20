import java.io.File;
import java.util.Scanner;

public class TestMain {
    /**
     * Used sources; Stackoverflow.com Javadocumentation  geeksforgeeks
     */

    public static void main(String[] args) {

        Scanner inScanner = new Scanner(System.in);
        System.out.print("Enter file path : "
                +"\n" + "For Example : C:/Users/...    " + "\n--->" );
        String inFile = inScanner.next();
        System.out.println("You entered: " + inFile);

        File currentDir = new File(inFile); // current directory
        DisplayContent.displayDirectoryContents(currentDir);

    }


}
