package Farm.Animals.Home;

import Farm.Farm;

abstract public class HomeAnimals {
    private String name;
    private int weight;
    private int speed;
    private int hp;
    int res;

    public HomeAnimals(String name, int weight, int speed, int hp) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.hp = hp;
    }


    @Override
    public String toString() {
        return "HomeAnimals{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                ", hp=" + hp +
                ", res=" + res +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
