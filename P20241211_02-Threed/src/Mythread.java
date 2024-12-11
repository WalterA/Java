import java.util.concurrent.locks.ReentrantLock;

public class Mythread extends Thread {
	static public long num=0;
	static public ReentrantLock mtx = new ReentrantLock();
	
	public static synchronized void SoloIo() {
		System.out.println("Ciao");
		System.out.println("Come");
		System.out.println("Va");
		for (int i=0; i <10;i++) {
			System.out.println(i);
		}
		System.out.println("====================FINE===");
	}
	public void run() {
		
		System.out.println("Ciao");
		System.out.println("Come");
		System.out.println("Va");
		for (int i=0; i <10;i++) {
			System.out.println(i);
		}
		System.out.println("====================FINE===============");
		
	}
	
//	public void run() {
//		mtx.lock();
//		System.out.println("Ciao");
//		System.out.println("Come");
//		System.out.println("Va");
//		for (int i=0; i <10;i++) {
//			System.out.println(i);
//		}
//		System.out.println("====================FINE===============");
//		mtx.unlock();
//	}
	
}
