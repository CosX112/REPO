package lesson25.task1;

import java.util.concurrent.Semaphore;

public class Dock {
   Semaphore semaphore = new Semaphore(1);

    public synchronized Semaphore getSemaphore() {
        return semaphore;
    }

}
