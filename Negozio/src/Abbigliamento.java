/*
 * Classi concrete (Elettronica e Abbigliamento)
• Creare due sottoclassi di Prodotto: Elettronica e Abbigliamento.
• Implementare il metodo calculateDiscount():
• Per l'Elettronica, applicare uno sconto del 10% se il prezzo è superiore a
500 dollari.
• Per l'Abbigliamento, applicare uno sconto del 15% se la categoria è
“Abbigliamento invernale”.
 */



public class Abbigliamento extends Prodotto {


	public Abbigliamento(String name, Double price, String categorie) {
		super(name, price, categorie);
		
	}



	@Override
	public String toString() {
		return "Abbigliamento [categoria=" + getCategorie() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ "]";
	}

	@Override
	public Double calculateDiscoint() {
		if("Abbigliamento invernale" == getCategorie()) {
			Double priceScontato = getPrice()*0.15;
			Double sconto = getPrice() - priceScontato; 
			setPrice(sconto);
		return getPrice();
	}
	return getPrice();
	

	
		
	}
}
