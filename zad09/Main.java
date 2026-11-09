package zad09;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Kuhinja k = new Kuhinja();
				
				Student s1 = new Student("Marko", k);
				Student s2 = new Student("Darko", k);
				Student s3 = new Student("Karlo", k);
				
				Thread t1 = new Thread(s1);
				Thread t2 = new Thread(s2);
				Thread t3 = new Thread(s3);
				
				t1.start();
				t2.start();
				t3.start();
				
				try {
					t1.join();
					t2.join();
					t3.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}

	}

}
