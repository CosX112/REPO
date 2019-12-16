package lesson17;

import lesson12.MapLesson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WPStream {
    public static void main(String[] args) throws IOException {

        ClassLoader loader = MapLesson.class.getClassLoader();
        File file = new File(loader.getResource("lesson12/res/wp.txt").getFile());
     //   strings = Files.readAllLines(file.toPath());


        Map<String, Long> map = Files.lines(file.toPath())
                .parallel()
                .map(line -> line.replaceAll("\\p{Punct}"," ").toLowerCase())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .parallelStream()
                .sorted((entry1 , entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));



        System.out.println(map);

    }
}
