package com.homel.preparation.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIPractice {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1", "a2", "a3", "a1");

        // найти количество "a1"
        var resultLong = list.stream().filter(i -> i.equals("a1")).count();
        System.out.println(resultLong);

        // Вернуть первый элемент коллекции или 0, если коллекция пуста
        var resultString = list.stream().findFirst().orElse("0");
        System.out.println(resultString);

        // Вернуть последний элемент коллекции или «empty», если коллекция пуста
        resultString = list.stream().skip(list.size() - 1).findFirst().orElse("empty");
        System.out.println(resultString);

        // Найти элемент в коллекции равный «a3» или кинуть ошибку
        resultString = list.stream().filter(i -> i.equals("a3")).findAny().orElseThrow();
        System.out.println(resultString);

        // Вернуть третий элемент коллекции по порядку
        resultString = list.stream().skip(2).findFirst().orElse("empty");
        System.out.println(resultString);

        // Вернуть два элемента начиная со второго
        var resultList = list.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(resultList);

        // Выбрать все элементы по шаблону
        resultList = list.stream().filter((s) -> s.contains("1")).collect(Collectors.toList());
        System.out.println(resultList);


        List<People> listPeople = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN));

        // Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        var resultPeopleList = listPeople.stream().filter(person -> {
            return person.sex.equals(Sex.MAN) && (person.age <= 27 && person.age >= 18);
        }).collect(Collectors.toList());
        System.out.println(resultPeopleList);

        // Найти средний возраст среди мужчин
        var resultPeopleDouble = listPeople
                .stream()
                .filter(i -> i.sex.equals(Sex.MAN))
                .mapToInt(i -> i.age)
                .average()
                .orElse(0);
        System.out.println(resultPeopleDouble);

        // Найти кол-во потенциально работоспособных людей в выборке
        // (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        var resultPeopleLong = listPeople.stream().filter(person -> {
            if (person.sex.equals(Sex.WOMEN) && person.age >= 18 && person.age < 55) {
                return true;
            } else if (person.sex.equals(Sex.MAN) && person.age >= 18 && person.age < 60) {
                return true;
            } else {
                return false;
            }
        }).count();
        System.out.println(resultPeopleLong);


    }
}

class People {
    String name;
    int age;
    Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

enum Sex {
    MAN, WOMEN
}
