package lesson17.tasks.task3;

import java.time.LocalDate;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }

    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    // TODO: добавить все необходимые методы


    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Pupil(int number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }
}
