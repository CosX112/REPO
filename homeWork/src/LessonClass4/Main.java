package LessonClass4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book java = new Book();    //'тип данных книга, джава название, конструктор'
        Book cleanCode = new Book();

        // java.title = "Философия Java";
        // cleanCode.title = "Чистый код";

        // java.autor = "Брюс Эккель";
        // cleanCode.autor = "Роберт Мартин";

        java.setTitle("Философия Java");
        java.setAuthor("Брюс Эккель");
        cleanCode.setTitle("Чистый код");
        cleanCode.setAuthor("Роберт Мартин");
        java.setAvailable(true);
        java.setForHome(true);
        cleanCode.setForHome(true);
        cleanCode.setAvailable(true);
        Book forBegginers = new Book("Руководство для начинающих", "Герберт Шилдт");
        Book derp = new Book("1", "2",false, false);


   //     System.out.println(java.getTitle());       //у объекта java, вызывыаем метод getTitle, и метод getTitle вернёт title объекта java
    //    System.out.println(cleanCode.getTitle());  //
     //   System.out.println(java.isForHome);
      //  System.out.println(java.isAvailable);
     //   System.out.println(java);
     //   System.out.println(cleanCode);
     //   System.out.println(forBegginers);

        Library library = new Library();
        library.addBook(java);
        library.addBook(cleanCode, forBegginers);
     //   System.out.println(library.getBooks(java));
        System.out.println(Arrays.toString(library.getBooks()));
        System.out.println(library.getInfo("Чистый код"));
        System.out.println(library.takeHome("Чистый код"));
        System.out.println(library.getInfo("Чистый код"));



    }
}
