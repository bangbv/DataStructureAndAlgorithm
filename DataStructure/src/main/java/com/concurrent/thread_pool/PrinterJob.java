package com.concurrent.thread_pool;

import java.util.Random;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class PrinterJob implements Runnable {

    private static int nth = 0;

    private final int id;
    private final int speed;

    public PrinterJob(int id) {
        // draw 0-99 and give +1 to progress at least by 1%:
        this.speed = new Random().nextInt(99) + 1;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting printer work: " + id);
        for (int i = 0; i <= 100; i += speed) {
            try {
                MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                // ignore
            }
            System.out.printf("worker %d, done %d%%%n", id, i);
        }
        System.out.println("Done PrinterJob: " + id);
    }
}
