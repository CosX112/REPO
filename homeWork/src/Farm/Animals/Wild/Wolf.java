package Farm.Animals.Wild;

public class Wolf extends WildAnimals  {
    public Wolf(String title, int weight, int speed, int hp, int attack) {
        super(title, weight, speed, hp, attack);
        this.setMiss(3);
    }


}
