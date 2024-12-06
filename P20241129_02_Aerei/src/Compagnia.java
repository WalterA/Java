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
		if (voli.get(codiceVolo) != null) {
			Volo volo = voli.get(codiceVolo);
			Aereo a = volo.getAereo();
			if (posto >= a.getPostiDisponibili().length || !a.getPostiDisponibili()[posto]) {
				return false;
			} else {
				a.getPostiDisponibili()[posto] = false;
				return true;

			}
		}
		return false;
	}

	public boolean eliminaPrenota(String codiceVolo, String luogo, Integer posto) {
		if (voli.get(codiceVolo) != null) {
			Volo volo = voli.get(codiceVolo);
			Aereo a = volo.getAereo();
			if (posto >= a.getPostiDisponibili().length || a.getPostiDisponibili()[posto]) {
				return false;
			} else {
				a.getPostiDisponibili()[posto] = true;
				return true;

			}
		}
		return false;
	}
}
