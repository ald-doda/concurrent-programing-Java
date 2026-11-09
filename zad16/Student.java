package zad16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Student implements Runnable {
    private final int id;
    private final CyclicBarrier barijera;
    private boolean dobioPapir = false;

    public Student(int id, CyclicBarrier barijera) {
        this.id = id;
        this.barijera = barijera;
    }

    public synchronized void primiPapir() {
        dobioPapir = true;
        System.out.println("Student " + id + " je dobio zadatke.");
        notifyAll();
    }
    @Override
    public void run() {
        try {
            synchronized (this) {
                System.out.println("Student " + id + " ceka zadatke.");

                while (!dobioPapir) {
                    wait();
                }
            }

            barijera.await();

            System.out.println("Student " + id + " pocinje da radi.");
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2001));

            barijera.await();

            System.out.println("Student " + id + " izlazi sa ispita.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}