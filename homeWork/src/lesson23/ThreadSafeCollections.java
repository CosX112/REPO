package lesson23;


// bизначально потокобезопасными являются
//vector
//HashTable
//Stack


import java.util.*;
import java.util.concurrent.*;


public class ThreadSafeCollections {


    public static void main(String[] args) {
        //однопоточные коллекции и мапы в потокобезопсные коллекции можно привести
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        //потокобезопасные коллекции и мапы из пакета java.util.concurrent.*
        CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();
        books.addIfAbsent(new Book("Java", 1800));
        books.addIfAbsent(new Book("Java", 1800));
        //добавляет элемент, если такой элемент отсутсвует в списке
        //Тоже самое что и обычный, только создаёт копии. Копии потом соединяет
        System.out.println(books);
        new Thread(new WriteThread(books)).start();
        new Thread(new ReadThread(books)).start();

        CopyOnWriteArraySet<String> strings = new CopyOnWriteArraySet<>();
        strings.add("qwe");
        strings.add("asd");
        strings.add("zxc");
        strings.add("asd1");

        strings.removeIf(s -> s.length() > 3);
        System.out.println(strings);
                //removeif удаляет по условию в предикате
                //ConcurrentSkipListSet
//мапа, хранящая в порядке, как treeMap
        ConcurrentNavigableMap<String, Integer> navigableMap = new ConcurrentSkipListMap<>();
        navigableMap.put("qew", 2);
        navigableMap.putIfAbsent("qew", 2);
      //  navigableMap.computeIfPresent();
        //для проверки наличия по ключу
      //  navigableMap.computeIfAbsent();
        //для проверки значения на null по ключу

    }
}

class WriteThread implements Runnable {
    CopyOnWriteArrayList<Book> books;

    public WriteThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            books.addIfAbsent(Book.getBook());
        }
    }
}


class ReadThread implements Runnable {
    CopyOnWriteArrayList<Book> books;

    public ReadThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Введите название книги");
            String title = scanner.nextLine();
            for (Book book : books) {
                if (title.equals(book.getTitile())) {
                    System.out.println(book);
                    books.remove(book);
                }
            }
        }
    }
}

class Book {
    private String titile;
    private int pageCounter;

    @Override
    public String toString() {
        return "Book{" +
                "titile='" + titile + '\'' +
                ", pageCounter=" + pageCounter +
                '}';
    }

    public Book(String titile, int pageCounter) {
        this.titile = titile;
        this.pageCounter = pageCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getPageCounter() == book.getPageCounter() &&
                Objects.equals(getTitile(), book.getTitile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitile(), getPageCounter());
    }

    public String getTitile() {
        return titile;
    }

    public int getPageCounter() {
        return pageCounter;
    }

    public static Book getBook() {
        Random random = new Random();
        String[] titles = {"Алфавит", "Фелософия Жавы", "Обломоф", "Война и Мир"};
        return new Book(titles[random.nextInt(titles.length - 1)], random.nextInt(2000));  //до 2к страниц
    }

}