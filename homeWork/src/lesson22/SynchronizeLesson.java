package lesson22;

import java.util.ArrayList;
// для обращения к одной переменной несколькими потоками, чтоб исключить конфликты.
// блокирует метод, обращающийся к объекту
public class SynchronizeLesson {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new IncrementThread(counter));
        }
        for (IncrementThread thread: threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("counter = " + counter.counter);
    }




}

class Counter {
    public int counter = 0;
    public synchronized void increment(){
        counter++;
    }
}

class IncrementThread extends Thread{
    private Counter counter;
    public IncrementThread(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
 /*           synchronized (counter){
                counter.increment();
            }*/
                //два метода. оборачивать в синхронизацю либо блок кода, либо переменную
            counter.increment();
        }
    }
}