package Farm.Animals.Wild;

public class Bear extends WildAnimals  {


    public Bear(String title, int weight, int speed, int hp, int attack) {
        super(title, weight, speed, hp, attack);
        this.setMiss(3);
    }
}


