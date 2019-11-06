package com.domain.lesson5.unit;

public class Knight extends BattleUnits {
    public Knight(String name, int speed, int HP, int attackScore) {
        super(name, speed, HP, attackScore);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "attackScore=" + attackScore +
                ", name='" + name + '\'' +
                ", HP=" + HP +
                ", speed=" + speed +
                '}';
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
        System.out.println("Рыцарь отдыхает");

    }
}
