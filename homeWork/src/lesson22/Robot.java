package lesson22;

public class Robot {
    //приоритеты:
    //10 - наивысший приоритет
    // 1 - самый низкий
    //setPriority - устанавилиает приоритет
    //getPriority - выдаёт приоритет
    //по умолчанию - 5


    volatile boolean currentLeg = true;

    class Leg implements Runnable {


        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg = leg;
        }

        public void step() {
            System.out.println(name);
        }

        @Override
        public void run() {
            while (true) {
                if (leg == currentLeg) {
                    step();
                    currentLeg = !leg;
                    Thread.yield();
                    // приостанавливает выполненеие потока, и пытается передать управление другому потоку.
                    //чтоб другой пток смог начать своё выполнение. Ставит текущий поток на паузу, чтоб передать
                    //управление другому потоку
                    //работает с приоритетами
                    // не передаст поток, если приоритет текущего потока самый высокий
                    //передаёт поток потоку с большим приоритетом
                }
            }
        }
    }

    Leg left = new Leg("Left", false);
    Leg right = new Leg("Right", true);

    public void startRun() {
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new Robot().startRun();
    }

}
