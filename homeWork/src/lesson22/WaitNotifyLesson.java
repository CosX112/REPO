package lesson22;

public class WaitNotifyLesson {
    public static void main(String[] args) {
        BookStorage storage = new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();

    }
}

class BookStorage {
    int bookCount = 0;

    public synchronized void putBook() throws InterruptedException {
        //увеличивает счётчик на 1
        System.out.println("putBook - начало выполнения");
        while (bookCount >= 5) {
            wait();  //переводит поток в режим ожидания, пока не разбудит notify
            System.out.println("putBook в состоянии ожидания");
        }
        bookCount++;
        System.out.println("putBook - добавил 1 книгу " + bookCount);
        System.out.println("putBook - завершение выполнения");

    }

    public synchronized void getBook() throws InterruptedException {
        //уменьшает счётчик на 1
        while (bookCount < 1) {
            wait();
            System.out.println("getBook в состоянии ожидания");
        }
        bookCount--;
        System.out.println("getBook - убавил 1 книгу, осталось " + bookCount);
        System.out.println("getBook - завершение выполнения");
        notify();
        //метод notify - будит случайный поток
        // метод notifyAll(); - будит все потоки

    }
}

class PutThread implements Runnable {
    BookStorage bookStorage;

    public PutThread(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                bookStorage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread implements Runnable {
    BookStorage bookStorage;

    public GetThread(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                bookStorage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}