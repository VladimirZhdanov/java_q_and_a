package com.homel.interviews.ivi;

public class Main {

    public static void main(String[] args) {
        BlockingQueue customBlockingQueue = new BlockingQueueClassic(6);
        // Creating producer and consumer threads
        Thread producer = new Thread(new Producer(customBlockingQueue));
        Thread consumer = new Thread(new Consumer(customBlockingQueue));

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {

        private BlockingQueue customBlockingQueue;

        public Producer(BlockingQueue customBlockingQueue) {
            this.customBlockingQueue = customBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    customBlockingQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Consumer implements Runnable {
        private BlockingQueue customBlockingQueue;

        public Consumer(BlockingQueue customBlockingQueue) {
            this.customBlockingQueue = customBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    customBlockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
