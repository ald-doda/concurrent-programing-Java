package zadatak4;
import java.math.*;
public class Sinus implements Runnable {
    private final double ugao;
    private double rezultat;

    public Sinus(double ugao) {
        this.ugao = ugao;
    }

    @Override
    public void run() {
        rezultat = Math.sin(Math.toRadians(ugao));
    }

    public double getRezultat() {
        return rezultat;
    }
}