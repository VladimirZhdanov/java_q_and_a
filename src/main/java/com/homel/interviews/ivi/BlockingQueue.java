package com.homel.interviews.ivi;

public interface BlockingQueue {
    void put(Object x) throws InterruptedException;
    Object take() throws InterruptedException;
}
