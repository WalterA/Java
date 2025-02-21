import java.util.List;

public class Televisore extends Prodotto {
	private Boolean hd ;

	
	public Televisore(Integer id, String nome, String descrizione, Float prezzo, Boolean hd) {
		super(id, nome, descrizione, prezzo);
		this.hd = hd;
	}

	public Boolean getHd() {
		return hd;
	}

	public void setHd(Boolean hd) {
		this.hd = hd;
	}
}
