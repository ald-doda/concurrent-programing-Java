package zad14;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 4;
        CyclicBarrier barrier = new CyclicBarrier(n);
        Thread[] niti = new Thread[n];

        for (int i = 0; i < n; i++) {
            MyThread posao = new MyThread(i, barrier);
            niti[i] = new Thread(posao);
            niti[i].start();
        }

        for (int i = 0; i < n; i++) {
            niti[i].join();
        }

        System.out.println("Sve niti su zavrsile tri kruga.");
    }
}