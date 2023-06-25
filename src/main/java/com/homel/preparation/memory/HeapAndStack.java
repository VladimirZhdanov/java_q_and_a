package com.homel.preparation.memory;

// В Java примитивы и ссылки на объекты хранятся в стэке, а объекты в куче.

// Это не так. Ссылки и примитивы тоже могут храниться в куче, а объекты могут храниться в стеке.

// Важно понимать разницу между переменной и полем.

// class User {
//    private int age = 42;
//    private String name = "John Doe";
//
//    public void someMethod() {
//        int someVar = 2;
//        User user = new User();
//    }
// }
// age - это поле. Оно имеет примитивный тип, но храниться будет там же, где и объект - в куче. Так же и поле ссылочного типа name.

// someVar и user - это переменные и они хранятся в стеке. В первой хранится значение 2, во втором ссылка на объект класса User.

// В том смысле, что когда завершится функция, которая создавала user - то указатель стэка должен сместиться вниз, и все эти переменные - ссылка на user, примитив int age и ссылка на name должны исчезнуть из памяти.

// При завершении метода someMethod кадр стека будет уничтожен и вместе с ним перестанут существовать переменные someVar и user. Но сам объект user останется в куче до следующего вызова сборщика мусора. Сборщик мусора при запуске проверит все существующие кадры стека, не найдёт в них ссылки на объект user и только тогда удалит его.
public class HeapAndStack {
    // Под main thread выделяеться stack память (0)
    public static void main(String[] args) {            // Вызов метода в стеке (1)
        int i = 1;                                      // Лежит в обьекте heapAndStack в стек памяти (2.1)
        Object object = new Object();                   // В стеке есть ссылка на Heap (2.2)
        HeapAndStack heapAndStack = new HeapAndStack(); // В стеке есть ссылка на Heap (2)
        heapAndStack.execute(object);                   // Вызов метода в стеке (3)
    }

    void execute(Object params) {
        String str = params.toString();                 // В Heap в String pool, ссылка в стеке (4)
    }
}
