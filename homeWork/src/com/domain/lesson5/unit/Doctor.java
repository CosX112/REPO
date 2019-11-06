package com.domain.lesson5.unit;

public class Doctor extends BattleUnits {
    public Doctor(String name, int speed, int HP, int attackScore) {
        super(name, speed, HP, attackScore);
    }

    @Override
    public void attack(Unit friend) {
        System.out.println("Доктор " + this.name + " увеличил здоровье " + friend.getName());
        friend.setHP(friend.getHP() + attackScore);

    }

    @Override
    public void escapeBattleField() {

    }

    @Override
    public void rest() {
        System.out.println("Доктор отдыхает");
    }
}
