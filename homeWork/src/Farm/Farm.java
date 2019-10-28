package Farm;

import Farm.Animals.Home.Cat;
import Farm.Animals.Home.HomeAnimals;
import LessonClass4.Book;

import java.util.Arrays;

public class Farm {
    private Farmer farmer;
    private HomeAnimals[] homeAnimals = new HomeAnimals[10];

    @Override
    public String toString() {
        return "Farm{" +
                "homeAnimals=" + Arrays.toString(homeAnimals) +
                '}';
    }

    public void addHomeAnimal(HomeAnimals homeAnimals) {
        for (int i = 0; i < this.homeAnimals.length; i++) {

            if (this.homeAnimals[i] == null) {
                this.homeAnimals[i] = homeAnimals;
                break; //return;
            }
        }
    }

    public HomeAnimals[] getHomeAnimals() {
        return homeAnimals;
    }

    public int getQty(Farm farm) {
        for (int i = 0; i < farm.homeAnimals.length; i++)
            if (this.homeAnimals[i] == null) {
                return i;
            }
return 0;
    }
}


