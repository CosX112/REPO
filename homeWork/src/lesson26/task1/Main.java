package lesson26.task1;


import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        boolean work = true;
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите команду");
        while (work) {
            String user = in.nextLine();
            if (user.equals("time")) {
                fixedPool.execute(new time());
            } else if (user.equals("help")) {
                fixedPool.execute(new help());
            } else if (user.equals("getFromFile")) {
                fixedPool.execute(new getFromFile());
            } else if (user.equals("exit")) {
                work = false;
                fixedPool.shutdown();
            }
        }
    }
}

class time implements Runnable {
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Date: " + LocalDateTime.now());
    }
}

class help implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("для вывода времени введите time");
        System.out.println("для вывода файла введите getFromFile");

    }
}

class getFromFile implements Runnable {
    @Override
    public void run() {

        ClassLoader loader = Main.class.getClassLoader();
        File file = new File(loader.getResource("lesson12/res/wp.txt").getFile());
        System.out.println(file.toString());
    }
}