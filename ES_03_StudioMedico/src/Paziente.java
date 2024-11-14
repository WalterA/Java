/*
 * Crea una classe derivata Paziente che estende Persona.

Aggiungi un attributo patologie (lista di stringhe) per memorizzare le patologie del paziente.
Aggiungi metodi per aggiungere e rimuovere patologie dalla lista.
Aggiungi un metodo mostraInfo() che visualizzi le informazioni del paziente e le patologie.
 */

import java.util.ArrayList;
import java.util.List;

public class Paziente extends Persona {
	List<String> patologie;

	public Paziente(String nome, String cognome, String codiceFiscale, List<String> patologie) {
		super(nome, cognome, codiceFiscale);
		this.patologie = new ArrayList<String>();
	}

	public void addPatologia(String patologia) {
		patologie.add(patologia);
	}

	public void rimuoviPatologia(String patologia) {
		if (patologie.remove(patologia)) {
			System.out.println("Patologia rimossa.");
		} else {
			System.out.println("Patologia non trovata.");
		}
	}

	public void info() {
		System.out.println("I dati del paziente sono: " + "\n Nome: " + getNome() + "\n Cognome; " + getCognome()
				+ "\n Codice Fiscale: " + getCodiceFiscale());
		System.out.println("Le sue patologie sono: ");
		for (String patologia : patologie) {
			System.out.println("-"+patologia+"\n");
		}

	}

}
