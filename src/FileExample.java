import java.io.*;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\ioExample");
        boolean exists = file.exists();
        if (exists) {
            System.out.println("exist");
        } else {
            System.out.println("don't exist");
            if (file.mkdir())
                System.out.println("created");
        }
        boolean directory = file.isDirectory();
        for (File file1 : file.listFiles()) {
            System.out.println(file1.getName() + "" + file1.length());
        }
//        FileInputStream in = null;
//        FileOutputStream out = null;
//
//        try {
//            in = new FileInputStream("text.txt");
//            out = new FileOutputStream("output.txt");
//
//            int c;
//            while ((c = in.read() ) != -1) {
//                out.write(c);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
//        }
//    }
        char c;
        BufferedReader br = new
                BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters, 'q' to quit.");
// read characters
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');

    }
}


