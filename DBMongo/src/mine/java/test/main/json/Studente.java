package mine.java.test.main.json;

import java.io.Serializable;
import java.util.Objects;

public class Studente implements Serializable{
	protected int id, matricola;
    protected String nome,cognome;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(cognome, id, matricola, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(cognome, other.cognome) && id == other.id && matricola == other.matricola
				&& Objects.equals(nome, other.nome);
	}
	public Studente() {
	}
	public Studente(int id, int matricola, String nome, String cognome) {
		this.id = id;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

}
