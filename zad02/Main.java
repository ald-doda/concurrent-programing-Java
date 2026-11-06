package zadatak2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Brojac b1 = new Brojac();
		Thread t1 = new Thread(b1);
		try {
			t1.start();
			Thread.sleep(5000);
			b1.flag = true;
			t1.join();
			System.out.println("Brojac je izbrojao " + b1.i);
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
