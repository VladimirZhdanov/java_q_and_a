package com.homel.preparation.concurrency.callback.synchronous;

import com.homel.preparation.concurrency.callback.EventListener;

public class SynchronousEventListenerImpl implements EventListener {
    @Override
    public String onTrigger(){
        return "Synchronously running callback function";
    }

    @Override
    public void respondToTrigger(){
        System.out.println("This is a side effect of the asynchronous trigger.");
    }
}
