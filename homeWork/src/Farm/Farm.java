package Farm;

import Farm.Animals.Home.Cat;
import Farm.Animals.Home.HomeAnimals;
import Farm.Animals.Wild.WildAnimals;
import LessonClass4.Book;

import java.util.Arrays;

public class Farm {
    private Farmer farmer;
    private HomeAnimals[] homeAnimals = new HomeAnimals[10];
    private WildAnimals[] wildAnimals = new WildAnimals[10];

    @Override
    public String toString() {
        return "Farm{" +
                "farmer=" + farmer +
                ", homeAnimals=" + Arrays.toString(homeAnimals) +
                ", wildAnimals=" + Arrays.toString(wildAnimals) +
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


    public void addHomeAnimal(HomeAnimals... homeAnimals) {
        for (int i1 = 0; i1 < homeAnimals.length; i1++) {
            for (int i = 0; i < this.homeAnimals.length; i++) {
                if (this.homeAnimals[i] == null) {
                    this.homeAnimals[i] = homeAnimals[i1];
                    break;
                }
                }
            }
        }


    public void killHomeAnimals(HomeAnimals homeAnimal) {
        if (homeAnimal == null) {
            System.out.println("животные кончились");
        } else {
            for (int i = 0; i < this.homeAnimals.length; i++) {

                if (this.homeAnimals[i] == homeAnimal) {
                    this.homeAnimals[i] = null;
                    break;
                }
            }
        }

    }


    public void killWildAnimals(WildAnimals wildAnimals) {
        if (wildAnimals == null) {
            System.out.println("животные кончились");
        } else {
            for (int i = 0; i < this.wildAnimals.length; i++) {

                if (this.wildAnimals[i] == wildAnimals) {
                    this.wildAnimals[i] = null;
                    break;
                }
            }
        }

    }


    public void addWildAnimal(WildAnimals wildAnimals) {
        for (int i = 0; i < this.wildAnimals.length; i++) {

            if (this.wildAnimals[i] == null) {
                this.wildAnimals[i] = wildAnimals;
                break; //return;
            }
        }
    }

    public void addWildAnimal(WildAnimals... wildAnimals) {
        for (int i1 = 0; i1 < wildAnimals.length; i1++) {
            for (int i = 0; i < this.wildAnimals.length; i++) {
                if (this.wildAnimals[i] == null) {
                    this.wildAnimals[i] = wildAnimals[i1];
                    break;
                }
            }
        }
    }

    public void feeding(Farm farm) {

        for (int i = 0; i < farm.homeAnimals.length; i++) {
            if (farm.homeAnimals[i] != null) {
                this.homeAnimals[i].setHp(this.homeAnimals[i].getHp() + (int) (Math.random() * this.homeAnimals[i].getMaxHp()));
            }
        }

    }

    public int gathering(Farm farm) {
        int res = 0;
        for (int i = 0; i < farm.homeAnimals.length; i++) {
            if (farm.homeAnimals[i] != null) {
                res = res + this.homeAnimals[i].getRes();
            }
        }
        return res;
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
        System.out.println("животных больше нет");
        return homeAnimals[0]; // среда ругается на отсутвие возвращаемого объекта, хотя вон там в ифе чуть выше он всегда выдаётся.
        //я проверил десяток раз, всегда всё ок, но заглушку оставил, иначе выдаёт ошибку(не понимаю почему)
        //очевидно потому что сюда он выпадет когда все жиотные закончатся. Пока оставил возвращение 0 животного, а на стороне атаки сделаю проверку на null
        //не уверен можно ли на запрос не вернуть ничего, но тут бы это пригодилось
    }

    public HomeAnimals getRandomHomeAnimalForFood(Farm farm) {
        int q = 0;


        for (int i = 0; i < farm.homeAnimals.length; i++) {   //считаем количество животных на ферме, отдаём его в q
            if (this.homeAnimals[i] != null && !this.homeAnimals[i].getName().equals("Борис")) {
                q++;
            }
        }

        int v = (int) (Math.random() * q) + 1;    //рандомно выбираем номер животного(не порядковый в массиве!) и передаём его в v(victim)
        for (int i1 = 0; i1 < farm.homeAnimals.length; i1++) {  //идём по массиву с целью счёта живых животных. живые животные !=null
            if (this.homeAnimals[i1] != null && !this.homeAnimals[i1].getName().equals("Борис")) {
                v--;
            }                             //считаем животных. если животное не мертво, убавляем счётчик рандомного животного
            if (v <= 0) {               //когда счётчик рандомного животного станет =0, т.е счётчик дойдёт до жертвы - вернуть животное, соответсвующее номеру в массиве
                return homeAnimals[i1];

            }
        }
        System.out.println("животных больше нет");
        return null; // среда ругается на отсутвие возвращаемого объекта, хотя вон там в ифе чуть выше он всегда выдаётся.
        //я проверил десяток раз, всегда всё ок, но заглушку оставил, иначе выдаёт ошибку(не понимаю почему)
        //очевидно потому что сюда он выпадет когда все жиотные закончатся. Пока оставил возвращение 0 животного, а на стороне атаки сделаю проверку на null
        //не уверен можно ли на запрос не вернуть ничего, но тут бы это пригодилось
    }


    public WildAnimals getRandomWildAnimal(Farm farm) {
        int q = 0;


        for (int i = 0; i < farm.wildAnimals.length; i++) {   //считаем количество диких животных на ферме, отдаём его в q
            if (this.wildAnimals[i] != null && this.wildAnimals[i].getMiss()>0) {   //исключая животных у которых кончились попытки
                q++;
            }
        }

        int v = (int) (Math.random() * q) + 1;    //рандомно выбираем номер животного(не порядковый в массиве!) и передаём его в v(victim)
        for (int i1 = 0; i1 < farm.wildAnimals.length; i1++) {  //идём по массиву с целью счёта живых животных. живые животные !=null и с наличием попыток атаковать
            if (this.wildAnimals[i1] != null && this.wildAnimals[i1].getMiss() > 0 ) {
                v--;
            }                             //считаем животных. если животное не мертво, убавляем счётчик рандомного животного
            // по сути у диких животных пока нет возможности умереть, у них только промахи, и достаточно было бы считать только их
            //но я скопировал этот метод из домашних, и проверка на смерть никому не мешает
            if (v <= 0) {               //когда счётчик рандомного животного станет =0, т.е счётчик дойдёт до жертвы - вернуть животное, соответсвующее номеру в массиве
                return wildAnimals[i1];


            }
        }
        return null; // вернёт null, если дикие животные кончились
    }


    public HomeAnimals[] getHomeAnimals() {   //возвращаем массив животных
        return homeAnimals;
    }

    public int getQty(Farm farm) {    //метод для получения количества животных(возможно уже не надо - перекочевало в получение рандомного животного)
        int q = 0;  //снова нужно, для определения может ли фермер, ну, сам съесть животное

        for (int i = 0; i < farm.homeAnimals.length; i++) {
            if (this.homeAnimals[i] != null) {
                q++;
            }

        }
        return q;
    }
}


