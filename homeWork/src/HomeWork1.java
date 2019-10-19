import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork1 {


    public static void decToBin() {    // второе задание
        System.out.println("Введите число в десятеричной системе счисления");
        Scanner in = new Scanner(System.in);
        int dec = in.nextInt(); //вводим число
        int bin[]; // объявляет массив для хранения результата
        int bit = 5; // объявляем количество бит
        bin = new int[bit];  //создаём массив на bit количество бит
        int i = bit - 1;  // количество иттераций будет на 1 меньше

        while (dec > 0) {
            bin[i] = dec % 2;  //провеяем остаток от деления на два
            dec = dec / 2;    //делим на два
            i--;              // двигаемся налево по массиву


        }
        System.out.println("Введёное число в бинарной системе счисления");
        System.out.println(Arrays.toString(bin)); // выводим результат

    }


    public static void decToHex() {   //третье задание
        System.out.println("Введите число в десятеричной системе счисления");
        Scanner in = new Scanner(System.in);
        int dec = in.nextInt();
        //  int hex[];
        int hex;
        int digit = 5;
        //hex = new int[bit];

        int i = digit - 1;
        int temp;
        String out[];
        out = new String[digit];

        String[] alphabet = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G"};

        while (dec > 0) {
            hex = dec % 16;
            dec = dec / 16;
            out[i] = alphabet[hex];
            i--;
        }

        System.out.println("Введёное число в шестнадцатеричной системе счисления");
        System.out.println(Arrays.toString(out));

    }


    public static void nod() {     //первое задание

        Scanner in = new Scanner(System.in);
        System.out.println("введите первое число");
        int first = in.nextInt();
        System.out.println("введите второе число");
        int second = in.nextInt();
        if (first > second) {    //как я понял первое должно быть больше, поэтому проверяем
            int b = second;

            for (int a = first; b > 0; ) {
                if (a % b == 0) {
                    System.out.printf("Наибольший общий делитель равен %d\n", b);

                }

                b = a % b;

            }
        } else {
            int b = first;

            for (int a = second; b > 0; ) {   //исправляем за пользователем, если он ошибся
                if (a % b == 0) {
                    System.out.printf("Наибольший общий делитель равен %d\n", b);
                }

                b = a % b;

            }
        }


    }

    public static void seven() { // четвёртое задание

        /*Дан массив целых чисел. Массив не отсортирован, числа могут повторятся. Необходимо найти в этом массиве такие 2 числа m и n
        чтобы их сумма была равна 7. Наиболее оптимальным способом.
        * */
        int[] array = {10, 8, -5, 1, 17, 12, 15, 7}; //заданный массив
        int temp;                            //временная переменная для хранения козла, капусты, и прочего
        boolean founded = false;                     //бит выполнения задачи
        // int i1 = 0;
        for (int i1 = 0; i1 < array.length; i1++)

            for (int i = 0; i < array.length; i++) {
                temp = array[i1];

                if (temp + array[i] == 7) {
                    System.out.printf("Первая пара чисел m и n, полученных из массива методом перебора: %d", temp);
                    System.out.printf(", %d\n", array[i]);
                    founded = true;     // если убрать зто - найдет все пары
                    break;
                }
                if (founded) {
                    break;
                }
            }

    }


    public static void main(String[] args) {
        nod();       //1 задача
        decToBin();  //2 задача
        decToHex();   //3 задача
        seven();     //4 задача

    }
}
