package com.homel.interviews.vk.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Counter {

    public static void main(String[] args) {
        // Создание списка
        List<Integer> arrayList = new ArrayList<>();

        // Заполнение списка элементами от 1 до 100000 и измерение времени
        long startTime = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Вычисление суммы 1-1
        long sum = 0;
        startTime = System.nanoTime();
        for (Integer number : arrayList) {
            sum += number;
        }
        endTime = System.nanoTime();
        long sumDuration = endTime - startTime;

        // Вывод результатов
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Время заполнения списка (нс): " + duration);
        System.out.println("Время вычисления суммы 1-1 (нс): " + sumDuration);

        // Вычисление суммы 1-2
        sum = 0;
        startTime = System.nanoTime();
        for (Integer number : arrayList) {
            sum += number;
        }
        endTime = System.nanoTime();
        sumDuration = endTime - startTime;

        // Вывод результатов
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Время вычисления суммы 1-2 (нс): " + sumDuration);

        // Перемещение первого элемента в конец списка и измерение времени
        startTime = System.nanoTime();
        Collections.shuffle(arrayList);
        endTime = System.nanoTime();
        long moveDuration = endTime - startTime;

        // Вывод времени перемещения элемента
        System.out.println("Время shuffle (нс): " + moveDuration);


        // Вычисление суммы
        sum = 0;
        startTime = System.nanoTime();
        for (Integer number : arrayList) {
            sum += number;
        }
        endTime = System.nanoTime();
        sumDuration = endTime - startTime;

        // Вывод результатов
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Время вычисления суммы 2 (нс): " + sumDuration);

    }
}
