package Farm;

import Farm.Animals.Home.Cat;
import Farm.Animals.Home.Chicken;
import Farm.Animals.Home.HomeAnimals;
import Farm.Animals.Wild.AttackAble;
import Farm.Animals.Wild.Bear;
import Farm.Animals.Wild.WildAnimals;

import java.util.Arrays;

/*
 * есть ферма, у ней есть владелец. фермер один. есть животные домашние.
 * максимум N животных
 * живёт за счёт ресурсов, собранных с домашних животных.
 *
 * фермер с заданным количеством ресурсов
 * фермер должен уметь собирать ресурсы с животных
 * когда животные закончаться, он может их употребить в пищу.
 *
 * фермер 1кг животного - 1 ед. ресурса.
 * фермер может кормить животных. и может прогнать дикое животное с фермы
 * интерфейс для фермера
 *
 * домашние животные: корова курица кот кролик
 *
 * у животных есть имя, вес, скорость, здоровье, и ресурсы.
 *
 * домашние животные пригодные в пищу. ресурсы можно собрать с коровы и курицы.
 *
 * домашнее животное может убежать от дикого, если его скорость больше.
 * домашние животные могут пполнять здоровье, на +1 но не больше изначального
 *
 * восполнять будут во время кормления фермером.
 *
 * дикие животные. волк медведь лиса.
 * имя, вес, скорость, сила(сила атаки)
 *
 * диеое животное может съесть или ранить домашнее животное.
 *
 * домашнее животное, если его съели, его не остатся.
 *
 * фермер может прогнать дикое животное. дикое животное приходит только 3 раза
 *
 * метод прошёл день
 * 1 у фермера тратятся ресурсы (1-2 ед)
 * если фермер после траты имеет ресурсы - игра продолжается.
 * 2 приходит на ферму рандомное животное
 * пытается съесть домашнее рандомное животное.
 * фермер может рандомно програть животное
 * 3 фермер кормит животных
 * животные лечатся
 * 4 фермер собирает ресурсы.
 * фермер ест. сначала ресурсы, потом животных.
 *
 * интерфейсы бывают без методов. используются как маркеры. отмечают классы.
 * */
public class Main {

    public static void main(String[] args) {
        int day = 0;
        Farmer farmer = new Farmer();
        Chicken derp = new Chicken("Derp", 2, 4, 3, 1);
        Chicken derp1 = new Chicken("Derp1", 2, 4, 3, 1);
        Chicken derp2 = new Chicken("Der2", 2, 4, 3, 1);
        Cat boris = new Cat("Boris", 3, 10, 9);

        Farm farm = new Farm();
        farm.addHomeAnimal(boris);
        farm.addHomeAnimal(derp);
        farm.addHomeAnimal(derp1);
        farm.addHomeAnimal(derp2);
        System.out.println(farm);
        System.out.println(farm.getQty(farm));
        AttackAble.attack(farm.getRandomHomeAnimal(farm));



        while (farmer.isAlive) {
            farmer.eat();
 //           System.out.println(farmer.getRes());
            farmer.defend();
            farmer.feed();
            farmer.gather();
            System.out.println("День заканчивается");
            day++;
            System.out.println("Наступает день " + day);
        }
        System.out.println("Фермер умер от голода на " + day + " день");


    }}
