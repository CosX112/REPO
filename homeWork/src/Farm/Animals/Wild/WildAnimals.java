package Farm.Animals.Wild;

import Farm.Animals.Home.HomeAnimals;
import Farm.Farm;


abstract public class WildAnimals {
    private String title;
    private int weight;
    private int speed;
    private int hp;
    private int attack;
    private int miss = 3;


    public String getTitle() {
        return title;
    }

    public void attack(HomeAnimals enemy, Farm farm) {
        if (this.speed >= enemy.getSpeed()) {
            enemy.setHp(enemy.getHp() - this.attack);
            System.out.println(this.title + " атаковал " + enemy.getName());
        } else if (this.speed < enemy.getSpeed()) {
            System.out.println(enemy.getName() + " сбежал от " + this.title);
        } else {
            System.out.println("Все животные на ферме умерли");
        }
        if (enemy.getHp() <= 0) {
            System.out.println(enemy.getName() + " трагически умер в зубах зверя " + this.title);   //вот тут надо добавить обнуленеие животного в массиве, но пока не понимаю как.
            //пытался добавить метод в Farm(так как массив хранится там), но не могу вызвать его отсюда. в Main не хочу запихивать, так как хочу оставить там только вызовы.
          //  enemy = null; это не работает
            farm.killHomeAnimals(enemy);

        }
    }


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
