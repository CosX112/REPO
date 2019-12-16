package lesson14.io.lesson15.test;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        // сериализация - преобразование объектов в последовательность байт
        // десериализация - востановление объектов из последовательности байт

        //  ObjectInputStream  // ничего не передают просто преобразовывают в байты
        //  ObjectOutputStream  // ничего не передают просто преобразовывают в байты


        File file = new File("stst.bin");
        LaunchStatistic statistic = null;
        // если файла нет то создаем объект
        if (!file.exists()) statistic = new LaunchStatistic();
        else {
            // десериализация (чтение)
            try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file))) {  // FileInputStream(file) - получаем информацию из файла/ ObjectInputStream - десериализация
                statistic = (LaunchStatistic) objectInput.readObject();                               // прочитали объект, привели его к типу (LaunchStatistic)
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (statistic.isFirstLaunch()) {
            System.out.println("First Launch");

        } else {
            System.out.println(statistic);
        }
        statistic.update();


        // сериализация (запись)

        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(file))) {

            objectOutput.writeObject(statistic);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
