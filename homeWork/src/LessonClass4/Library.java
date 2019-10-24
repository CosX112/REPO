package LessonClass4;

public class Library {
    private Book[] books = new Book[10];

    //в библиотеку можно добавить одну книгу
    public void addBook(Book newBook) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = newBook;
                break; //return;
            }
        }
    }

    // и несколько книг тоже(здесь выполняется перегрузка методов)
    public void addBook(Book... newBooks) {
        for (int i1 = 0; i1 < newBooks.length; i1++) {
            for (int i = 0; i < this.books.length; i++) {
                if (this.books[i] == null) {
                    this.books[i] = newBooks[i1];
                    break; //return;
                }

            }
        }
    }
//возможнсть получить инфу о книге по названию. еслт нету выдать нету книги.
    /*
     * "книга найдена, название : . автор:  " + "доступна в читальном зале /для выдачи, для выдачи доступна/недоступна*/

    public String getInfo(String title) {
        int i = 0;
        String a;
        String b;

        while (true) {
            if (this.books[i] == null || i >= (books.length)) {
                return "Книга не найдена";
            } else {

                if (title.equals(this.books[i].getTitle())) {
                    if (this.books[i].isAvailable) {
                        a = ". Для выдачи доступна";
                    } else {
                        a = ". Для выдачи не доступна";
                    }
                    if (this.books[i].isForHome) {
                        b = ". Для выдачи на дом";
                    } else {
                        b = ". Для чтения в зале";
                    }
                    return ("Книга найдена. Название: " + this.books[i].getTitle() +
                            ". Автор: " + this.books[i].getAuthor() + a + b);

                }
            }
            i++;
        }


    }


    public Book takeHome(String title) {
        int i = 0;
        //    Book returnBook = null;
        while (true){
        if (this.books[i] == null || i >= (books.length)) {
            return null;
        } else {

            if (title.equals(this.books[i].getTitle())) {
                if (this.books[i].isAvailable && this.books[i].isForHome) {
                    this.books[i].setAvailable(false);
                    return books[i];
                } else {
                    return null;
                }

            }
        }
        i++;

    }}

    //в    этом промеждутке проверяем есть ли книга, если нету null, если есть, но забрали, null, если незя взять, null
    //если можно взять и она есть, поменять флаг доступна на false


    public Book[] getBooks() {  //возвращает весь массив с книгами
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
