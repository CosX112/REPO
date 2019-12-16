package lesson11.collection;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                getName().equals(student.getName()) &&
                getSurname().equals(student.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class StudentAgeComparator implements Comparator<Student>{


    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}