package lesson17;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPILesson {
    public static void main(String[] args) {
        // Stream API начиная с 8й версии
        /*Для работы с потоками данных. они(методы) работают с данными, но не хранят их
        делятся на две категории:
        1. Промежуточнеые - обрабатывают данные, и возвращают снова Stream объект
        ничего не будут делать с потокм, пока не будет терминального метода.

        данные проходят через всю цепочку
        stream.промежуточный().промежуточные().ещёпромежуточный().Терминальный()
         поток -> промежуточный  метод -> ещё один -> термианльный

        2.Терминальные - они не возвращают стрим объект, и всегда завершают цепочку методов. может быть в цепочке только
        один

        Методы получения стрим-объектов
        1. у коллекций есть метод стрим, возвращающий стрим
        collection.stream();
        2. из массива
        Arrays.stream(arr);
        3. из файла Files
        Files.lines(path_to_file);
        4. из строки
        string.chars();
        5. используя билдер builder
        Stream.builder().add(obj).add(obj2).add(obj3).add(objN);
        6. of
        Stream.of(1, 2, 3, 4);
        ^ это всё возвращает потоки
         * */
        Stream<Integer> integerStream = Stream.of(6, 8, 90, -34, 0, -12);
   //     integerStream.(num -> num < 0).map(num -> num * 10).limit(1).forEach(System.out::println);
        // filter возвращает всё, что соответсвует предикату внутри()
        // map Преобразующий, принимает на вход функцию, и изменяет её согласно функции внутри (). вернёт тоже поток
        // limit ограничивает количество элементов
        // foreach обрабатывает каждый элементр стрима
        integerStream = Stream.of(5, 7, 89, 89, 21, 34, 21, -89);
        integerStream.distinct().sorted().forEach(System.out::println);
        //distinct возвращает только уникальные объекты, по сути убирает дубли
//sorted - сортировка. если не передаём метод, то отсортирует по возрастанию

        //терминальные методы
        //anyMatch | allMatch | noneMatch
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.anyMatch(num -> num == 0));
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.allMatch(num -> num == 0));
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.noneMatch(num -> num == 0));
        //anyMatch возвращает 1 если хоть один объект выполняет условие
        //allMatch -//- еслт все выполняют условия
        //noneMatch -//- если ни один не выполняет условие

        String[] stringsArr = {"aa", "bb", "cc", "dd"};
        Arrays.stream(stringsArr).findFirst().get();
        Arrays.stream(stringsArr).findFirst().orElse("default");
        Arrays.stream(stringsArr).findFirst().isPresent();

        //Arrays.stream(stringsArr).skip(2).limit(1).forEach(System.out::println);
        Arrays.stream(stringsArr).skip(2).filter(str -> str.startsWith("c")).forEach(System.out::println);


        //findFirs возвращает объект типа optional, который содержит первый элемент,  нужны для того чтобы не проверять
        // на null
        //optional - просто контейнер, исключающих null
        //orElse или значене по умолчанию
        //isPresent(); возвращает
        //skip(); - пропускает указанное количество элементов
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("qwe", 34));
        users.add(new User("asd", 36));
        users.add(new User("zxc", 18));
        users.add(new User("dfg", 34));
        users.add(new User("qwe", 22));
        //массив пользователей старше 25
        //   User[] usersArr = users.stream().filter(user -> user.getAge() > 25).toArray(User[]::new);
        User[] usersArr = users.stream().filter(user -> user.getAge() > 25).toArray(User[]::new);
        Arrays.stream(usersArr).forEach(System.out::println);
        List<User> userList = users.stream().filter(user -> user.getAge() < 25).peek(user -> user.setActive(true))
                .collect(Collectors.toList());
        userList.forEach(System.out::println);
        Set<User> userSet = users.stream().collect(Collectors.toSet());

        ArrayList<User> userArrayList = users.stream().sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toCollection(ArrayList::new));

        User minUser = users.stream().min(Comparator.comparing(User::getName))
                .orElse(new User("default", 0));
        User maxUser = users.stream().max(Comparator.comparing(User::getName))
                .orElse(new User("default", 100));
        System.out.println(maxUser);

        String[] stringsArr2 = {"aaa", "cc", "cc", "dddd", "f"};
        Map<String, Integer> map = Arrays.stream(stringsArr2).collect(Collectors.toMap(Function.identity(),
                String::length, (item1, item2) -> item1));
        List<String> stringList = Arrays.asList("34", "14", "78");
        stringList
                .stream()
                .flatMap(num -> Stream.of(Integer.parseInt(num)))
                .forEach(System.out::println);
        //классная штука, как организовыввать мапы в потоке
        //Function.identity() для выбора ключа
        //String::length для выбора данных
        // (item1, item2) -> item1) для сравнения одинаоковых ключей


        //reduce
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4);
        Optional<Integer> optionalInteger = integerStream1.reduce((x, y) -> x + y);
        System.out.println(optionalInteger.get());


        Stream<String> stringStream = Stream.of("Java", "Junior");
        String res = stringStream.reduce("Result", (x, y) -> x + " " + y);
        System.out.println(res);

        integerStream1 = Stream.of(1, -2, -3, 4);
       int result =  integerStream1.reduce(0, (x, y) -> {
            if (x < 0 || y < 0) return 0;
        else return x + y;
    }, (x, y) -> x + y);
        System.out.println(result);

    }
}

class User {
    private String name;
    private int age;
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                isActive() == user.isActive() &&
                getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), isActive());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}