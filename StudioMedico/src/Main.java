/*
 * 3) Gestione di uno Studio Medico

Nel metodo main:

Crea un'istanza della classe StudioMedico.
Crea alcuni Paziente e Medico, imposta i loro attributi e aggiungili alle liste dello studio medico.
Chiama i metodi per visualizzare tutte le informazioni sui pazienti e i medici.

 */

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Paziente> pazienti = new ArrayList<Paziente>();
        List<Medico> medici = new ArrayList<Medico>();
		StudioMedico studioMedico = new StudioMedico(pazienti, medici);
		Paziente paziente1 = new Paziente("Fabio", "Deluigi", "nonso", new ArrayList<String>());
		Paziente paziente2 = new Paziente("Fo", "Dei", "noo", new ArrayList<String>());
		paziente1.addPatologia("CUORE");
		paziente2.addPatologia("culo");
		paziente1.info();
		paziente2.info();
		Medico medico1 = new Medico("Don", "Abbondio", "666", "La morte");
		Medico medico2 = new Medico("Do", "Abo", "777", "La moe");
		studioMedico.addMedici(medico1);
		studioMedico.addMedici(medico2);
		studioMedico.addPaziente(paziente1);
		studioMedico.addPaziente(paziente2);
		studioMedico.MostraTuttiMedici();
		studioMedico.MostraTuttiPazienti();
		
		
		

	}

}
