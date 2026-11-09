package zad10;

public class Bafer {
	private final int[] proizvodi;
	private final int[] preostalo;
	private final int[] citanje;
	private int upis = 0;
	
	public Bafer(int kapacitet, int brojPotrosaca) {
        proizvodi = new int[kapacitet];
        preostalo = new int[kapacitet];
        citanje = new int[brojPotrosaca];
    }
	
	public synchronized void stavi(int proizvod)
	        throws InterruptedException {

	    int mjesto = upis % proizvodi.length;

	    while (preostalo[mjesto] != 0) {
	        wait();
	    }

	    proizvodi[mjesto] = proizvod;
	    preostalo[mjesto] = citanje.length;

	    System.out.println("Proizvodjac je stavio proizvod " + proizvod);

	    upis++;
	    notifyAll();
	}
	
	public synchronized int uzmi(int id)
	        throws InterruptedException {

	    while (citanje[id] == upis) {
	        wait();
	    }

	    int mjesto = citanje[id] % proizvodi.length;
	    int proizvod = proizvodi[mjesto];

	    citanje[id]++;
	    preostalo[mjesto]--;

	    System.out.println("Potrosac " + id
	            + " je preuzeo proizvod " + proizvod);

	    notifyAll();
	    return proizvod;
	}

}
