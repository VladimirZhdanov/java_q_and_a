package com.homel.preparation.concurrency.callback.synchronous;

import com.homel.preparation.concurrency.callback.EventListener;
import com.homel.preparation.concurrency.callback.synchronous.SynchronousEventConsumer;
import com.homel.preparation.concurrency.callback.synchronous.SynchronousEventListenerImpl;

public class Main {


    public static void main(String[] args) {
        EventListener listener = new SynchronousEventListenerImpl();
        SynchronousEventConsumer synchronousEventConsumer = new SynchronousEventConsumer(listener);
        String result = synchronousEventConsumer.doSynchronousOperation();
    }
}
