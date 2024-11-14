
public class Main {

	public static void Hanoi(int n, String p1, String p2, String p3) {
		// Si parte con n dischi sul paletto p1
		// La soluzione è spostare tutto sul paletto p2
		if (n <= 0) {
			System.out.println("Il problema richiede un numero di dischi almeno pari a 1");
			return;
		}
		if (n == 1) {
			System.out.printf("Sposta da %s a %s\n", p1, p2);
			return;
		}
		if (n == 2) {
			System.out.printf("Sposta da %s a %s\n", p1, p3);
			Hanoi(n - 1, p1, p2, p3);
			Hanoi(n - 1, p3, p2, p1);
			return;
		}
		// Negli altri casi
		if (n % 2 == 1) {
			Hanoi(n - 1, p1, p3, p2);
			System.out.printf("Sposta da %s a %s\n", p1, p2);
			Hanoi(n - 1, p3, p2, p1);
		} else {
			Hanoi(n - 1, p1, p2, p3);
			System.out.printf("Sposta da %s a %s\n", p1, p2);
			Hanoi(n - 1, p2, p3, p1);
		}

	}

}
