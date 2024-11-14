/*
 * Crea una superclasse Persona con attributi di base:

nome (String)
cognome (String)
codiceFiscale (String)
 */
public class Persona {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + "]";
	}
	public Persona() {
		super();
	}
	public Persona(String nome, String cognome, String codiceFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}
}
