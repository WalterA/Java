
public class Persona {
	private String nome;
	private String codicefiscale;
	private int eta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public Persona(String nome, String codicefiscale, int eta) {
		super();
		this.nome = nome;
		this.codicefiscale = codicefiscale;
		this.eta = eta;
	}

	public Persona() {
		super();
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", codicefiscale=" + codicefiscale + ", eta=" + eta + "]";
	}

}
