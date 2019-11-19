package lesson14.io;

import java.io.*;
import java.util.Arrays;

public class homeWork {
    public static void main(String[] args) {
        File file = new File("HM.txt");
        File file1 = new File("HM1.txt");
        File file2 = new File("HM2.txt");


        try {
            splitFile(file, file1, file2);
            // wan();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void wan() throws IOException {
    }


    public static void splitFile(File file, File file1, File file2) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream(file1);
             FileOutputStream fileOutputStream1 = new FileOutputStream(file2);) {

            int size = (((int) file.length()) / 2) / 8;

            System.out.println(size);
            byte[] buf = new byte[8];
            int data;
            int i = 0;
            while ((data = fileInputStream.read(buf)) > 0) {
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
                if (i <= size) {
                    fileOutputStream.write(buf, 0, data);
                } else {
                    fileOutputStream1.write(buf, 0, data);
                }
                i++;
            }

        }
    }
}