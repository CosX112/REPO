package lesson9;

import Farm.Animals.Home.Cat;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeApi {
    public static void main(String[] args) {
        //DateTime Api начиная с 8 версии
        //
        //позволяет работать с датой
        //текущая дата
        // 9 -d 09 -dd / MMMM - месяц (октябрь) MM - месяц (10) /
        // yyyy - 2017 / yy - 17
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);
        LocalDate someDate = LocalDate.of(2019, Month.OCTOBER, 20);

        String strDate = "14/05/2017";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate parseDate = LocalDate.parse(strDate, dtf);

        System.out.println(parseDate.minusYears(1));
        System.out.println(parseDate.minusMonths(2));
        System.out.println(parseDate.minusDays(23));

        System.out.println(parseDate.plusDays(23));
        System.out.println(parseDate.plusWeeks(2));
        System.out.println(parseDate.plusMonths(7));
        System.out.println(parseDate.plusYears(4));

        DayOfWeek dayOfWeek = parseDate.getDayOfWeek();
        System.out.println(dayOfWeek);

        boolean isAfter = parseDate.isAfter(dateNow);
        System.out.println(isAfter);

        boolean isBefore = parseDate.isBefore(dateNow);
        System.out.println(isBefore);

        List<LocalDate> dates = dateNow.datesUntil(LocalDate.parse("2020-03-01")).collect(Collectors.toList());

        for (LocalDate date : dates) {
            System.out.println(date);
        }
        long between = ChronoUnit.MONTHS.between(parseDate, dateNow);
        System.out.println(between);

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalTime localTime1 = LocalTime.of(7, 20);
        LocalTime localTime2 = LocalTime.of(22, 20);

        long btn1 = ChronoUnit.HOURS.between(localTime1, localTime2);
        System.out.println(btn1);

        long btn2 = Duration.between(localTime1, localTime2).toMinutes();
        System.out.println(btn2);

        //   Set<String> alZone = ZoneId.getAvailableZoneIds();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy / HH:mm");

        System.out.println(formatter);

        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.NOVEMBER, 15, 16, 23);
        System.out.println();

        ZonedDateTime msk = localDateTime.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println(msk);

        ZonedDateTime ny = localDateTime.atZone(ZoneId.of("America/New_York")).plusHours(4);
        System.out.println(ny);

        Set<String> alZone = ZoneId.getAvailableZoneIds();
        System.out.println(alZone);
        LocalDateTime sydney = LocalDateTime.of(2019, Month.DECEMBER, 31, 19, 0);
        LocalDateTime chickLocal = sydney.plusHours(15).plusMinutes(35).plusHours(1).plusMinutes(45);
        ZonedDateTime chick = chickLocal.atZone(ZoneId.of("America/Chicago"));
        LocalDateTime washLocal = chickLocal.plusHours(2 + 1).plusMinutes(49 + 6);
        ZonedDateTime wash = washLocal.atZone(ZoneId.of("America/New_York"));
        LocalDateTime canLocal = washLocal.plusHours(1).plusMinutes(39);
        ZonedDateTime can = canLocal.atZone(ZoneId.of("America/Toronto"));
ZonedDateTime canZone = wash.plusHours(1).plusMinutes(39).withZoneSameInstant(ZoneId.of("America/Toronto"));
        LocalDateTime derp = LocalDateTime.of(2019, 12, 31, 23, 59);

        long derp1 = ChronoUnit.MINUTES.between(derp, canLocal);
        LocalDateTime sydneyNY = sydney.minusMinutes(derp1);

        System.out.println(formatter.format(canZone));
        System.out.println(formatter.format(can));
        System.out.println(derp1);
        System.out.println(sydneyNY);


//ZonedDateTime

// непотокобезопасны
        Date date = new Date();
        System.out.println(date);
        Date other = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("День: dd Месяц: MM Год: yyyy вв HH:mm");
        System.out.println(sdf.format(date));
        System.out.println(date.before(other));
        System.out.println(date.after(other));
        System.out.println(date.compareTo(other));
        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = new GregorianCalendar(2016,Calendar.OCTOBER, 12,15,30);
        calendar1.add(Calendar.DAY_OF_MONTH,4);
        calendar1.add(Calendar.DAY_OF_MONTH,-90);
        System.out.println(calendar1.get(Calendar.ERA));
        System.out.println(calendar1.getTime());
        calendar1.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // TODO: обратно

        //

    }
}
