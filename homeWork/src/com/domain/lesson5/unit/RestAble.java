package com.domain.lesson5.unit;

public interface RestAble {
    void rest();



    default void escapeBattleField(){
        System.out.println("Юнит сбежал с поля боя");
    }


}
/*
* когда класс расширяет несколько интерфейсов, возникает конфликт, который нужно решать
*
*
* */