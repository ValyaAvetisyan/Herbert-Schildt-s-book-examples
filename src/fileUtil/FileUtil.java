package fileUtil;

import java.io.*;


public class FileUtil {

    public static void main(String[] args) throws IOException {

        printLineByKeywordOnDir("src\\fileUtil", "cry");
        printLineByKeyword("src\\fileUtil\\file", "cry");
    }

    /**
     * This method is for searching word in the file of given path,
     * and will print the line of that keyword
     *
     * @param filePath is the path of file
     * @param keyword  is the given word which will be searched
     * @throws IOException is input output exception
     */
    public static void printLineByKeyword(String filePath, String keyword) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);

                }
            }
        }
    }


    /**
     * This method is for finding the line of given keyword,
     * but first will find the file on directory
     * @param dirPath is path of directory
     * @param keyword is the given word which will be searched
     * @throws IOException is input output exception
     */
    public static void printLineByKeywordOnDir(String dirPath, String keyword) throws IOException {
        File file = new File(dirPath);
        File[] list = file.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                printLineByKeywordOnDir(f.getAbsolutePath(), keyword);
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());

                try (BufferedReader reader = new BufferedReader(new FileReader(f.getAbsoluteFile()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(keyword)) {
                            System.out.println(line);
                        }
                    }
                    break;
                }
            }
        }
    }

}
