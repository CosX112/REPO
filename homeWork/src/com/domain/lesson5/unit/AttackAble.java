package com.domain.lesson5.unit;

// на основе интерфеса не можем создать объект. в интерфейсе перечисляются метод без реализации.
//
public interface AttackAble {
    // с 9й версии доступен модификатор private
    void attack(Unit enemy);
    // на основе интерфейса нельзя создать экземпляр, т.е объект. все методы по умолчанию публичные.
    default void escapeBattleField(){
        System.out.println("Юнит сбежал с поля боя");
    }

}
