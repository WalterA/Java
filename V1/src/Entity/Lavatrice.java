package Entity;
//Due o più classi (es. Smartphone, Televisore) che estendono la classe prodotto e hanno altre caratteristiche.

public class Lavatrice extends Prodotto {
	private Integer capienza;

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public Lavatrice(Integer id, String nome, String descrizione, Double prezzo, Integer capienza) {
		super(id, nome, descrizione, prezzo);
		this.capienza = capienza;
	}

}
