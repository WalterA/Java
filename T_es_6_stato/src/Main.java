
public class Main {

	public static void main(String[] args) {
		TH t1 = new TH();

		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t1);
		th1.start();
		th2.start();
	}

}
