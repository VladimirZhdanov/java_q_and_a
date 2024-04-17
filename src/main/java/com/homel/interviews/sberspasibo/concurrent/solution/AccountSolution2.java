package com.homel.interviews.sberspasibo.concurrent.solution;

import java.util.concurrent.locks.ReentrantLock;

// Какие проблемы и как исправить
// Ответ: дедлок и надо делать ретраи
public class AccountSolution2 {
    ReentrantLock lock = new ReentrantLock();
    private long balance;

    public AccountSolution2(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return this.balance;
    }

    public static void transfer(AccountSolution2 from, AccountSolution2 to, long amount) {
       while (true) {
           System.out.println("1");
           from.lock.lock();
           try {
               if (!to.lock.tryLock()) {
                   System.out.println("continue");
                   continue;
               }
               try {
                   doTransfer(from, to, amount);
                   System.out.println("return");
                   return;
               } finally {
                   System.out.println("to.lock.unlock()");
                   to.lock.unlock();
               }
           } finally {
               System.out.println("from.lock.unlock()");
               from.lock.unlock();
           }
       }
    }

    public static void doTransfer(AccountSolution2 from, AccountSolution2 to, long amount) {
        from.balance -= amount;
        to.balance += amount;
    }
}
