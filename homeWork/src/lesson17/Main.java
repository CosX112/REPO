package lesson17;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //найти студентов с уникальными предметами
        String[] arr = {"matan", "emc", "tesla", "e=mc"};
        String[] arr1 = {"matan", "emc", "tesla", "e=mc"};
        String[] arr2 = {"greblya", "emc", "tesla", "e=mc"};
        Student student = new Student("derp", Arrays.asList(arr));
        Student student1 = new Student("derp1", Arrays.asList(arr1));
        Student student2 = new Student("derp2", Arrays.asList(arr1));


    /*   Student[] arr3 = Stream
               .of(student, student1, student2)
               .filter(student3 -> student3.getSubjects().contains(Arrays.equals()));

        System.out.println(arr3);*/




/*                User[] usersArr = users.stream().filter(user -> user.getAge() > 25).toArray(User[]::new);
        Arrays.stream(usersArr).forEach(System.out::println);
        List<User> userList = users.stream().filter(user -> user.getAge() < 25).peek(user -> user.setActive(true))
                .collect(Collectors.toList());
        userList.forEach(System.out::println);
        Set<User> userSet = users.stream().collect(Collectors.toSet());*/
    }
}

class Student {
    private String login;
    private List<String> subjects;

    @Override
    public String toString() {
        return "Student{" +
                "login='" + login + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}