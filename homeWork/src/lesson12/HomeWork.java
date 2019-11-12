package lesson12;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;

public class HomeWork {

    private static List<String> strings;

    public static void main(String[] args) throws IOException {

        ClassLoader loader = MapLesson.class.getClassLoader();
        File file = new File(loader.getResource("lesson12/res/wp.txt").getFile());
        strings = Files.readAllLines(file.toPath());
        // wan("the");
        // second();
        thrd();
        // five();
    }

    private static void thrd() {
        HashMap<String, Integer> userHashMap = new HashMap<>();

        ValueComparator bvc = new ValueComparator(userHashMap);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);

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
        System.out.println(userHashMap);
        sorted_map.putAll(userHashMap);
        System.out.println(sorted_map);
    }

    static class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with
        // equals.
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }

    private static void five() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counter;
        int count = 0;
        counter = new int[26];
        float[] percent;
        percent = new float[26];
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            for (int i1 = 0; i1 < string.length(); i1++) {
                count++;
                for (int cnt = 0; cnt < 26; cnt++) {
                    if (string.charAt(i1) == alphabet.charAt(cnt)) {
                        counter[cnt]++;
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(counter));
        // System.out.println(count);

        for (int p = 0; p < 26; p++) {
            percent[p] = ((float) counter[p] / (float) count) * 100;
        }
        System.out.println(Arrays.toString(percent));
    }


    private static void second() {
        Integer ll = 0;
        HashMap<Integer, ArrayList<String>> groupsWords = new HashMap<>();
        for (int crt = 0; crt < 32; crt++) {
            groupsWords.put(crt, new ArrayList<>());
        }
        for (int i = 0; i < strings.size(); i++) {
            if (!strings.get(i).isEmpty()) {
                int length = 0;
                ArrayList<String> words = new ArrayList<>();
                words.addAll(Arrays.asList(strings.get(i).split("[()!?,.\\s\"\\\\]")));
                length = words.size();
                // System.out.println("Количество строк в строке: " + length);
                for (int i1 = 0; i1 < length; i1++) {
                    //  System.out.println("Количество слов в строке: " + words[i1].toString());
                    ll = words.get(i1).length();
                    String send = words.get(i1);
                    groupsWords.get(ll).add(send);
                }
            }
        }

        for (int out = 0; out < 29; out++) {
            System.out.println(groupsWords.get(out));
        }

    }


    private static void wan(String string) {
        System.out.println("Количество строк: " + strings.size());
        int cnt = 0;

        for (int i = 0; i < strings.size(); i++) {

            if (!strings.get(i).isEmpty()) {
                int length = 0;
                ArrayList<String> words = new ArrayList<>();
                words.addAll(Arrays.asList(strings.get(i).split("[!?,.\\s]")));
                length = words.size();
                // System.out.println("Количество строк в строке: " + length);
                for (int i1 = 0; i1 < length; i1++) {
                    //  System.out.println("Количество слов в строке: " + words[i1].toString());
                    if (words.get(i1).equalsIgnoreCase(string)) {
                        cnt++;
                    }
                }
            }


        }
        System.out.println(cnt);
    }
}

