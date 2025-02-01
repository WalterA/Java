
public class Contatore implements Runnable {
	private int conta=0;
	@Override
	public void run() {
		//Creare una classe che implementa Runnable con un contatore da 1 a 5 e lanciare due thred concorrenti
		for (int i=0; i<6; i++) {
			conta++;
			System.out.println(conta);
			
			
		}
	}

}
