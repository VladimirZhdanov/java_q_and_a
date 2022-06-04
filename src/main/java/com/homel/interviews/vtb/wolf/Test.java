package com.homel.interviews.vtb.wolf;

public class Test {
    public static void main(String[] args) {
        // Пусть классы Wolf и Rabbit являются наследниками класса Animal. Корректен ли следующий пример?
        Wolf w = new Wolf();
        Animal a = (Animal)w;
        Rabbit r = (Rabbit)a;
    }
}
