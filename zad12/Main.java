package zad12;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B(a);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	

	}

}
