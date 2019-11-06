package com.domain.lesson5;

import com.domain.lesson5.unit.*;
import com.domain.lesson5.unit.King;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Укажите тип персонажа");


        // warrior knight doctor
        BattleUnits battleUnits = null;
        while (battleUnits == null) {
            String userChoice = in.nextLine();
            if ("warrior".equalsIgnoreCase(userChoice)) {
                battleUnits = new Warrior("Рядовой В.", 3, 20, 15);

            } else if ("knight".equalsIgnoreCase(userChoice)) {
                battleUnits = new Knight("Жопонадиратель", 4, 22, 18);
            } else if ("doctor".equalsIgnoreCase(userChoice)) {
                battleUnits = new Doctor("Медик", 2, 40, 5);
            } else {
                System.out.println("Укажите правильный класс персонажа");
            }
        }
        BattleUnits enemy;
        enemy = BattleUnits.RandomBattleUnits("warrior");
        Unit king =  King.GetKing();


        //enemy = new Warrior("Злодей", 10, 8, 10);
        BattleUnits enemy1;

//enemy1 = new Doctor("", 16, 60, 15);

        battleUnits.run();
        battleUnits.attack(enemy);
        System.out.println();

        System.out.println(enemy.getHP());
        System.out.println(king);

    }


}
/*
 *приципы:
 * 1) наследование extends расширение функционала родителей
 * 2) инкапсуляция скрытие деталей реализации (модификаторы доступа private protected)
 * 3) полиморфизм наследования - когда мы через общий тип создаём разные объекты
 * 4) Абстракция - интерфейсы и абстрактные классы. методы определили, которые хз где и когда будут реализованы
 * 5) полиморфизм - перегрузка методов. методы имеют одинаковые названия, одинаковый тип возвращаемых данных, но одинаковые аргументы
 *
 * добавить проверок. имя не может быть пустым, здоровье >0, скорость <= 0
 *
 *
 *
 * */