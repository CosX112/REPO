package lesson14.io;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

public class IOLesson {
    public static void main(String[] args) {
        //io пакет
        //nio пакет

        // InputStream
        //    OutputStream
        /*
         */
        File file = new File("io.txt");
        File file2 = new File("io2.txt");

file.exists(); //возвращет 0 или 1 в зависимости от наличия отсутвия файлов
     /*   file.isDirectory();  //директория ли это
        file.isFile();   // фаел ли это
        file.canRead(); // доступен ли для чтения
        file.canWrite(); // доступен ли для чтения
        file.createNewFile();  создаёт ноывй файл */
/*     file.listFiles();
     file.delete();
     file.getPath();
     file.lastModified();*/

        try {
            //   writeToFile(file, true);
            //    writeWithBuffer(file);
            writeReadData(file2);
            // readFromSeveralFiles(file, file2);
            //   readByteArray(file);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void writeToFile(File file, boolean append) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                sb.append("Line ").append(i).append("\n");
            }
            byte[] bytes = sb.toString().getBytes();
            fileOutputStream.write(bytes);
        }
    }

    public static String readByteArray(File file) throws IOException {
        String string = null;

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            System.out.println(fileInputStream.available());

            byte[] buf = new byte[8];
            int data;
            while ((data = fileInputStream.read(buf)) > 0) {
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
                outputStream.write(buf, 0, data);
            }
            string = new String(outputStream.toByteArray());
        }
        return string;
    }

    //Буферизированная запись
    public static void writeWithBuffer(File file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)) {
            for (int i = 0; i < 1_000_000; i++) {
                outputStream.write((i + " ").getBytes());

            }
        }
    }

    public static String readFromSeveralFiles(File... files) throws IOException {
        String string = null;

        try (FileInputStream input1 = new FileInputStream(files[0]);
             FileInputStream input2 = new FileInputStream(files[1]);
             ByteArrayOutputStream bout = new ByteArrayOutputStream();) {

          /*  Vector<InputStream> sequence = new Vector<>();
            InputStream stream1 = new FileInputStream("file1.txt");
            InputStream stream2 = new FileInputStream("file1.txt");
            InputStream stream3 = new FileInputStream("file1.txt");
            InputStream stream4 = new FileInputStream("file1.txt");
            SequenceInputStream sequenceInputStream = new SequenceInputStream(sequence.elements());*/


            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);

            byte[] buf = new byte[10];
            int data;
            while ((data = sequenceInputStream.read(buf)) > 0) {
                bout.write(buf, 0, data);
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
            }
        }
        return string;
    }

    public static void writeReadData(File file) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             DataOutputStream dataOutput = new DataOutputStream(fileOutputStream)) {
            dataOutput.writeDouble(4.6);
            dataOutput.writeFloat(5.9f);
            dataOutput.writeUTF("hello");
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(fileInputStream);) {

            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readUTF());

            // RandomAccessFile
            // позволяет открывать файлы в режиме чтения и записи
            // САМОСТОЯТЕЛЬНО. ЧИТАТЬ, ПЕСАТЬ, ДЕЙЛАЙ!!!
            //2 пишем свою InputStream OutputStream!!!!
            // на Filtered
            // шефруем XOR читаем расшефровывваем.
            //создаём фаел вручную, заполняем, пишем метод котоырй принимет файл, разбивает на 2 части. 1 часть в 1 файл,2 во второй.
            //принимает два фаела и делает один
        }
    }
}
