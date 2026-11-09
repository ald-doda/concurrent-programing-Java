package zad12;

public class B implements Runnable {
	A a;
	
	public B(A a) {
		this.a = a;
	}
	@Override
	public void run() {
		synchronized (a) {
		    while (!a.redNaB) {
		        try {
					a.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

		    System.out.println("B prva poruka");
		    System.out.println("B druga poruka");

		    a.redNaB = false;
		    a.notifyAll();
		}
		
	}

}
