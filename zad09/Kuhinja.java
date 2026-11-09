package zad09;

public class Kuhinja {
	public volatile boolean slobodna = true;
	
	
	public synchronized void udji(String ime) throws InterruptedException{
		while(!slobodna) {
			System.out.println("Student " + ime + " ceka na red za kuhinju...");
			wait();
			}
		slobodna = false;
		System.out.println("Student " + ime + " je usao u kuhinju i priprema obrok...");
		
	}
	public synchronized void izadji() throws InterruptedException {
		slobodna = true;
		System.out.println("Student je izasao iz kuhinje i ona je slobodna....");
	    notifyAll();
	}

}
