import java.io.File;

/**
 * Scans directory recursively and Displays the Content
 * Calculates Size and Compression rate for specific files
 */

public class DisplayContent {

    public static void displayDirectoryContents(File dir) {
        // try {
        File[] files = dir.listFiles();
        for (File file : files) {
            //Check if it's Directory
            if (file.isDirectory()) {
                //if its True get Path
                //Create an instance of CountFiles
                long size = CountFiles.getFilesCount(file);
                System.out.println("\n\n"+"directory:" + file.getPath()
                        + "\t" + "--->"
                        + size
                        + " files in a Folder "  );
                //As long its Directory make recursive Call
                displayDirectoryContents(file);
            } else {
                //Check: File ? file.isFile() is also possible
                if (file.getName().contains(".")) {

                    // Create an instance of PictureInfo
                    PictureInfo info = new PictureInfo(file);
                    int type = info.getFileType(file);

                    // Switch Types: GIF, JPEG, DIRECTORY
                    switch (type) {
                        case Constants.DIRECTORY:

                        case Constants.GIF_PICTURE:
                            long gifLength = info.getFileSize(file);
                            int[] gifSize = info.getGIFSize(file);
                            if (gifSize != null) {
                                System.out.println("name: " + file.getName() + ", type: GIF-image");
                                System.out.println("  length:      " + gifLength);
                                System.out.println("  size:        " + gifSize[0] + " x " + gifSize[1]);
                                System.out.println("  compression: " + (gifLength * 100 / (gifSize[0] * gifSize[1])) + "%");
                            }
                            break;
                        case Constants.JPEG_PICTURE:
                            long jpegLength = info.getFileSize(file);
                            java.awt.Dimension jpegSize = info.getJPEGSize(file);
                            if (jpegSize != null) {
                                System.out.println("name: " + file.getName() + ", type: JPEG-image");
                                System.out.println("  length:      " + jpegLength);
                                System.out.println("  size:        " + jpegSize.width + " x " + jpegSize.height);
                                System.out.println("  compression: " + (jpegLength * 100 / (jpegSize.width * jpegSize.height * 3)) + "%");
                            }
                            break;
                        default:
                            System.out.println("name: " + file.getName() + ", type: unknown");
                            break;
                    }

                    System.out.println("\n" + "******************************************" + "\n");
                }

            }
        }

    }
}