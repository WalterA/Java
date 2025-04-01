package Entity;


public class Prodotto  {
	private Integer codice, quantita,sconto;
	private String descrizione;
	private Categoria categoria;
	private Boolean disponibilita;
	private Double prezzo;
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public Integer getSconto() {
		return sconto;
	}
	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Boolean getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(Boolean disponibilita) {
		this.disponibilita = disponibilita;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Prodotto(Integer codice, Integer quantita, Integer sconto, String descrizione, Categoria categoria,
			Boolean disponibilita, Double prezzo) {
		super();
		this.codice = codice;
		this.quantita = quantita;
		this.sconto = sconto;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.disponibilita = disponibilita;
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "Prodotto [codice=" + codice + ", quantita=" + quantita + ", sconto=" + sconto + ", descrizione="
				+ descrizione + ", categoria=" + categoria + ", disponibilita=" + disponibilita + ", prezzo=" + prezzo
				+ "]";
	}
	
}
