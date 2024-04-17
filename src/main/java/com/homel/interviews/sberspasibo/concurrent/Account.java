package com.homel.interviews.sberspasibo.concurrent;

// Какие проблемы и как исправить
public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return this.balance;
    }

    public static void transfer(Account from, Account to, long amount) {
        synchronized(from) {
            synchronized(to) {
                from.balance -= amount;
                to.balance += amount;
            }
        }
    }
}
