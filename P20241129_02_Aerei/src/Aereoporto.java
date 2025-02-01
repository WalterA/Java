import java.util.Map;

public class Aereoporto {
	private String nome;
	private Map<String, Compagnia> compagnie;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Compagnia> getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Map<String, Compagnia> compagnie) {
		this.compagnie = compagnie;
	}

	public Aereoporto(String nome, Map<String, Compagnia> compagnie) {
		super();
		this.nome = nome;
		this.compagnie = compagnie;
	}

	public Aereoporto() {
		super();
	}

	@Override
	public String toString() {
		return "Aereoporto [nome=" + nome + ", compagnie=" + compagnie + "]";
	}
	public	Boolean imbarco(String codiceVolo, String luogo, Integer posto, Compagnia c1) {
		Map<String, Volo> volo = c1.getVoli();
		Volo vo = volo.get(codiceVolo);
	    if (vo == null) {
	        System.out.println("Volo con codice " + codiceVolo + " non trovato.");
	        return false;
	    }
	    Aereo a = volo.get;
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
	/*
	 * crea oggetto aeroporto con nome di aeroporto , oggetto aereo e verso gli
	 * aeroporti le funzioni di -imbarco ( implica che i voli non sono piu'
	 * prenotabili) -decollo (ora del decollo di uno specifico aereo della compagnia
	 * dell'aeroporto che sta inserendp i dati di decollo) -atterraggio (ora di
	 * atterraggo di un aereo della compagnia dell'aeroporto che sta inserendo i
	 * dati di atterraggio)
	 * 
	 * 
	 * imbarco (implica che i voli non sono più prenotabili) - decollo (ora del
	 * decollo di uno specifico aereo della compagnia dall'aeroporto che sta
	 * inserendo i dati di decollo) - atterraggio (ora di atterraggio di un aereo
	 * della compagnia dall'aeroporto che sta inserendo i dati di atterraggio)
	 */
}
