package zadatak4;

public class Strane implements Runnable{
	    private final double a, b;
	    private double rezultat;

	    public Strane(double a, double b) {
	        this.a = a;
	        this.b = b;
	    }

	    @Override
	    public void run() {
	        rezultat = a*b;
	    }

	    public double getRezultat() {
	        return rezultat;
	    }


}
