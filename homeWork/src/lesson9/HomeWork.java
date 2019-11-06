package lesson9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class HomeWork {
    public static void main(String[] args) {
       //wan();   // первое задание
        //second();



    }



    public static void second(){

        LocalDate now = LocalDate.now();
        LocalDate end = LocalDate.of(2020, Month.JANUARY, 20);
        long between = ChronoUnit.WEEKS.between(now, end);
        System.out.println((between*3)-4);  //количество недель * количество уроков в неделю - 4 праздника на новый год(есть метод получающий праздники?)

    }

    public static void wan(){

        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour>=7 && hour < 15){
            System.out.println("Первая смена");
        }else if (hour >= 15 && hour < 23) {
            System.out.println("Вторая смена");
        } else {
            System.out.println("Третья смена");
        }
    }
}
