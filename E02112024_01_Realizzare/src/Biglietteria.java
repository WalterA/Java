//Definire una classe Biglietteria che gestisce due Compagnie e che consente di prenotare i posti su un aereo
class Biglietteria {
	private Compagnia compagnia1;
	private Compagnia compagnia2;

	public Biglietteria(Compagnia compagnia1, Compagnia compagnia2) {
		this.compagnia1 = compagnia1;
		this.compagnia2 = compagnia2;
	}

	public boolean prenotaPosto(int numeroCompagnia, int numeroAereo, int numeroPosto) {
		Compagnia compagnia = numeroCompagnia == 1 ? compagnia1 : compagnia2;
		if (compagnia == null || numeroAereo < 1 || numeroAereo > compagnia.getAerei().size()) {
			return false;
		}
		Aereo aereo = compagnia.getAerei().get(numeroAereo - 1);
		return aereo.prenotaPosto(numeroPosto);
	}

	public void stampaDettagliCompagnie() {
		compagnia1.stampaDettagliAerei();
		compagnia2.stampaDettagliAerei();
	}
}