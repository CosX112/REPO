package Farm.Animals.Home;

public class Cow extends HomeAnimals {

    public Cow(String name, int weight, int speed, int hp, int res) {
        super(name, weight, speed, hp);
        this.res = res;
    }
}
