package Entity;
//Due o più classi (es. Smartphone, Televisore) che estendono la classe prodotto e hanno altre caratteristiche.

public class Tv extends Prodotto {
	private Integer pollici;
	private Boolean hd;
	public Integer getPollici() {
		return pollici;
	}
	public void setPollici(Integer pollici) {
		this.pollici = pollici;
	}
	public Boolean getHd() {
		return hd;
	}
	public void setHd(Boolean hd) {
		this.hd = hd;
	}
	public Tv(Integer id, String nome, String descrizione, Double prezzo, Integer pollici, Boolean hd) {
		super(id, nome, descrizione, prezzo);
		this.pollici = pollici;
		this.hd = hd;
	}
	public Tv(Integer id, String nome, String descrizione, Double prezzo) {
		super(id, nome, descrizione, prezzo);
	}
	@Override
	public String toString() {
		return "Tv [pollici=" + pollici + ", hd=" + hd + "]";
	}

}
