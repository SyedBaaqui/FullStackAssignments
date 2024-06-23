/*Task 5: Thread Pools and Concurrency Utilities Create a fixed-size thread pool and submit multiple tasks that perform complex calculations or I/O operations and observe the execution.*/

package com.day23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submitting tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task " + i);
            executor.submit(task);
        }

        // Shutdown the executor when tasks are done
        executor.shutdown();
    }
}

// Example Task class implementing Runnable interface
class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Task executing: " + taskName);
        // Perform complex calculations or I/O operations here
        try {
            Thread.sleep(1000); // Simulate some time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task completed: " + taskName);
    }
}
