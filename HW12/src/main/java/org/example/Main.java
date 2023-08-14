package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task1.runTask(); //endless

        Thread fizzThread = new Thread(Task2::fizz);
        Thread buzzThread = new Thread(Task2::buzz);
        Thread fizzbuzzThread = new Thread(Task2::fizzbuzz);
        Thread numberThread = new Thread(Task2::number);

        fizzThread.start();
        buzzThread.start();
        fizzbuzzThread.start();
        numberThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzbuzzThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fizzThread.interrupt();
        buzzThread.interrupt();
        fizzbuzzThread.interrupt();
        numberThread.interrupt();
    }
}