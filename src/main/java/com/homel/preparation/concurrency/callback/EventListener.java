package com.homel.preparation.concurrency.callback;

public interface EventListener {
    String onTrigger();
    void respondToTrigger();
}
