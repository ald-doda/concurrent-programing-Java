package zad11;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int[] niz = new int[1_000_000];

		Generator g = new Generator(niz);
		Brojac b = new Brojac(g);

		Thread t1 = new Thread(g);
		Thread t2 = new Thread(b);

		t1.start();
		t1.join();  // Niz je potpuno popunjen prije brojanja.

		t2.start();
		t2.join();

		System.out.println("Broj savrsenih je: " + b.getBr());
		

	}

}
