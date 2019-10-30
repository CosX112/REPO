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

    public HomeAnimals getHomeAnimal(int i) {
        return homeAnimals[i];

    }

    public HomeAnimals getRandomHomeAnimal(Farm farm) {
        int q = 0;


        for (int i = 0; i < farm.homeAnimals.length; i++) {   //считаем количество животных на ферме, отдаём его в q
            if (this.homeAnimals[i] != null) {
                q++;
            }
        }

        int v = (int) (Math.random() * q) + 1;    //рандомно выбираем номер животного(не порядковый в массиве!) и передаём его в v(victim)
        for (int i1 = 0; i1 < farm.homeAnimals.length; i1++) {  //идём по массиву с целью счёта живых животных. живые животные !=null
            if (this.homeAnimals[i1] != null) {
                v--;
            }                             //считаем животных. если животное не мертво, убавляем счётчик рандомного животного
            if (v <= 0) {               //когда счётчик рандомного животного станет =0, т.е счётчик дойдёт до жертвы - вернуть животное, соответсвующее номеру в массиве
                return homeAnimals[i1];

            }
        }
        return homeAnimals[0]; // среда ругается на отсутвие возвращаемого объекта, хотя вон там в ифе чуть выше он всегда выдаётся.
        //я проверил десяток раз, всегда всё ок, но заглушку оставил, иначе выдаёт ошибку(не понимаю почему)
    }


    public HomeAnimals[] getHomeAnimals() {   //возвращаем массив животных
        return homeAnimals;
    }

    public int getQty(Farm farm) {    //метод для получения количества животных(возможно уже не надо - перекочевало в получение рандомного животного)
        int q = 0;

        for (int i = 0; i < farm.homeAnimals.length; i++) {
            if (this.homeAnimals[i] != null) {
                q++;
            }

        }
        return q;
    }
}


