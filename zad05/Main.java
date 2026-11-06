package zadatak5;
import java.util.Random;
public class Main {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Random r = new Random();
		
		int n = 1_000_000;
		double[] niz = new double[n];
		for (int i = 0; i < n; i++) {
		    niz[i] = r.nextDouble(-1_000_000.0, 1_000_000.0);
		}
		MaxThread m1 = new MaxThread(niz, 0, n / 3);
		MaxThread m2 = new MaxThread(niz, n / 3, 2 * n / 3);
		MaxThread m3 = new MaxThread(niz, 2 * n / 3, n);

		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Prva: " + m1.returnMax());
		System.out.println("Druga: " + m2.returnMax());
		System.out.println("Treća: " + m3.returnMax());
		System.out.println("Prvi element niza: " + niz[0]);
		
		double mmax = Math.max(m1.returnMax(),  Math.max(m2.returnMax(), m3.returnMax()));
		System.out.println("Maksimalni element je " + mmax);
		

	}

}
