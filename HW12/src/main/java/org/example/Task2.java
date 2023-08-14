package org.example;

import java.util.concurrent.Semaphore;

public class Task2 {
    private static final Semaphore fizzSemaphore = new Semaphore(0);
    private static final Semaphore buzzSemaphore = new Semaphore(0);
    private static final Semaphore fizzbuzzSemaphore = new Semaphore(0);
    private static final Semaphore numberSemaphore = new Semaphore(1);

    private static int currentNumber = 1;
    private static int n = 15;

    public static void fizz() {
        while (currentNumber <= n) {
            try {
                fizzSemaphore.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (currentNumber > n) break;
            System.out.println("fizz");
            currentNumber++;
            release();
        }
    }

    public static void buzz() {
        while (currentNumber <= n) {
            try {
                buzzSemaphore.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (currentNumber > n) break;
            System.out.println("buzz");
            currentNumber++;
            release();
        }
    }

    public static void fizzbuzz() {
        while (currentNumber <= n) {
            try {
                fizzbuzzSemaphore.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (currentNumber > n) break;
            System.out.println("fizzbuzz");
            currentNumber++;
            release();
        }
    }

    public static void number() {
        while (currentNumber <= n) {
            try {
                numberSemaphore.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (currentNumber > n) break;
            System.out.println(currentNumber);
            currentNumber++;
            release();
        }
    }

    public static void release() {
        if (currentNumber <= n) {
            boolean divisibleBy3 = currentNumber % 3 == 0;
            boolean divisibleBy5 = currentNumber % 5 == 0;

            if (divisibleBy3 && divisibleBy5) {
                fizzbuzzSemaphore.release();
            } else if (divisibleBy3) {
                fizzSemaphore.release();
            } else if (divisibleBy5) {
                buzzSemaphore.release();
            } else {
                numberSemaphore.release();
            }
        }
    }
}