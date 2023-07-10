package com.homel.preparation.concurrency.callback.asynchronous;

import com.homel.preparation.concurrency.callback.EventListener;

public class Main {
    public static void main(String[] args) {
        EventListener listener = new EventListener() {
            @Override
            public String onTrigger() {
                System.out.println("onTrigger");
                return "onTrigger";
            }

            @Override
            public void respondToTrigger() {
                System.out.println("respondToTrigger");
            }
        };
        AsynchronousEventConsumer synchronousEventListenerConsumer = new AsynchronousEventConsumer(listener);
        synchronousEventListenerConsumer.doAsynchronousOperation();
    }
}
