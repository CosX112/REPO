package lesson17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsLesson {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("qwe", "QQQ", 2000, 19));
        employees.add(new Employee("asd", "AAA", 3000, 38));
        employees.add(new Employee("zxc", "ZZZ", 2500, 49));
        employees.add(new Employee("vnn", "ZZZ", 4000, 22));
        employees.add(new Employee("tyu", "QQQ", 1500, 22));
        //Группировка по компании
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompany))
                .entrySet()
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getCompany)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() == 22))
                .entrySet()
                .forEach(System.out::println);

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompany, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.toCollection(ArrayList::new)))
                .entrySet()
                .forEach(System.out::println);

        Map<String, Double> compAverageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompany,
                        Collectors.averagingDouble(Employee::getSalary)));

        Map<String, Map<Integer, List<Employee>>> companyAndSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCompany, Collectors.groupingBy(Employee::getSalary)));

    }
}
