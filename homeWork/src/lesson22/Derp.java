package lesson22;

public class Derp {

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
                }
            }
        }
    }

    Leg left = new Leg("1", false);
    Leg right = new Leg("2", true);

    public void startRun() {
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new Robot().startRun();
    }

}
