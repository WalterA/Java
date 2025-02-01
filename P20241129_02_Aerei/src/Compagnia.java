import java.util.Map;

public class Compagnia {

	private String nome;
	private Map<String, Volo> voli;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Volo> getVoli() {
		return voli;
	}

	public void setVoli(Map<String, Volo> voli) {
		this.voli = voli;
	}

	public Compagnia(String nome, Map<String, Volo> voli) {
		super();
		this.nome = nome;
		this.voli = voli;
	}

	public Compagnia() {
		super();
	}

	@Override
	public String toString() {
		return "Compagnia [nome=" + nome + ", voli=" + voli + "]";
	}
	public boolean prenota(String codiceVolo, String luogo, Integer posto) {
	    Volo volo = voli.get(codiceVolo);
	    if (volo == null) {
	        System.out.println("Volo con codice " + codiceVolo + " non trovato.");
	        return false;
	    }
	    Aereo a = volo.getAereo();
	    if (posto >= a.getPostiDisponibili().length || !a.getPostiDisponibili()[posto]) {
	        System.out.println("Posto " + posto + " non disponibile o già prenotato.");
	        return false;
	    } else {
	        a.getPostiDisponibili()[posto] = false;
	        System.out.println("Posto " + posto + " prenotato con successo sul volo " + codiceVolo + ".");
	        return true;
	    }
	}


	public boolean eliminaPrenota(String codiceVolo, String luogo, Integer posto) {
	    Volo volo = voli.get(codiceVolo);
	    if (volo == null) {
	        System.out.println("Volo con codice " + codiceVolo + " non trovato.");
	        return false;
	    }
	    Aereo a = volo.getAereo();
	    if (posto >= a.getPostiDisponibili().length || a.getPostiDisponibili()[posto]) {
	        System.out.println("Posto " + posto + " non è stato prenotato o non esiste.");
	        return false;
	    } else {
	        a.getPostiDisponibili()[posto] = true;
	        System.out.println("Prenotazione del posto " + posto + " sul volo " + codiceVolo + " cancellata con successo.");
	        return true;
	    }
	}

}
