/*
 * 
Crea una classe StudioMedico per gestire pazienti e medici.

Crea due liste: una lista di Paziente e una lista di Medico.
Aggiungi metodi aggiungiPaziente(Paziente p) e aggiungiMedico(Medico m) per aggiungere pazienti e medici alle rispettive liste.
Aggiungi un metodo mostraTuttiIPazienti() per visualizzare le informazioni di tutti i pazienti.
Aggiungi un metodo mostraTuttiIMedici() per visualizzare le informazioni di tutti i medici.
 */

import java.util.ArrayList;
import java.util.List;

public class StudioMedico {
	List<Paziente> pazienti;
	List<Medico> medici;

	public StudioMedico(List<Paziente> pazienti, List<Medico> medici) {
		super();
		this.pazienti = new ArrayList<Paziente>();
		this.medici = new ArrayList<Medico>();
	}

	@Override
	public String toString() {
		return "StudioMedico [pazienti=" + pazienti + ", medici=" + medici + "]";
	}

	public void addPaziente(Paziente paziente) {
		pazienti.add(paziente);
	}

	public void addMedici(Medico medico) {
		medici.add(medico);

	}

	public void MostraTuttiPazienti() {
		for (var pazienti : pazienti) {
			System.out.println("\n-" + pazienti+"\n");
		}
	}

	public void MostraTuttiMedici() {
		for (var medico : medici) {
			System.out.println("\n-" + medico+"\n");
		}

	}
}
