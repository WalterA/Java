/*
 *  Classe astratta (Prodotto)
• Creare una classe astratta Prodotto con le seguenti proprietà:
• String name
• Double price
• String categoria
• Definire un metodo astratto Double calculateDiscount() che sarà
implementato nelle sottoclassi.
• Fornire un metodo toString() per visualizzare i dettagli del prodotto.
 */
public abstract class Prodotto {
	private String name;
	private Double price;
	private String categorie;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Prodotto(String name, Double price, String categorie) {
		super();
		this.name = name;
		this.price = price;
		this.categorie = categorie;
	}

	public Prodotto() {
		super();
	}

	@Override
	public String toString() {
		return "Prodotto [name=" + name + ", price=" + price + ", categorie=" + categorie + "]";
	}
	public abstract Double calculateDiscoint();

	public Double calculateDiscount() {
		// TODO Auto-generated method stub
		return null;
	}
}
