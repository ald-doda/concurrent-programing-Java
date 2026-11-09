package zad07;

public class SkalarniProizvod implements Runnable {
	public volatile int redovi[];
	public volatile int kolone[];
	private int result;
	

	public SkalarniProizvod(int []a, int[] b) {
	    this.redovi = a;
	    this.kolone = b;
	}
	
	@Override
	public void run() {
		
		result = 0;
		for (int i = 0; i < redovi.length; i++) {
		    result += redovi[i] * kolone[i];
		}
		try {
			Thread.sleep(300);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Rezultat je: " + result);
	}
	
	public int getResult() {
		return result;
	}

}
