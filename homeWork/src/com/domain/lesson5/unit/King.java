package com.domain.lesson5.unit;

public class King extends Unit {


   private  King(String name, int speed, int HP) {
        super(name, speed);
        this.HP = HP;

    }

public static Unit GetKing(){
      return new King("Король",10,10);
}

    public void rest() {
        System.out.println("Король отдыхает");

    }

    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", speed=" + speed +
                '}';
    }



}
