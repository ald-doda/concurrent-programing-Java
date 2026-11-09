package zad12;

public class A implements Runnable{
	public boolean redNaB = false;
	
	@Override
	public synchronized void run() {
		
		synchronized (this) {
		    System.out.println("A prva poruka");
		    redNaB = true;
		    notifyAll();

		    while (redNaB) {
		        try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

		    System.out.println("A druga poruka");
		}
	}
	public boolean getFlag() {
		return redNaB;
	}
	public void setFlag(boolean z) {
		this.redNaB = z;
	}

}
