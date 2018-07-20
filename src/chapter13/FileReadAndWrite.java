package chapter13;

import java.io.*;

public class FileReadAndWrite {
    private static final String FILE_PATH = "C:\\Users\\KarenGasparyan\\IdeaProjects\\Homework2\\src\\fileExample\\ioExamples\\file\\example.txt";

    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    public static void read() {

        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(FILE_PATH));
            System.out.println(inputStream.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void write() throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_PATH));
            bw.write("Hello From JAVA");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
    }
