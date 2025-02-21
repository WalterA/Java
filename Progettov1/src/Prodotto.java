//Una classe Prodotto con ID del prodotto, nome, descrizione, prezzo e lista dei negozi che lo vendono.

import java.util.ArrayList;
import java.util.List;

public class Prodotto<Negozio> {
	private Integer id;
	private String nome, descrizione;
	private Float prezzo;

	public Integer getId() {
		return id;
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

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public List<Negozio> getNegozi() {
		return negozi;
	}

	public Prodotto(Integer id, String nome, String descrizione, Float prezzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.negozi = new ArrayList<>();
	}

	public void setNegozi(List<Negozio> negozi) {
		this.negozi = negozi;
	}

	private List<Negozio> negozi;

	public void aggiungiNegozio(Negozio negozio) {
		negozi.add(negozio);
	}
}
