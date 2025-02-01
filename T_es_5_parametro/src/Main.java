
public class Main {

	public static void main(String[] args) {
		Thr t1 = new Thr('A');
		Thr t2 = new Thr ('B');
		t1.start();
		t2.start();

	}

}
