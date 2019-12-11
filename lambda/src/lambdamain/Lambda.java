package lambdamain;

import person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Bill", 34));
        personList.add(new Person("Paul", 12));
        personList.add(new Person("William", 29));
        personList.add(new Person("Donald", 43));
        personList.add(new Person("Bill", 23));
        personList.add(new Person("John", 42));
        personList.get(3).setName("Robert");
        personList.get(3).setAge(10);

        //поиск уникальных имен
        List<String> uniqueNames = personList.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueNames);

        //вывод списка уникальных имен в формате:
        //Имена: Иван, Сергей, Петр.
        System.out.println(uniqueNames.stream().collect(Collectors.joining(", ", "Имена: ", ".")));

        //В) получить список людей младше 18, посчитать для них средний
        //возраст
        List<String> teenagers = personList.stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("Список людей младше 18: " + teenagers + ". Их средний возраст: ");

        Double averageTeensAge = personList.stream()
                .filter(p -> p.getAge() < 18)
                .mapToInt(Person::getAge)
                .average().getAsDouble();
        System.out.println(averageTeensAge);

        //Г) при помощи группировки получить Map , в котором ключи
        //имена, а значения средний возраст
        Map<String, Double> personsByName = personList.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
        personsByName.forEach((name, age) -> System.out.printf("%s: %s%n", name, age));

        //Д) получить людей, возраст которых от 20 до 45, вывести в консоль
        //их имена в порядке убывания возраста
        List<String> personFrom20To45 = personList.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()))
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(personFrom20To45);
    }
}
