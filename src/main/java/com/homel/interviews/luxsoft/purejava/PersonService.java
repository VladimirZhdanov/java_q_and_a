package com.homel.interviews.luxsoft.purejava;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {
    AgeComparator ageComparator = new AgeComparator();
    Set<Person> set = new TreeSet<>(ageComparator);
    List<Person> list = new ArrayList<>();

    public PersonService() {
        Random random = new Random(100);
        for (int i = 0; i < 100_000; i++) {
            boolean sex = i % 2 == 0;
            Person person = new Person(i + "", i + "", i + "", random.nextInt(), sex);
            set.add(person);
            list.add(person);
        }
    }

    public List<Person> searchSet(int age, boolean sex) {
        return set.stream()
                .filter(it -> it.age <= age)
                .filter(it -> it.sex = sex)
                .collect(Collectors.toList());
    }

    public List<Person> searchList(int age, boolean sex) {
        return set.stream()
                .filter(it -> it.age <= age)
                .filter(it -> it.sex = sex)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PersonService personService = new PersonService();

        System.out.println("Start searchSet");
        long start = System.currentTimeMillis();
        List<Person> people = personService.searchSet(40, true);
        System.out.println("Size: " + people.size());
        System.out.println("End searchSet, takes time: "
                + (System.currentTimeMillis() - start));

        System.out.println("Start searchList");
        start = System.currentTimeMillis();
        people = personService.searchList(40, true);
        System.out.println("Size: " + people.size());
        System.out.println("End searchList, takes time: "
                + (System.currentTimeMillis() - start));
    }
}
