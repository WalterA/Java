//Due o più classi (es. Smartphone, Televisore) che estendono la classe prodotto e hanno altre caratteristiche.

import java.util.List;

public class Smartphone extends Prodotto {
	private Float pollici, pixel;

	public Float getPollici() {
		return pollici;
	}

	public void setPollici(Float pollici) {
		this.pollici = pollici;
	}

	public Float getPixel() {
		return pixel;
	}

	public void setPixel(Float pixel) {
		this.pixel = pixel;
	}

	public Smartphone(Integer id, String nome, String descrizione, Float prezzo, Float pollici,
			Float pixel) {
		super(id, nome, descrizione, prezzo);
		this.pollici = pollici;
		this.pixel = pixel;
	}

	

}
