package zad09;

public class Student implements Runnable {
	private String ime;
	Kuhinja k;
	
	public Student(String i, Kuhinja k) {
		this.ime = i;
		this.k = k;
	}
	
	@Override
	public void run() {
		System.out.println("Student " + ime + " uci...");
		try {
			Thread.sleep(300);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		try {
			k.udji(ime);
			Thread.sleep(250);
			k.izadji();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Student " + ime + " jede...");
		try {
			Thread.sleep(270);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Student " + ime + " spava...");
		try {
			Thread.sleep(210);
		} catch(InterruptedException e ) {
			e.printStackTrace();
		}
	}

}
