package zadatak5;

public class MaxThread implements Runnable{
	public volatile double[] array;
	public volatile int start;
	public volatile int end;
	public volatile double rezultat;
	
	
	public double returnMax() {
		return rezultat;
	}

	public MaxThread(double[] array, int start, int end) {
	    this.array = array;
	    this.start = start;
	    this.end = end;
	}

	@Override
	public void run() {
	    double maxBr = array[start];

	    for (int i = start + 1; i < end; i++) {
	        if (array[i] > maxBr) {
	            maxBr = array[i];
	        }
	    }

	    rezultat = maxBr;
	}
	

	}
