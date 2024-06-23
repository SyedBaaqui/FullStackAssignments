/*Task 7: Writing Thread-Safe Code, Immutable Objects Design a thread-safe Counter class with increment and decrement methods. Then demonstrate its usage from multiple threads. Also, implement and use an immutable class to share data between threads.*/

package com.day23;

public class CounterAndImmutableExample {
    
    // Thread-safe Counter class
    public static class Counter {
        private int count = 0;

        // Method to increment the counter
        public synchronized void increment() {
            count++;
        }

        // Method to decrement the counter
        public synchronized void decrement() {
            count--;
        }

        // Method to get the current count value
        public synchronized int getCount() {
            return count;
        }
    }

    // Immutable class for data sharing between threads
    public static final class ImmutableData {
        private final int value;

        public ImmutableData(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        // Method to create a new instance with an updated value
        public ImmutableData withValue(int newValue) {
            return new ImmutableData(newValue);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Creating an instance of Counter
        Counter counter = new Counter();

        // Creating multiple threads to increment and decrement the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for threads to complete
        thread1.join();
        thread2.join();

        // Print the final count
        System.out.println("Final count: " + counter.getCount());

        // Creating an instance of ImmutableData
        ImmutableData immutableData = new ImmutableData(10);

        // Creating multiple threads to access immutable data
        Thread thread3 = new Thread(() -> {
            ImmutableData data = immutableData.withValue(immutableData.getValue() + 1);
            System.out.println("Thread 3: New value is " + data.getValue());
        });

        Thread thread4 = new Thread(() -> {
            ImmutableData data = immutableData.withValue(immutableData.getValue() - 1);
            System.out.println("Thread 4: New value is " + data.getValue());
        });

        // Start both threads
        thread3.start();
        thread4.start();

        // Wait for threads to complete
        thread3.join();
        thread4.join();
    }
}
