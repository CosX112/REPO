package lesson22;
//это называется дедлок
//один synchronize блокирует второй, и они ждут друг друга.
//избегать таких ситуаций
public class Threads {
    public Threads(WPThreads wan) {
    }

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(()->{
            System.out.println("thread1 run");
            synchronized (object1) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 sync object 1");
                synchronized (object2) {
                    System.out.println("thread1 sync object 2");
                }
            }
        });
        Thread thread2 = new Thread(()->{
            System.out.println("thread2 run");
            synchronized (object2) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 sync object 2");
                synchronized (object1) {
                    System.out.println("thread2 sync object 1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
