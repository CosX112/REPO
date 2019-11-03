package Farm;

import Farm.Animals.Home.HomeAnimals;
import Farm.Animals.Wild.WildAnimals;

import java.util.Random;

public class Farmer {

    private int res = 3;
    boolean isAlive = true;

    void eat(Farm farm) {

        if (res > 0) {
            System.out.println("Фермер покушал и сыт");

        } else if (farm.getQty(farm) > 0) {

            HomeAnimals v;
            v = farm.getRandomHomeAnimalForFood(farm);
            if (v == null) {
                System.out.println("Кушать нечего. Остался только кот");
                isAlive = false;  //меняем флаг жизни на смерть.

            } else {
                res = getRes() + v.getWeight();
                System.out.println("Кушать нечего. Фермер убивает свою любимую" + v.getName());
                farm.killHomeAnimals(v);  // ну и убивает родное животное. специально сделал метод для исключения кота
            }
        } else {
            System.out.println("Кушать нечего. Фермер помирает с голода");  //совершенно не понимаю почему это не выдаёт сообщение в консоль
            isAlive = false;  //меняем флаг жизни на смерть.
        }


        res--;
    }


    boolean defend(WildAnimals p) {
        boolean def;
        Random random = new Random();

        def = random.nextBoolean();
        if (def) {
            System.out.println("Фермер защищает ферму");
            p.setMiss(p.getMiss() - 1);
        } else {
            System.out.println("Фермер не успел защитить ферму");
        }
        return def;
    }

    void feed(Farm farm) {
        farm.feeding(farm);
        System.out.println("Фермер кормит животных");
    }

    void gather(Farm farm) {

        System.out.println("Фермер собрал " + farm.gathering(farm) + " ресурсов");
        res = res + farm.gathering(farm);
        System.out.println("У фермера осталось " + res + " ресурсов");
    }

    private int getRes() {
        return this.res;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
