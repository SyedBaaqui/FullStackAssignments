/*Task 6: Executors, Concurrent Collections, CompletableFuture Use an ExecutorService to parallelize a task that calculates prime numbers up to a given number and then use Completable Future to write the results to a file asynchronously.*/

package com.day23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeNumberAsyncFileWriter {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        int numberLimit = 100; // Example limit for prime numbers
        int numberOfTasks = 5; // Example number of parallel tasks

        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        List<Future<List<Integer>>> futures = new ArrayList<>();

        for (int i = 0; i < numberOfTasks; i++) {
            PrimeNumberCalculator task = new PrimeNumberCalculator(numberLimit);
            Future<List<Integer>> future = executor.submit(task);
            futures.add(future);
        }

        List<Integer> allPrimes = new ArrayList<>();

        for (Future<List<Integer>> future : futures) {
            allPrimes.addAll(future.get());
        }

        executor.shutdown();

        // Use CompletableFuture to asynchronously write primes to a file
        CompletableFuture<Void> writeToFileFuture = CompletableFuture.runAsync(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
                for (Integer prime : allPrimes) {
                    writer.write(prime + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Block and wait for the write operation to complete (optional)
        writeToFileFuture.get();

        System.out.println("Prime numbers written to primes.txt");

        // Shutdown executor (if not already done)
        executor.shutdown();
    }

    static class PrimeNumberCalculator implements Callable<List<Integer>> {
        private int limit;

        public PrimeNumberCalculator(int limit) {
            this.limit = limit;
        }

        @Override
        public List<Integer> call() {
            List<Integer> primes = new ArrayList<>();

            for (int number = 2; number <= limit; number++) {
                if (isPrime(number)) {
                    primes.add(number);
                }
            }

            return primes;
        }

        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
