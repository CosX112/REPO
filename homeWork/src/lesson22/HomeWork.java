package lesson22;


import lesson12.MapLesson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;


public class HomeWork {


    public static void main(String[] args) throws IOException {
        new WPThreads().startRun();
    }
}


class WPThreads implements Runnable {
    private static List<String> strings;
    List<String> list;

    private Sum sum;

    public WPThreads(List<String> list) {
        this.list = list;
    }

    public WPThreads() {

    }


    public synchronized HashMap<String, Integer> thrd(List<String> strings) {


        HashMap<String, Integer> userHashMap = new HashMap<>();
      /*  lesson12.HomeWork.ValueComparator bvc = new lesson12.HomeWork.ValueComparator(userHashMap);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);*/

        for (int i = 0; i < strings.size(); i++) {
            if (!strings.get(i).isEmpty()) {
                int length = 0;
                ArrayList<String> words = new ArrayList<>();
                words.addAll(Arrays.asList(strings.get(i).split("[!?,.\\s]")));
                length = words.size();
                // System.out.println("Количество строк в строке: " + length);
                for (int i1 = 0; i1 < length; i1++) {
                    //  System.out.println("Количество слов в строке: " + words[i1].toString());
                    if (!userHashMap.containsKey(words.get(i1))) {
                        userHashMap.put(words.get(i1), 1);
                    } else {
                        int tmp = userHashMap.get(words.get(i1)) + 1;
                        userHashMap.put(words.get(i1), tmp);

                    }
                }
            }

        }
        //  System.out.println(userHashMap);
        return userHashMap;
             /*  sorted_map.putAll(userHashMap);
        System.out.println(sorted_map);*/
    }


    public void startRun() throws IOException {
        ClassLoader loader = MapLesson.class.getClassLoader();
        File file = new File(loader.getResource("lesson22/res/wp.txt").getFile());

        strings = Files.readAllLines(file.toPath());
        System.out.println(strings.size()); //67039
        //33519
        //33520
        List<String> strings1 = strings.subList(0, 33519);
        List<String> strings2 = strings.subList(33520, 67039);
        // HashMap<String, Integer> derp = wpThreads.thrd(strings1);
        // System.out.println(derp);
        WPThreads wan = new WPThreads(strings1);
        WPThreads second = new WPThreads(strings2);
        new Thread(wan).start();
        new Thread(second).start();


    }


    @Override
    public void run() {
        HashMap<String, Integer> derp = thrd(list);
        System.out.println(derp);
               // sum.sum(derp);
    }
}


class Sum {
    HashMap<String, Integer> summ = new HashMap<>();

    public synchronized void sum(HashMap<String, Integer> derp) {
        summ.putAll(derp);
        System.out.println(summ);
        //HashMap<String, Integer> derp = new HashMap<>();

    }
}