import java.io.File;


/**
 * This Class counts the files within a folder
 * and gives an Integer back
 */

public class CountFiles {
    int folder;

    public CountFiles(int folder) {
        this.folder = folder;
    }

    public static int getFilesCount(File file) {
        File[] files = file.listFiles();
        int count = 0;
        for (File f : files)
            if (file.isFile() && file.isDirectory())
                count += getFilesCount(f);
            else
                count++;

        return count;
    }

}
