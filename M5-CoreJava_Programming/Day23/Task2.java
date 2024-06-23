/*Task 2: States and Transitions Create a Java class that simulates a thread going through different lifecycle states: NEW, RUNNABLE, WAITING, TIMED_WAITING, BLOCKED, and TERMINATED. Use methods like sleep(), wait(), notify(), and join() to demonstrate these states.*/

package com.day23;

public class ThreadLifecycleSimulation {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is in NEW state.");
                
                // Moving to RUNNABLE state
                Thread.sleep(1000);
                System.out.println("Thread is in RUNNABLE state.");

                // Moving to WAITING state
                synchronized (ThreadLifecycleSimulation.class) {
                    System.out.println("Thread is in WAITING state.");
                    ThreadLifecycleSimulation.class.wait();
                }

                // Moving to TIMED_WAITING state
                Thread.sleep(2000);
                System.out.println("Thread is in TIMED_WAITING state.");

                // Moving to BLOCKED state
                synchronized (ThreadLifecycleSimulation.class) {
                    Thread blockerThread = new Thread(() -> {
                        synchronized (ThreadLifecycleSimulation.class) {
                            System.out.println("Thread is in BLOCKED state.");
                            ThreadLifecycleSimulation.class.notify();
                        }
                    });
                    blockerThread.start();
                    blockerThread.join(); // wait for blockerThread to complete
                }

                // Moving to TERMINATED state
                System.out.println("Thread is in TERMINATED state.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.join(); // wait for thread to complete
    }
}
