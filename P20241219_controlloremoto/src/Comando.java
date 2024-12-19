//Questa è la classe Comando.java

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Comando {
	Comandi cmd;
	// Ora devo trovare quel numero minimo di attributi che mi consentono di
	// "coprire" tutti i comandi
// registrazione di un nuovo impiegato (assegnazione di un badge)
// ingresso/rientro del personale
// uscita del personale (con motivazione: pranzo, appuntamento di lavoro, termine giornata, ecc)
// sospensione/riattivazione del badge
// stampa delle presenze mensili/giornaliere/settimanali

	// Per registrazione
	String nome;
	Integer badge;

	// Per ingresso/uscita/rientro
	// il badge (già dichiarato)
	String orario;

	// per sospensione/riattivazione del badge
	// il badge (già dichiarato)
	// orario: di spsensione/riattivazione (già dichiarato)

	// Per stampa
	String periodo; // mese, settimana, ...

	// E ora implemento la conversione in stringa JSON e da string JSON a oggetto
	String toJSon() throws JsonProcessingException {
		// converte l'oggetto corrente in stringa JSON
		String s;
		ObjectMapper om = new ObjectMapper();
		s = om.writeValueAsString(this);
		return s;
	}

	// da stringa a oggetto (in questo caso uso un metodo statico)
	static Comando FromJSon(String js) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		Comando cmd = om.readValue(js, Comando.class);
		return cmd;
	}

	// poi faccio tutti i setter/getter/tostring ecc necessari
	public Comando(Comandi cmd, String nome, Integer badge, String orario, String periodo) {
		super();
		this.cmd = cmd;
		this.nome = nome;
		this.badge = badge;
		this.orario = orario;
		this.periodo = periodo;
	}

	public Comando() {
		super();
	}

	public Comandi getCmd() {
		return cmd;
	}

	public void setCmd(Comandi cmd) {
		this.cmd = cmd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getBadge() {
		return badge;
	}

	public void setBadge(Integer badge) {
		this.badge = badge;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "Comando [cmd=" + cmd + ", nome=" + nome + ", badge=" + badge + ", orario=" + orario + ", periodo="
				+ periodo + "]";
	}

}

//Questo è un file a sé stante (Comandi.java)


//Infine, queste due classi vi servono per costruire il comando e convertirlo in json oppure per convertire un Json in un comando
//la logica di esecuione dei comandi va implementata nel server