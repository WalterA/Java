/*
 * A. Creare un sistema di gestione dei prodotti per un negozio al dettaglio online. Il sistema deve
consentire agli utenti di aggiungere, visualizzare e ordinare i prodotti utilizzando classi astratte,
interfacce e raccolte (elenchi). Inoltre, deve dimostrare la funzionalità di ordinamento.
Requisiti:
1. Classe astratta (Prodotto)
• Creare una classe astratta Prodotto con le seguenti proprietà:
• String name
• Double price
• String categoria
• Definire un metodo astratto Double calculateDiscount() che sarà
implementato nelle sottoclassi.
• Fornire un metodo toString() per visualizzare i dettagli del prodotto.
 */
public class Main {

	public static void main(String[] args) {
		Abbigliamento a1= new Abbigliamento("b", 1.50, "Abbigliamento invernale");
		Abbigliamento a2= new Abbigliamento("a", 8.50, "Abbigliamento invernale");
		Abbigliamento a3= new Abbigliamento("c", 9.50, "Abbigliamento invernale");
		Elettronica e1 = new Elettronica("a", 2.50, "ele");
		Elettronica e2 = new Elettronica("b", 1.50, "ele");
		Elettronica e3 = new Elettronica("c", 5.50, "ele");
		ProductManager p1 = new ProductManager();
		p1.addProdotto(a1);
		p1.addProdotto(a2);
		p1.addProdotto(a3);
		p1.addProdotto(e1);
		p1.addProdotto(e2);
		p1.addProdotto(e3);
		System.out.println("Elenco casuale senza sconto");
		p1.showAllProducts();
		p1.sortByPrice(p1.getProdotti());
		a1.calculateDiscoint();
		a2.calculateDiscoint();
		a2.calculateDiscoint();
		e1.calculateDiscoint();
		e2.calculateDiscoint();
		e3.calculateDiscoint();
		
		System.out.println("\nProdotti dopo l'ordinamento con sconto:");
        p1.showAllProducts();

	}

}
