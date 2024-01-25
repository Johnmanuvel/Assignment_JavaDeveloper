package main.java;

public class Concurrency {

    static class Counter {
        private int count = 0;

        public void increment() {
            for (int i = 0; i < 5; i++) {
                // Simulate some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + ": Count is " + count);
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create two threads
        Thread thread1 = new Thread(() -> counter.increment());
        Thread thread2 = new Thread(() -> counter.increment());

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
