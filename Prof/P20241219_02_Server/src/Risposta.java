import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Risposta {
	//una risposta, per semplicità, conterrà una parte relativa all'esito (OK oppure KO)
	//e una parte relativa ai dati ottenuti (un messaggio)
	private String esito;
	private String messaggio;

	//E ora  implemento la conversione in stringa JSON e da string JSON a oggetto
	String toJSon() {
		//converte l'oggetto corrente in stringa JSON
		String s=null;
		ObjectMapper om = new ObjectMapper();
		try {
			s = om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	//da stringa a oggetto (in questo caso uso un metodo statico)
	static Risposta FromJSon(String js) {
		ObjectMapper om = new ObjectMapper();
		Risposta cmd = null;
		try {
			cmd = om.readValue(js, Risposta.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cmd;
	}

	public Risposta(String esito, String messaggio) {
		super();
		this.esito = esito;
		this.messaggio = messaggio;
	}

	public Risposta() {
		super();
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	@Override
	public String toString() {
		return "Risposta [esito=" + esito + ", messaggio=" + messaggio + "]";
	}
	
}
