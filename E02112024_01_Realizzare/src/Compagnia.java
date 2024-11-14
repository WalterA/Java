import java.util.ArrayList;
//Definire una classe Compagnia che gestisce N aerei, con N dinamico nel senso che non si conosce a priori ma ogni tanto viene aggiunto un nuovo aereo
class Compagnia {
	private String nome;
	private ArrayList<Aereo> aerei;

	public Compagnia(String nome) {
		this.nome = nome;
		this.aerei = new ArrayList<>();
	}

	public void aggiungiAereo(Aereo aereo) {
		aerei.add(aereo);
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Aereo> getAerei() {
		return aerei;
	}

	public void stampaDettagliAerei() {
		System.out.println("Compagnia " + nome + ":");
		for (int i = 0; i < aerei.size(); i++) {
			System.out.print("Aereo " + (i + 1) + ": ");
			aerei.get(i).stampaPosti();
			System.out.println("Posti disponibili: " + aerei.get(i).getPostiDisponibili());
		}
	}
}
