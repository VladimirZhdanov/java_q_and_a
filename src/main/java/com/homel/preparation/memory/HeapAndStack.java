package com.homel.preparation.memory;

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
