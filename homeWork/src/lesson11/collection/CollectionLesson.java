package lesson11.collection;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionLesson {
    public static void main(String[] args) {
        Student student = new Student("Иван", "Иванов", 22);
        Student student1 = new Student("Иван", "Иванов", 22);
        Student student2 = new Student("Иван", "Федоров", 18);
        Student student3 = new Student("Алексей", "Михайлов", 25);
        System.out.println("---LinkedList---");
// быстрая вставка в середину и удаление из середины списка,
        // во всех остальных случаях необходимо выбирать ArrayList
        //порядок элементов гарантирован. можно добавлять null, можно хранить дублирующиеся элементы.
        LinkedList<Student> students = new LinkedList<>();
        students.add(student);
        students.add(student1);
        //  students.add(7,student2); indexOutOfBoundsException
        students.add(student2);
        // students.add(null);

        System.out.println(students);
        System.out.println(students.get(0));
        System.out.println("---ArrayList---");
        //порядок элементов гарантирован
        //можно добавить null
        // допускает дублирование элементов
        ArrayList<Student> studentArrayList = new ArrayList<>(20);
        System.out.println(studentArrayList.size());
        studentArrayList.add(student);
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.trimToSize();
        System.out.println(studentArrayList);
        System.out.println(studentArrayList.subList(0, 2));

        //список из массива
        Student[] studentsArr = {student, student1, student2, student3};
        studentArrayList.addAll(Arrays.asList(studentsArr));

        System.out.println(studentArrayList.size());
        System.out.println(studentArrayList);

        //SET
        //используется для хранения уникальных объектов
        // обязательно должно быть переопределение equals и hashcode

        System.out.println("---HashSet---");
        //порядок элементов не гарантирован
        //можно хранить null ( всегда будет на первом месте)
        HashSet<Student> studentHashSet = new HashSet<>(studentArrayList);
        System.out.println(studentHashSet.size());
        System.out.println(studentHashSet);

        //LinkedHashSet<Students>
        //порядок элементов гарантирован

        System.out.println("---TreeSet---");
        //нельзя добавить null
        // элементы хранятся в отсортированном порядке
        TreeSet<Student> studentTreeSet = new TreeSet<>(Arrays.asList(studentsArr));
        // класс должен реализовывать интерфейс Comparable
        //
        studentTreeSet.add(student3);
        System.out.println(studentTreeSet);
        //в конструктор ThreeSet передать Comparator

        Comparator<Student> studentComparator = new StudentNameComparator().thenComparing(new StudentAgeComparator());
        TreeSet<Student> studentTreeSet1 = new TreeSet<>(studentComparator);
        studentTreeSet1.add(student1);
        studentTreeSet1.add(student2);
        studentTreeSet1.add(student);
        studentTreeSet1.add(student3);
        studentTreeSet1.add(student1);

        System.out.println(studentTreeSet1);

        //перебор коллекций
        for (Student student4 : students) {
            System.out.println(student);
            System.out.println(student.getName());
        }
        Iterator<Student> studentIterator = students.listIterator();
        while (studentIterator.hasNext()) {
            if (studentIterator.next().getName().equals("Иван")) {
                studentIterator.remove();
            }
        }
        System.out.println(students);
    }
}
