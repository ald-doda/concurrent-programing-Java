package zad16;

public class Profesor implements Runnable {
    private final Student[] studenti;

    public Profesor(Student[] studenti) {
        this.studenti = studenti;
    }

    @Override
    public void run() {
        try {
            for (Student student : studenti) {
                Thread.sleep(300);
                student.primiPapir();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}