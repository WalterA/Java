
public class Main {

	public static void main(String[] args) {
		Calcolatore c = (a, b) -> a + b;
		Integer somma = c.calcola(5, 8);
		System.out.println(somma);

	}
}