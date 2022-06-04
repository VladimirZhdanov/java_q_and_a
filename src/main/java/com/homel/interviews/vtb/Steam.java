package com.homel.interviews.vtb;

import java.util.Arrays;
import java.util.List;

public class Steam {

    public static void main(String[] args) {
        List<StringBuilder> list = Arrays.asList(
                new StringBuilder("Java "), new StringBuilder("Hello "));
        list.stream().map((x) -> x.append("World  "));
        list.forEach(System.out::print);
    }

    //Ошибка компиляции
    // На консоли появится «Java Hello »
    //На консоли появится «Java World Hello World »
    //Ошибка времени исполнения
}
