package com.homel.interviews.vtb;

// 1. Корректен ли следующий код?
//  - да, так как метод test является элементом класса Test
//  - нет, так как поле id объявлено как private, а значит недоступно извне объекта
public class Test {
    private int id;

    public Test(int i) {
        id = i;
    }

    public static boolean test(Test t, int id) {
        return t.id == id;
    }
}

