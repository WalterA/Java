/*
 * 
Crea una classe derivata Medico che estende Persona.

Aggiungi un attributo specializzazione (String).
Aggiungi un metodo mostraInfo() che visualizzi le informazioni del medico e la sua specializzazione.
 */
public class Medico extends Persona {
	private String specializzazione;

	@Override
	public String toString() {
		return "Medico [specializzazione=" + specializzazione + "]";
	}

	public Medico() {
		super();
	}

	public Medico(String nome, String cognome, String codiceFiscale, String specializzazione) {
		super(nome, cognome, codiceFiscale);
		this.specializzazione = specializzazione;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public void info() {
		System.out.println("I dati del medico sono: " + "\n Nome: " + getNome() + "\n Cognome; " + getCognome()
				+ "\n Codice Fiscale: " + getCodiceFiscale() + "Specializzazione: " + getSpecializzazione()+"\n");
	}

}
