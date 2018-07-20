package taskManagement;

import java.io.File;
import java.io.IOException;


public class FilePrinter {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        printFileNamesFromFolder("src\\fileUtil");
    }

    /**
     * This method is for printing names of files of folder
     * @param path is the location that folder is situated
     */
    private static void printFileNamesFromFolder(String path) {
        File file = new File(path);
        File[] list = file.listFiles();

        if (list == null)  return;
            for (File f : list) {
                if (f.isDirectory()) {
                    printFileNamesFromFolder(f.getAbsolutePath());
                    System.out.println("Dir:" + f.getAbsoluteFile());
                } else {
                    System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }
}
