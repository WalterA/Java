
public class Main {

	public static void main(String[] args) {
		TH1 t1= new TH1();
		t1.start();
		
		 Runnable runnableExample = new Runnable();
		 Thread t2 = new Thread(runnableExample);

	        t2.start();
	}

}
