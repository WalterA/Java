
public class Main {

	public static void main(String[] args) {
		//
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		Mythread t3 = new Mythread();
		Mythread t4 = new Mythread();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		

	}

}
