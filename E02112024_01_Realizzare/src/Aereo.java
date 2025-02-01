
class Aereo {
	private boolean[] posti;

	public Aereo(int numeroPosti) {
		posti = new boolean[numeroPosti];
	}

	public boolean prenotaPosto(int numeroPosto) {
		if (numeroPosto < 0 || numeroPosto >= posti.length || posti[numeroPosto]) {
			return false; // Posto non disponibile o fuori limite
		}
		posti[numeroPosto] = true;
		return true;
	}

	public int getPostiDisponibili() {
		int count = 0;
		for (boolean posto : posti) {
			if (!posto) {
				count++;
			}
		}
		return count;
	}

	public void stampaPosti() {
		System.out.print("Posti: ");
		for (int i = 0; i < posti.length; i++) {
			System.out.print((posti[i] ? "[X]" : "[ ]") + " ");
		}
		System.out.println();
	}
}
