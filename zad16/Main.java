package zad16;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 5;

        CyclicBarrier barijera = new CyclicBarrier(n);
        Student[] studenti = new Student[n];
        Thread[] nitiStudenata = new Thread[n];

        for (int i = 0; i < n; i++) {
            studenti[i] = new Student(i + 1, barijera);
            nitiStudenata[i] = new Thread(studenti[i]);
        }

        Profesor profesor = new Profesor(studenti);
        Thread nitProfesora = new Thread(profesor);

        for (int i = 0; i < n; i++) {
            nitiStudenata[i].start();
        }

        nitProfesora.start();

        nitProfesora.join();

        for (int i = 0; i < n; i++) {
            nitiStudenata[i].join();
        }

        System.out.println("Ispit je zavrsen.");
    }
}