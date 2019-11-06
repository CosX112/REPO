package com.domain.lesson5.unit;

// в интерфейсах мы перечисляем методы без реализации которые должны быть реалиованы в классах , расширяющих данный интерфейс.
public class Warrior extends BattleUnits {
    public Warrior(String name, int speed, int HP, int attackScore) {
        super(name, speed, HP, attackScore);
    }


    @Override
    public void attack(Unit enemy) {
        System.out.println(this.name + " атаковал " + enemy.getName());
        enemy.setHP(enemy.getHP() - attackScore);
    }

    @Override
    public void escapeBattleField() {

    }


    @Override
    public void rest() {
        System.out.println("Воин отдыхает");
    }
}
