package lesson11;


import java.util.*;

public class HomeWork {


    private static LinkedList<Integer> intsDivBy3 = new LinkedList<>();
    private static LinkedList<Integer> intsDivBy2 = new LinkedList<>();
    private static LinkedList<Integer> intsOth = new LinkedList<>();


    public static void main(String[] args) {
        wan();
        second();
        printList();
    }


    private static void second() {
        LinkedList<Integer> ints = new LinkedList<>();


        for (int i = 0; i < 20; i++) {
            Scanner in = new Scanner(System.in);
            Integer scan = Integer.parseInt(in.nextLine());
            ints.add(scan);
        }
        System.out.println(ints);

        for (int i = 0; i < 20; i++) {
            int tmp = ints.get(i);
            int Div3 = tmp % 3;
            int Div2 = tmp % 2;
            if (Div3 == 0) {
                intsDivBy3.add(tmp);
                if (Div2 == 0) intsDivBy2.add(tmp);
            } else if (Div2 == 0) {
                intsDivBy2.add(tmp);
            } else {
                intsOth.add(tmp);
            }

        }
    }

    private static void printList() {
        System.out.println(intsDivBy3);
        System.out.println(intsDivBy2);
        System.out.println(intsOth);
    }

    private static void printList(String string) {
        if (string.equals("intsDivBy3")) {
            System.out.println(intsDivBy3);
        } else if (string.equals("intsDivBy2")) {
            System.out.println(intsDivBy2);
        } else if (string.equals("intsOth")) {
            System.out.println(intsOth);
        } else System.out.println("Неправильное название списка");


    }


    public static void wan() {


        LinkedList<String> words = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            Scanner in = new Scanner(System.in);
            String scan = in.nextLine();
            words.add(scan);

        }
        System.out.println(words);
        String word = "";
        String last = "";

        for (int i = 0; i < 10; i++) {
            word = words.get(i);
            if (word.length() >= last.length()) {
                System.out.println("не является");
                System.out.println(word);
            }
            last = words.get(i);
        }

    }


}
