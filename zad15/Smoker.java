package zad15;

public class Smoker implements Runnable{
	private final int id;
	private final Items item; //stvar
	private final Agent agent;
	public boolean canSmoke = false;
	
	public Smoker(int id, Items item, Agent agent) {
		this.id = id;
		this.item = item;
		this.agent = agent;
	}
	
	@Override
	public void run() {
	    try {
	        while (true) {
	            synchronized (agent) {
	                while (!canSmoke) {
	                    agent.wait();
	                }
	            }

	            System.out.println("Pusac " + id
	                    + " ima " + item + " i sada pusi...");
	            Thread.sleep(1000);

	            synchronized (agent) {
	                canSmoke = false;
	                agent.notifyAll();
	            }
	        }
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}
}
