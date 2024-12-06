import java.util.Random;

public class Main {

	public static final String RESET = "\u001B[0m";

	public static final String BLINK = "\u001B[5m";

	public static final String BLACK = "\u001B[30m";

	public static final String RED = "\u001B[31m";

	public static final String GREEN = "\u001B[32m";

	public static final String YELLOW = "\u001B[33m";

	public static final String BLUE = "\u001B[34m";

	public static final String PURPLE = "\u001B[35m";

	public static final String CYAN = "\u001B[36m";

	public static final String WHITE = "\u001B[37m";

	public static String[] colori = { BLACK, BLACK, BLACK, BLACK, BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN };

	public static final String CMD = "\u001B[";

	public static void Clear() {

		System.out.print(CMD + "2J");

	}

	public static void Goto(int x, int y) {

		System.out.print(CMD + x + ";" + y + "H");

	}

	final public static int righe = 30;

	final public static int colonne = 21;

	public static void Show(String[][] area) {

		Random rng = new Random();

		for (int r = 0; r < righe; r++) {

			System.out.print(" ");

			for (int c = 0; c < colonne; c++) {

				if (!area[r][c].equals(" ") && r < (righe * 3 / 4)) {

					System.out.print(colori[rng.nextInt(0, colori.length)] + area[r][c] + RESET);

				} else {

					System.out.print(area[r][c]);

				}

			}

			System.out.println();

		}

	}

	public static void main(String[] args) throws InterruptedException {

		// Faccio una matrice 30 righe * 21 colonne e ci disegno l'albero

		String[][] area = new String[30][21];

		for (int r = 0; r < righe; r++) {

			for (int c = 0; c < colonne; c++) {

				area[r][c] = " ";

			}

		}

		int middle = 10;

		int size = 2;

		for (int r = 0; r < (righe * 3 / 4); r++) {

			for (int c = middle - size / 2 + 1; c < (middle + size / 2); c++) {

				area[r][c] = "XX";

			}

			size++;

		}

		// ed ora la base

		size = 4;

		for (int r = (righe * 3 / 4); r < righe; r++) {

			for (int c = middle - size / 2 + 1; c < (middle + size / 2); c++) {

				area[r][c] = "||";

			}

			size++;

		}

		while (true) {

			Clear();

			Show(area);

			Thread.sleep(1000L);

		}

	}

}