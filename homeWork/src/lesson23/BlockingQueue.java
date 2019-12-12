package lesson23;

import java.util.Random;
import java.util.concurrent.*;

public class BlockingQueue {
    public static void main(String[] args) {

        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(23, true);
        //однонаправленная, есть те же методы, обязаны задать ёмкость. fair - справедливость.

        // new SynchronousQueue() - каждая операция добавления будет ждать операцию удаления

/*        new DelayQueue<>()
                получение элемента по таймауту*/

        //LinkedTransferQueue<> -TODO посмотреть что это такое, с чем едят, чем отличается от блокирующей очереди

        // LinkedBlockingQueue - однонаправленная
        LinkedBlockingDeque<Signal> signals = new LinkedBlockingDeque<>();
        //имеет свою очередь, ограничена максимальным размером integer
        new Thread(new WriteSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();

    }
}

class WriteSignals implements Runnable {
    LinkedBlockingDeque<Signal> signals;

    public WriteSignals(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Write " + Thread.currentThread().getState());
            try {
                Thread.sleep(5000);
                Signal signal = Signal.getSignal();
                System.out.println("Write Signal " + signal);
                signals.put(signal);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class ReadSignals implements Runnable {
    private LinkedBlockingDeque<Signal> signals;

    public ReadSignals(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Read " + Thread.currentThread().getState());
            try {
                System.out.println("Read Signal " + signals.take());
                //take() удаляет элемент из очереди и возвращает его
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}


class Signal {
    enum Priority {
        HIGH, MEDIUM, LOW;

        public static Priority getPriority(int ord) {
            for (Priority priority : values()) {
                if (ord == priority.ordinal()) {
                    return priority;
                }
            }
            throw new AssertionError("wrong ordinal");
        }
    }

    private Priority priority;
    private int code;

    @Override
    public String toString() {
        return "Signal{" +
                "priority=" + priority +
                ", code=" + code +
                '}';
    }

    public Priority getPriority() {
        return priority;
    }

    public int getCode() {
        return code;
    }

    public Signal(Priority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public static Signal getSignal() {
        Random random = new Random();
        return new Signal(Signal.Priority.getPriority(random.nextInt(Priority.values().length)), random.nextInt(30));

    }


}