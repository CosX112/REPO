package lesson25.task1;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Dock dock = new Dock();
        Dock dock1 = new Dock();
        Dock dock2 = new Dock();
        Dock dock3 = new Dock();
        Dock[] docks = {dock, dock1, dock2, dock3};
        for (int i = 0; i < 10; i++) {
            new Thread(new Boat(docks)).start();
        }
    }
}

class Boat implements Runnable {
    Dock[] docks;
    Boolean goods = true;

    public Boat(Dock[] docks) {
        this.docks = docks;
    }

    @Override
    public void run() {
        Dock dock;
        System.out.println("Корабль " + Thread.currentThread().getName() + " Приплыл");
        while (goods) {
            for (int i = 0; i < 4; i++) {
                dock = docks[i];
                if (dock.getSemaphore().tryAcquire() && goods) {
                    System.out.println("Корабль " + Thread.currentThread().getName() + " припарковался в док номер " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Корабль " + Thread.currentThread().getName() + " разгружен");
                    goods = false;
                    dock.getSemaphore().release();
                }
            }
        }
    }
}

