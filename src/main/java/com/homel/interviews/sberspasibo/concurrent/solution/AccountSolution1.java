package com.homel.interviews.sberspasibo.concurrent.solution;

// Какие проблемы и как исправить
// Ответ: дедлок и надо делать ретраи
public class AccountSolution1 {
    private static final Object tieLock = new Object();
    private long balance;

    public AccountSolution1(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return this.balance;
    }

    public static void transfer(AccountSolution1 from, AccountSolution1 to, long amount) {
        int fromHash = from.hashCode();
        int toHash = to.hashCode();
        System.out.println(fromHash + " " + toHash);

        if (fromHash < toHash) {
            synchronized(from) {
                synchronized(to) {
                    doTransfer(from, to, amount);
                }
            }
        } else if (fromHash > toHash) {
            synchronized(to) {
                synchronized(from) {
                    doTransfer(from, to, amount);
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized(from) {
                    synchronized(to) {
                        doTransfer(from, to, amount);
                    }
                }
            }
        }
    }

    public static void doTransfer(AccountSolution1 from, AccountSolution1 to, long amount) {
        from.balance -= amount;
        to.balance += amount;
    }
}
