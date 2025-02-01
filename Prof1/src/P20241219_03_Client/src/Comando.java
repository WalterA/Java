import java.sql.Date;
import java.text.DateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Comando {
	Comandi cmd;
	//Ora devo trovare quel numero minimo di attributi che mi consentono di "coprire" tutti i comandi
//	registrazione di un nuovo impiegato (assegnazione di un badge)
//	ingresso/rientro del personale
//	uscita del personale (con motivazione: pranzo, appuntamento di lavoro, termine giornata, ecc)
//	sospensione/riattivazione del badge
//	stampa delle presenze mensili/giornaliere/settimanali
	
	//Per registrazione
	String nome;
	Integer badge;
	
	//Per ingresso/uscita/rientro
	//il badge (già dichiarato)
	String orario;  //poiché jackson non gestisce bene il tipo datetime!
	String motivo;  //Per quale motivo stai entrando o stai uscendo?
	
	//per sospensione/riattivazione del badge
	//il badge (già dichiarato)
	//orario: di sospensione/riattivazione (già dichiarato)
	
	//Per stampa
	String periodo; //mese, settimana, ...

	//E ora  implemento la conversione in stringa JSON e da string JSON a oggetto
	String toJSon() {
		//converte l'oggetto corrente in stringa JSON
		String s=null;
		ObjectMapper om = new ObjectMapper();
		try {
			s = om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
		}
		return s;
	}
	
	//da stringa a oggetto (in questo caso uso un metodo statico)
	static Comando FromJSon(String js) {
		ObjectMapper om = new ObjectMapper();
		Comando cmd=null;
		try {
		cmd = om.readValue(js, Comando.class);
		} catch (JsonProcessingException e) {
		}
		return cmd;
	}
	
	//poi faccio tutti i setter/getter/tostring ecc necessari
	public Comando() {
		super();
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Comandi getCmd() {
		return cmd;
	}

	public Comando(Comandi cmd, String nome, Integer badge, String orario, String motivo, String periodo) {
		super();
		this.cmd = cmd;
		this.nome = nome;
		this.badge = badge;
		this.orario = orario;
		this.motivo = motivo;
		this.periodo = periodo;
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
		return "Comando [cmd=" + cmd + ", nome=" + nome + ", badge=" + badge + ", orario=" + orario + ", motivo="
				+ motivo + ", periodo=" + periodo + "]";
	}
}
