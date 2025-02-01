import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


public class Main {

	public static void main(String[] args) {
		/*
		 *  Realizzare un progetto che simuli 
		 *  -un' agenzia di viaggi con le funzionalità volo e cancellazione volo 
		 *  -un insieme di compagnie aeree dove ognuna esporta i servizi di 
		 *  -prenotazione volo
		 *  -cancellazione volo
		 *  verso le agenzie
		 *  e verso gli aeroporti le funzioni di 
		 *  	-imbarco ( implica che i voli non sono piu' prenotabili)
		 *  	-decollo (ora del decollo di uno specifico aereo della compagnia dell'aeroporto che sta inserendp i dati di decollo)
		 *  	-atterraggio (ora di atterraggo di un aereo della compagnia dell'aeroporto che sta inserendo i dati di atterraggio)
		 *  NB: 
		 *  	.è sufficente una sola agenzia
		 *  	-le compagnie aeree hanno un menu particolare che gli consente di aggiungere e eliminare aerei ( numero di posti)
		 *  	Un esempio di sessione di lavoro la seguente:
		 *  		Menu per agenzia
		 *  			prenotazione
		 *  			disdetta
		 *  		Menu per aereoporto
		 *  			imbarco
		 *  			decollo
		 *  			atterraggio
		 *  		Menu per compagnia aerea
		 *  			crea aereo
		 *  			elimina aereo
		 *  ovviamente la compagnia aerea predispone una lista di voli(da,a,orario,nome aereo)
		 *  utilizzabile per le prenotazioni e per gli imbarchi, e i voli 
		 *  Abbiamo quindi N compagnie aeree e M aeroporti
		 *  Inoltre il menu prevede un comando di termine lavoro che salva su file 
		 *  la situazione globale del sistema (le compagnie aeree con gli aerei, e lo stato delle prenotazioni, 
		 *  decolli , atterraggio, i dati sono archiaviati in una lista associata ad ogni aeroporto)
		 */
		Aereo a1 = new Aereo("01", 20);
		Aereo a2 = new Aereo("02", 40);
		Aereo a3 = new Aereo("03", 15);
		Volo v1 = new Volo("Bari", "Bologna", LocalTime.of(20, 10), LocalTime.of(01, 58), true, true, a1);
		Volo v2 = new Volo("Bologna", "Roma", LocalTime.of(10, 50), LocalTime.of(15, 45), true, true, a2);
		Volo v3 = new Volo("Napoli", "Firenze", LocalTime.of(20, 10), LocalTime.of(13, 32), true, true, a3);
		Map<String, Volo> voli = new HashMap<>();
        voli.put("BA-BO123", v1);
        voli.put("RO-MI456", v2);
        voli.put("NA-FI123", v3);
		Compagnia c1 = new Compagnia("pippo", voli);
		Map<String, Compagnia> compagnie = new HashMap<>();
		compagnie.put("Fili", c1);
		Aereoporto l1 = new Aereoporto("Palese", compagnie);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(v1);
		System.out.println(l1);
		c1.prenota("BA-BO123", "Bari", 2);
		//System.out.println(l1);
		//System.out.print(a1.getPosti());
		Boolean[] postiDisponibili = a1.getPostiDisponibili();
		for (int i = 0; i < postiDisponibili.length; i++) {
		    System.out.println("Posto " + i + ": " + (postiDisponibili[i] ? "Disponibile" : "Occupato"));
		}
		c1.eliminaPrenota("BA-BO123", "Bari", 2);
		for (int i = 0; i < postiDisponibili.length; i++) {
		    System.out.println("Posto " + i + ": " + (postiDisponibili[i] ? "Disponibile" : "Occupato"));
		}
	}

}
