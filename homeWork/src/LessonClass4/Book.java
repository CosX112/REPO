package LessonClass4;

public class Book {
    //свойства, поля, атрибуты
    // Названия книг
    private String title; // null по умолчанию для ссылочных типов
    // модификатор доступа private означает что доступ есть только внутри класса
    private String author;
    boolean isForHome;  //false по умолчанию
    boolean isAvailable;

    //конструкторы
    public Book() {
    }

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
    }

    public Book(String title, String author, boolean isAvailable, boolean isForHome) {
        setTitle(title);
        setAuthor(author);
        setAvailable(isAvailable);
        setForHome(isForHome);
    }

    // метод, устанавливающей значения свойств title и author
    public void setTitle(String title) {   //void - метод ничего не возвращает,
        //this. - это ссылка на текущий объект
        if (title != null && !"".equals(title)) {
            this.title = title;
            System.out.println("значение было установлено");
        } else {
            System.out.println("значение не было установлено");
        }
    }

    // alt + insert
    // методы, которые устанавливают значения свойств
    public void setAuthor(String author) {
        if (author != null && !"".equals(author)) {
            this.author = author;
            System.out.println("значение было установлено");
        } else {
            System.out.println("значение не было установлено");
        }

    }

    //будем создавать методы, которые возвращают значения свойств (геттеры)

    public String getTitle() {
        return title;   //метод возвращает значение, ретурн прекращает работу метода, и возвращает значение.
    }

    public String getAuthor() {
        return author;
    }

    public void setForHome(boolean forHome) {

        isForHome = forHome;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;

    }

    public boolean isForHome(boolean isForHome) {
        return isForHome;
    }

    public boolean isAvailable(boolean isAvailable) {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isForHome=" + isForHome +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
