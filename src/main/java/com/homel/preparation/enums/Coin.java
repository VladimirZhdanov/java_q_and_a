package com.homel.preparation.enums;

import java.util.HashMap;
import java.util.Map;

public class Coin {
    public static final Coin PENNY = new Coin(1, "PENNY", 0);
    public static final Coin NICKEL = new Coin(5, "NICKEL", 1);
    public static final Coin DIME = new Coin(10, "DIME", 2);
    public static final Coin QUARTER = new Coin(25, "QUARTER", 3);
    public static final Coin HALF = new Coin(50, "HALF", 4);
    public static final Coin DOLLAR = new Coin(100, "DOLLAR", 5);

    public final int cents;
    private final String name;
    private final int ordinal;

    private static final Coin[] $VALUES = {PENNY, NICKEL, DIME, QUARTER, HALF, DOLLAR};

    public static Coin[] values() {
        return $VALUES.clone();
    }

    private static final Map<String, Coin> coinByName;

    static {
        coinByName = new HashMap<>();
        for (Coin item : $VALUES) {
            coinByName.put(item.name, item);
        }
    }

    public static Coin valueOf(String name) {
        Coin coin = coinByName.get(name);
        if (coin == null) throw new IllegalArgumentException("No enum value with name: " + name);
        return coin;
    }

    public Coin(int cents, String name, int ordinal) {
        this.cents = cents;
        this.name = name;
        this.ordinal = ordinal;
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Coin q = Coin.PENNY;
        Coin.valueOf("PENNY");
        Coin.valueOf("bad");
    }
}
