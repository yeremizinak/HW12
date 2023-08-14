package org.example;

public class Task1 extends Thread {

    private volatile boolean isAlive = true;

    @Override
    public void run() {
        while (isAlive) {
            try {
                Thread.sleep(1000);
                System.out.println("1 second has passed...");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void runTask() throws InterruptedException {
        Task1 pausableThread = new Task1();
        pausableThread.start();
        Thread.sleep(1000);

        while(pausableThread.isAlive){
            Thread.sleep(5000);
            System.out.println("5 seconds have passed...");

        }
        //pausableThread.setAlive(false);
    }
}