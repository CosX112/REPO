package Farm.Animals.Wild;

import Farm.Animals.Home.HomeAnimals;
import Farm.Farm;


// на основе интерфеса не можем создать объект. в интерфейсе перечисляются метод без реализации.
//
public interface AttackAble {
    // с 9й версии доступен модификатор private
    static void attack(HomeAnimals enemy) {
        System.out.println( " атаковал " + enemy);
    }

    // на основе интерфейса нельзя создать экземпляр, т.е объект. все методы по умолчанию публичные.
    default void escapeFarmField(){
        System.out.println("Дикое животное сбежало с поля");
    }

}
