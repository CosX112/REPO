package Farm.Animals.Wild;

public class Fox extends WildAnimals {
    public Fox(String title, int weight, int speed, int hp, int attack) {
        super(title, weight, speed, hp, attack);
        this.setMiss(3);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

}
