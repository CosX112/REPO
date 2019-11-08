package lesson11;


import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        wan();


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
                break;
            }
            last = words.get(i);
            if (i==10)  System.out.println("является");

        }

    }


}
