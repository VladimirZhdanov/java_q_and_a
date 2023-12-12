package com.homel.preparation.memory;

public class ByValueOrByReference {

    public static void main(String[] args) {
        int id = 1;
        String name = "1";
        Person person = new Person(1);

        System.out.println("Before call someMethod id = " + id + ", name = " + name + ", person with age = " + person.age);
        someMethod(id, name, person);
        System.out.println("After call someMethod id = " + id + ", name = " + name + ", person with age = " + person.age);
    }

    public static void someMethod(int id, String name, Person person) {
        System.out.println("Received id = " + id + ", name = " + name + ", person with age = " + person.age);
        id = 666;
        name = "666";
        person.age = 666;
        System.out.println("Updated id = " + id + ", name = " + name + ", person with age = " + person.age);
    }



    public static class Person {
        public int age;

        public Person(int age) {
            this.age = age;
        }
    }
}
