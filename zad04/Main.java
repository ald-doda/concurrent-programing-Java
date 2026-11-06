package zadatak4;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Strane s = new Strane(6, 8);
		Sinus s1 = new Sinus(30);
		
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s1);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2. join();
		double povrsina = 0.5 * s.getRezultat() * s1.getRezultat();
		System.out.println("Povrsina je " + povrsina + ".");
		
		

	}

}
