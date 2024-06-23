/*Task 4: Synchronized Blocks and Methods Write a program that simulates a bank account being accessed by multiple threads to perform deposits and withdrawals using synchronized methods to prevent race conditions.*/

package com.day23;

public class BankAccountMain {

    // BankAccount class with synchronized methods
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // Synchronized method for deposit
        public synchronized void deposit(double amount) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
        }

        // Synchronized method for withdrawal
        public synchronized void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + ", insufficient funds.");
            }
        }

        // Synchronized method to get current balance
        public synchronized double getBalance() {
            return balance;
        }
    }

    // Main class to demonstrate concurrent access
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        // Create multiple threads for deposit and withdrawal operations
        Thread thread1 = new Thread(() -> {
            account.deposit(100.0);
        });

        Thread thread2 = new Thread(() -> {
            account.withdraw(200.0);
        });

        Thread thread3 = new Thread(() -> {
            account.deposit(300.0);
        });

        Thread thread4 = new Thread(() -> {
            account.withdraw(400.0);
        });

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
