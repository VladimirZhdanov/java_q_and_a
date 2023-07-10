package com.homel.preparation.concurrency.callback.synchronous;

import com.homel.preparation.concurrency.callback.EventListener;

public class SynchronousEventConsumer {
    private final EventListener eventListener;

    public SynchronousEventConsumer(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public String doSynchronousOperation(){
        System.out.println("Performing callback before synchronous Task");
        // any other custom operations
        return eventListener.onTrigger();
    }
}
