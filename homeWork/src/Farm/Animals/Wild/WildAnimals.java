package Farm.Animals.Wild;

import Farm.Animals.Home.HomeAnimals;
import Farm.Farm;


abstract public class WildAnimals {
    private String title;
    private int weight;
    private int speed;
    private int hp;
    private int attack;
    private int miss;

    WildAnimals(String title, int weight, int speed, int hp, int attack) {
        this.title = title;
        this.weight = weight;
        this.speed = speed;
        this.hp = hp;
        this.attack = attack;


    }

    public int getMiss() {
        return miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

    public String getTitle() {
        return title;
    }

    public void attack(HomeAnimals enemy, Farm farm, Boolean def) {
        if (enemy == null) {
            System.out.println("Пришёл " + this.title + " и обнаружил что убивать некого. Съел еду фермера и ушёл");
        } else {
            if (this.speed >= enemy.getSpeed() && !def) {
                enemy.setHp(enemy.getHp() - this.attack);
                System.out.println(this.title + " атаковал " + enemy.getName());
            } else if (this.speed < enemy.getSpeed()) {
                System.out.println(enemy.getName() + " сбежал от " + this.title);
            } else if (def) {
                System.out.println("Фермер спугнул " + this.title);
              //  this.setMiss(this.getMiss() - 1);
            }
         else{
            System.out.println("Все животные на ферме умерли");
        }
        if (enemy.getHp() <= 0) {
            System.out.println(enemy.getName() + " трагически умер в зубах зверя " + this.title);   //вот тут надо добавить обнуленеие животного в массиве, но пока не понимаю как.
            //пытался добавить метод в Farm(так как массив хранится там), но не могу вызвать его отсюда. в Main не хочу запихивать, так как хочу оставить там только вызовы.
            //  enemy = null; это не работает
            farm.killHomeAnimals(enemy);

        }
    }

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
