package Entity;
//Una classe Prodotto con ID del prodotto, nome, descrizione, prezzo e lista dei negozi che lo vendono.

import java.util.ArrayList;
import java.util.List;

public class Prodotto {
	private Integer id;
	private String nome , descrizione;
	private Double prezzo;
	private List<Negozio> negozzi = new ArrayList<Negozio>();
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Prodotto [negozzi=" + negozzi + "]";
	}
	public List<Negozio> getNegozzi() {
		return negozzi;
	}
	public void setNegozzi(List<Negozio> negozzi) {
		this.negozzi = negozzi;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Prodotto(Integer id, String nome, String descrizione, Double prezzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
}
