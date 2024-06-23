/*Task 1: Creating and Managing Threads Write a program that starts two threads, where each thread prints numbers from 1 to 10 with a 1-second delay between each number.*/

package com.day23;

public class TwoThreadsExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter(1));
        Thread thread2 = new Thread(new NumberPrinter(2));

        thread1.start();
        thread2.start();
    }

    // Runnable implementation to print numbers from 1 to 10
    static class NumberPrinter implements Runnable {
        private int threadNumber;

        public NumberPrinter(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread " + threadNumber + ": " + i);

                try {
                    Thread.sleep(1000); // 1 second delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
