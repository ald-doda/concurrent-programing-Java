package zadatak6;

public class ArrayThread implements Runnable{
	public volatile int array[];
	public volatile int start;
	public volatile int end;
	
	public ArrayThread(int array[], int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
	    for (int prolaz = 0; prolaz < end - start - 1; prolaz++) {
	        for (int j = start; j < end - 1 - prolaz; j++) {
	            if (array[j] > array[j + 1]) {
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }
	}
	
	
	

}
