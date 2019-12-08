import person.Person;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Bill", 34));
        personList.add(new Person("Paul", 12));
        personList.add(new Person("William", 76));
        personList.add(new Person("Donald", 43));
        personList.add(new Person("Bill", 23));
        personList.get(1).setName("Robert");
        personList.get(1).setAge(10);

        //поиск уникальных имен
        Stream<String> stream = personList.stream().map(person -> person.getName()).distinct();
        List<String> uniqueNames = stream.collect(Collectors.toList());

        //вывод списка уникальных имен в формате:
        //Имена: Иван, Сергей, Петр.
        System.out.println("Имена: " + uniqueNames.stream().collect(Collectors.joining(", ")));

        //список людей младше 18, их средний возраст
        Stream<Integer> teenagers = personList.stream().filter(x -> x.getAge() < 18).mapToInt().sum();
    }
}
