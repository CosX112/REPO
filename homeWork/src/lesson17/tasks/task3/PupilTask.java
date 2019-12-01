package lesson17.tasks.task3;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {


    public static void main(String[] args) {

        Pupil pupil1 = new Pupil(1, "Elon", Pupil.Gender.MALE, LocalDate.of(1980, Month.OCTOBER, 20));
        Pupil pupil2 = new Pupil(2, "Greta", Pupil.Gender.FEMALE, LocalDate.of(2010, Month.DECEMBER, 11));
        Pupil pupil3 = new Pupil(3, "Bill", Pupil.Gender.MALE, LocalDate.of(1970, Month.APRIL, 1));
        Pupil pupil4 = new Pupil(4, "Elon", Pupil.Gender.MALE, LocalDate.of(2000, Month.FEBRUARY, 20));
        Pupil pupil5 = new Pupil(5, "Elizabeth", Pupil.Gender.FEMALE, LocalDate.of(2000, Month.MARCH, 8));

        Stream<Pupil> pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        Map<Pupil.Gender, ArrayList<Pupil>> wan = pupilStream.collect(Collectors
                .groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(wan);

        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        OptionalDouble average = pupilStream.map(Pupil::getBirth).mapToLong(i -> ChronoUnit.YEARS.between(i, LocalDate.now())).average();
        System.out.println("Средний возраст " + average.getAsDouble());

        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        OptionalLong min = pupilStream.map(Pupil::getBirth).mapToLong(i -> ChronoUnit.YEARS.between(i, LocalDate.now())).min();
        System.out.println("Минимальный возраст " + min.getAsLong());

        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        OptionalLong max = pupilStream.map(Pupil::getBirth).mapToLong(i -> ChronoUnit.YEARS.between(i, LocalDate.now())).max();
        System.out.println("Максимальный возраст " + max.getAsLong());

        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        Map<Integer, ArrayList<Pupil>> five = pupilStream.collect(Collectors
                .groupingBy((pupil -> pupil.getBirth().getYear()), Collectors.toCollection(ArrayList::new)));
        System.out.println(five);


        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        pupilStream.parallel()
                .collect(Collectors.groupingBy(Pupil::getName, Collectors.counting()))
                .entrySet()
                .parallelStream()
                .filter(stringLongEntry -> stringLongEntry.getValue() < 2)
                .forEach(System.out::println);
// хз как сделать имеенно имя и дату рождения. Счётчик работает с именами - теряю дату, делаю сет с объектами - не работает счётчик


        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        List<Pupil> pups = pupilStream
                .sorted(Comparator.comparing(Pupil::getGender))
                .sorted(Comparator.comparing(Pupil::getBirth))
                .sorted(Comparator.comparing(Pupil::getName, Collections.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(pups);



        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        int n = 40;
        int m = 100;
        System.out.println("Возраст от " + n + " до " + m);
        pupilStream
                .filter(pupil -> ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now()) > n )
                .filter(pupil -> ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now()) < m )
                .forEach(System.out::println);

        pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        String someName = "Elon";
        List<Pupil> someNameSearcher = pupilStream
                .filter(pupil -> pupil.getName().equals(someName))
                .collect(Collectors.toList());
        System.out.println(someNameSearcher);


 /*       pupilStream = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5);
        int i;
        Map<Pupil.Gender, Integer> pupilsGender = pupilStream
                .parallel()
                .collect(Collectors.groupingBy(Pupil::getGender, Pupil::getBirth))

        System.out.println(pupilsGender);
*/

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        // 2. Найти средний возраст учеников

        // 3. Найти самого младшего ученика

        // 4. Найти самого старшего ученика

        // 5. Собрать учеников в группы по году рождения

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        // 8. Вывести в косоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}
