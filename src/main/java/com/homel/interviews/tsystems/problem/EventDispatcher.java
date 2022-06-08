package com.homel.interviews.tsystems.problem;

// Outline:
// [A] Obvious bugs
// [B] Potential problems with that particular implementation
// [C] Changes required to make this code production-ready

// Given the following implementation of event dispatcher…

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {

    public EventDispatcher() {
    }

    private static EventDispatcher instance;

    private List<EventListener> listeners = new ArrayList<>();

    public static EventDispatcher getInstance() {
            if (instance == null) {
                synchronized (EventDispatcher.class) {
                instance = new EventDispatcher();
            }
        }
        return instance;
    }

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void fireEvent(Event event) {
        for (EventListener listener : listeners)
            listener.onEvent(event);
    }
}

interface EventListener {
    void onEvent(Event event);
}

class Event {

    private Object payload;

    public Event(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

}
// … and the following sample invocation code:

class PubSubTest {

    static class Subscriber extends Thread implements EventListener {

        public void onEvent(Event event) {
            System.out.println("Received event: " + event);
        }

        public void run() {
            EventDispatcher dispatcher = EventDispatcher.getInstance();
            dispatcher.registerListener(this);
        }

    }

    static class Publisher extends Thread {

        public void run() {
            EventDispatcher dispatcher = EventDispatcher.getInstance();
            for (int i = 0; i < 100; i++)
                dispatcher.fireEvent(new Event(new Object()));
        }

    }

    public static void main(String[] args) throws Exception {
        new Publisher().start();
    }
}
