package lesson17.tasks.task1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTask {
    public static void main(String[] args) {
        //TODO: найти студентов с уникальными предметами. Задачу решать с использованием stream API
        //найти студентов с уникальными предметами
        Student student1 = new Student("einstein",   Arrays.asList("matan", "phyzic", "electro", "e=mc"));
        Student student2 = new Student("pasha durov", Arrays.asList("matan", "phyzic", "electro", "e=mc"));
        Student student3 = new Student("zcukerberg", Arrays.asList("matan", "phyzic", "electro", "e=mc"));
        Student student4 = new Student("bill gatez", Arrays.asList("matan", "emc", "electro", "e=mc"));
        Student student5 = new Student("elon musk", Arrays.asList("matan", "emc", "programming", "e=mc"));

        Stream<Student> studentStream = Stream.of(student1,student2,student3,student4,student5);

//   .forEach(System.out::println);
   studentStream
           .map(Student::getSubjects).distinct()
           .forEach(System.out::println);







    }
}

class Student {
    // можно добавить дополнительные поля
    private String login;
    private List<String> subjects;

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
