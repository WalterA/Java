
/*
 * Classe Product Manager (ProductManager)
• Questa classe deve gestire l'elenco dei prodotti:
• Aggiungere prodotti a un elenco.
• Visualizzare tutti i prodotti con i relativi dettagli.
• Ordinare i prodotti per prezzo utilizzando il metodo sortByPrice (in
ordine crescente).
• Dimostrare l'ordinamento utilizzando Collections.sort() con un comparatore
personalizzato (Interface Comparable<...>).
 */
import java.util.*;

public class ProductManager implements Ordinabile {
	private List<Prodotto> prodotti = new ArrayList<>();

	public void addProdotto(Prodotto prodotto) {
		prodotti.add(prodotto);
		System.out.println("Prodotto aggiunto: " + prodotto.getName());
	}

	public void showAllProducts() {
		System.out.println("Elenco dei prodotti:");
		for (Prodotto prodotto : prodotti) {
			System.out.println("Nome: " + prodotto.getName() + ", Prezzo: $" + prodotto.getPrice());
		}
	}
	public List<Prodotto> getProdotti() {
	    return prodotti;
	}

	@Override
	public List<Prodotto> sortByPrice(List<Prodotto> prodotti) {
		prodotti.sort(Comparator.comparing(Prodotto::getPrice));
		return prodotti;
	}

}
