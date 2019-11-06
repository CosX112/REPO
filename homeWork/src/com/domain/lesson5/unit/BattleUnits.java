package com.domain.lesson5.unit;

// BattleUnit bu = new BattleUnit("юнит", 6)

import java.util.Random;

abstract public class BattleUnits extends Unit implements AttackAble {   //Unit это базовый(родительский) класс. BattleUnits - дочерний класс
    // абстрактный класс что-то среднее между классом и интерфейсом. есть с реализацией и без реализации.
    protected int attackScore;

    public BattleUnits(String name, int speed, int HP, int attackScore) {
        super(name, speed); //вызов конструктора родителя
        if (attackScore <= 0) {
            System.out.println("Величина атаки должна быть больше 0");
        } else
            this.HP = HP;
        this.attackScore = attackScore;
    }

    public static BattleUnits RandomBattleUnits(String type) {
        if (type.equalsIgnoreCase("warrior")) {
            return new Warrior("Рядовой" + (int) (Math.random() * 1000), 3, 20, 15);
        } else if (type.equalsIgnoreCase("knight")) {
            return new Knight("Рыцарь" + (int) (Math.random() * 1000), 3, 20, 15);
        } else if (type.equalsIgnoreCase("doctor")) {
            return new Doctor("Доктор" + (int) (Math.random() * 1000), 3, 20, 15);
        } else


            return null;
    }


    public void setAttackScore(int attackScore) {
        if (this.attackScore < 0) {
            System.out.println("Величина атаки должны быть больше 0");
        } else
            this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    @Override
    public String toString() {
        return "BattleUnits{" +
                "attackScore=" + attackScore +
                ", name='" + name + '\'' +
                ", HP=" + HP +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void escapeBattleField() {
        System.out.println("Юнит " + this.name + " сбежал с поля боя");
    }
}
