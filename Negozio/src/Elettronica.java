/*
 * Per l'Elettronica, applicare uno sconto del 10% se il prezzo è superiore a
500 dollari.
 */
public class Elettronica extends Prodotto {

	public Elettronica(String name, Double price, String categorie) {
		super(name, price, categorie);
	}

	@Override
	public Double calculateDiscoint() {
		if (getPrice() >= 500) {
			Double priceScontato = getPrice()*0.10;
			Double sconto = getPrice() - priceScontato; 
			setPrice(sconto);
		}
		return getPrice();
	}

	@Override
	public String toString() {
		return "Elettronica [getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}
	
}
