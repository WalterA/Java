
public class TH implements Runnable {
	
	@Override
	    public void run() {
	        try {
	            Thread.State statothread = Thread.currentThread().getState();
	            System.out.println("Stato del thread : "+ statothread);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}

