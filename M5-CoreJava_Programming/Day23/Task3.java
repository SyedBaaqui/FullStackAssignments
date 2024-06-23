/*Task 3: Synchronization and Inter-thread Communication Implement a producer- consumer problem using wait() and notify() methods to handle the correct processing sequence between threads.*/

package com.day23;

class Buffer {
    private int data;
    private boolean empty;

    public Buffer() {
        this.empty = true;
    }

    public synchronized void produce(int newData) {
        while (!empty) {
            try {
                wait(); // Wait until consumer consumes the data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        data = newData;
        empty = false;
        System.out.println("Produced: " + newData);
        notify(); // Notify consumer that data is ready
    }

    public synchronized int consume() {
        while (empty) {
            try {
                wait(); // Wait until producer produces data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }

        int consumedData = data;
        empty = true;
        System.out.println("Consumed: " + consumedData);
        notify(); // Notify producer that space is available
        return consumedData;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            @SuppressWarnings("unused")
			int consumedData = buffer.consume();
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
