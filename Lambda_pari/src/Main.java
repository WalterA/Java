
public class Main {

	public static void main(String[] args) {
		Pari p = a -> a % 2 == 0;
		Integer a = 2;
		Boolean r = p.verifica(a);
		System.out.println(r);
		

	}

}
