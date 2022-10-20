package com.company;

class ThreadCode implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {

            System.out.println(x + "thread name->" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class MultithreadingClass {
    public static void main(String[] args) throws InterruptedException {
        ThreadCode t1 = new ThreadCode();
        ThreadCode t2 = new ThreadCode();
        ThreadCode t3 = new ThreadCode();
        Thread r1 = new Thread(t1);
        Thread r2 = new Thread(t2);
        Thread r3 = new Thread(t3);
        r1.start();
        r2.start();
        r3.start();
    }
}
