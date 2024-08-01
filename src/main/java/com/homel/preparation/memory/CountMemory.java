package com.homel.preparation.memory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class CountMemory<Document, User> {
    // Если в массиве лежит 1_000_000 документов, то размер будет
    // 1_000_000 * 16 + 4 + 8 байт(UUID + int + Document) + 16-24 байт(CopyOnWriteArrayList) = 28 мб + overhead(16-24 байт)

    // Пустой CopyOnWriteArrayList занимает около 16-24 байт (включая заголовок объекта и указатель на массив).
    // Однако это значение может варьироваться в зависимости от конкретной реализации JVM и настроек памяти.

    // Каждый объект в Java имеет фиксированный размер, который включает в себя заголовок объекта (обычно 8 байт на 64-битной JVM)
    // и указатели на другие объекты.

    // Поскольку CopyOnWriteArrayList использует массив для хранения своих элементов, при инициализации пустого списка он создает массив размером 0.
    // Однако сам массив также занимает память (обычно 12-16 байт, в зависимости от реализации JVM).
    private final List<Document> list = new CopyOnWriteArrayList<>();

    public List<Document> getTop(User user, int limit) {
        return list.stream()
                // Лучше использовать кастомный объект, а не пару для хранения <Document, Double>
                // Map.Entry<Document, Double> = 8 байт(Map.Entry) + 16 + 4 + 8 байт(UUID + int + Document) + 8 + 8 байт(Double) = 52 байт
                // Кастомный объект = 8 байт(объект) + 16 + 4 + 8 байт(Document) + 8 байт (double) = 44 байт
                .map(document -> Map.entry(document, getScore(document, user)))
                .sorted((v1, v2) -> {
                    Double score1 = v1.getValue();
                    Double score2 = v2.getValue();

                    if (Objects.equals(score1, score2)) {
                        return 0;
                    }
                    if (score1 > score2) {
                        return -1;
                    }
                    return 1;
                })
                .map(Map.Entry::getKey)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private double getScore(Document doc, User user) {
        return 0;
    }

    // оверхед объекта 8 байт
    public static class Document {
        private UUID id; //16 байт
        private int likes; //4 байта

        private byte f1; // 1 байт
        private short f2; // 2 байта
        private int f3; // 4 байта
        private long f4; // 8 байтов
        private float f5; // 4 байта
        private double f6; // 8 байтов
        private char f7; // 2 байта
        private boolean f8; //  1 байт
    }
}
