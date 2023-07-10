package com.homel.preparation.concurrency.callback.asynchronous;

import com.homel.preparation.concurrency.callback.EventListener;

public class AsynchronousEventConsumer {

    private EventListener listener;

    public AsynchronousEventConsumer(EventListener listener) {
        this.listener = listener;
    }

    public void doAsynchronousOperation(){
        System.out.println("Performing operation in Asynchronous Task");

        new Thread(() -> listener.onTrigger()).start();
    }
}
