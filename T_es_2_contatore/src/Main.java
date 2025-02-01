
public class Main {

	public static void main(String[] args) {
		Contatore run1 = new Contatore();
	
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run1);
		t1.start();
		t2.start();

	}

}
