/*
 * Domanda 1
Simulare un negozio che vende prodotti elettronici.

Creare le seguenti classi:

Una classe Prodotto con ID del prodotto, nome, descrizione, prezzo e lista dei negozi che lo vendono.
Due o più classi (es. Smartphone, Televisore) che estendono la classe prodotto e hanno altre caratteristiche.
Una classe Cliente con ID del cliente, nome, cognome, e-mail, password etc.
Una classe di test in cui uno o due clienti registrano il proprio nome 
e acquistano  uno o più prodotti. Stampare la lista dei prodotti acquistati.

 */

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Negozio negozio1 = new Negozio("Tech Store");
        Negozio negozio2 = new Negozio("Elettronica Plus");

        // Creazione di prodotti
        Smartphone smartphone = new Smartphone(1, "na", "fa", 5445.25f, 152.25f, 2545.55f);
        Televisore televisore = new Televisore(1, "da", "sda", 145.25f, true);

        // Assegnazione negozi ai prodotti
        smartphone.aggiungiNegozio(negozio1);
        televisore.aggiungiNegozio(negozio2);

        // Creazione di clienti
        Cliente cliente1 = new Cliente(1, "ew", "as", "sadsa", "sadsa");
        Cliente cliente2 = new Cliente(102, "Luisa", "Bianchi", "luisa.bianchi@example.com", "securepass");
        
        // Acquisti
        cliente1.aggiungi(smartphone);
        cliente2.aggiungi(televisore);
        cliente2.aggiungi(smartphone);

        // Mostrare carrello dei clienti
        cliente1.mostraCarrello();
        cliente2.mostraCarrello();
        cliente1.salvaInFile();
        cliente2.salvaInFile();
	}

}
