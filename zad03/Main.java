package zadatak3;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Generator g = new Generator(false);
		Tajmer t = new Tajmer(g);
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(t);

		long pocetak = System.currentTimeMillis();

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		long trajanje = System.currentTimeMillis() - pocetak;
		System.out.println("Bilo je potrebno " + trajanje + " ms.");
	}

}
