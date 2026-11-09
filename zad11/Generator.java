package zad11;
import java.util.Random;

public class Generator implements Runnable{
	Random r = new Random();
	private final int[] niz;
	
	public Generator(int niz[]){
		this.niz = niz;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1_000_000; i++) {
			niz[i] = r.nextInt(1, 1000);
		}
		try {
			Thread.sleep(300);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Brojevi su generisani...");
	}
	public int[] getNiz() {
		return niz;
	}
}
