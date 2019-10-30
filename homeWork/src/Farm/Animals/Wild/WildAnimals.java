package Farm.Animals.Wild;

import Farm.Animals.Home.HomeAnimals;
import Farm.Farm;



abstract public class WildAnimals implements AttackAble {
   private  String title;
    private int weight;
    private int speed;
    private int hp;
    private int attack;
    private int miss = 3;





    public WildAnimals(String title, int weight, int speed, int hp, int attack) {
        this.title = title;
        this.weight = weight;
        this.speed = speed;
        this.hp = hp;
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "WildAnimals{" +
                "weight=" + weight +
                ", speed=" + speed +
                ", hp=" + hp +
                ", attack=" + attack +
                ", miss=" + miss +
                '}';
    }


}
