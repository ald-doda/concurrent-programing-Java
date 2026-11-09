package zad08;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Racun ra = new Racun();
		
		Clan c1 = new Clan("Ana", ra);
		Clan c2 = new Clan("Mina", ra);
		Clan c3 = new Clan("Ina", ra);
		Clan c4 = new Clan("Lina", ra);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
