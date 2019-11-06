package com.domain.lesson5.unit;


abstract public class Unit implements RestAble {
    protected String name; //protected можем обратится внутри этого методи, и его дочерних классов.
    protected int HP;    // когда не указаны свойства - это называется package private. свойство доступно внутри пакета.
    protected int speed;


    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {

        if (this.name.equals(null) || this.name.equals("")) {
            System.out.println("Имя не может быть пустым. Будем звать тебя Болтун");
            name = "Болтун";

        } else {
            this.name = name;
        }
    }


    public void setHP(int HP) {

        this.HP = HP;
        if (HP <= 0) {
            System.out.println(this.name + " погиб");
        }
    }

    public void setSpeed(int speed) {
        if (this.speed < 0) {
            System.out.println("скорость персонажа должна быть больше 0. Твоя скорость будет 1");
            speed = 1;
        } else
            this.speed = speed;
    }

    public Unit(String name, int speed) {

        this.name = name;
        this.speed = speed;
        //setName(name);
       // setSpeed(speed);

    }

    protected boolean isAlive() {
        return HP > 0;
    }

    public void run() {
        System.out.println("Юнит перемещается со скоростью " + speed);
    }


}
