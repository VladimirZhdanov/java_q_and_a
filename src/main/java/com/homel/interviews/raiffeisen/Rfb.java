package com.homel.interviews.raiffeisen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rfb {

    public List<Person> getTopAgeForName(List<Person> persons) {
        List<Person> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (Person person : persons) {
            if (map.containsKey(person.name)) {
                Integer currentAge = map.get(person.name);
                if (currentAge < person.age) {
                    map.put(person.name, person.age);
                }
            } else {
                map.put(person.name, person.age);
            }
        }

        map.forEach((name, age) -> {
            res.add(new Person(name, age));
        });

        return res;
    }

    public static void main(String[] args) {

    }


    public static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
