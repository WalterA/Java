import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Dipendente {
	private String nome;
	private Integer badge;
	private Boolean badgeSospeso;
	private List<IngressoUscita> in_out = new LinkedList<IngressoUscita>();

	public Dipendente(String nome, Integer badge) {
		super();
		this.nome = nome;
		this.badge = badge;
		badgeSospeso = false;
	}

	public Dipendente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getBadge() {
		return badge;
	}

	public void setBadge(Integer badge) {
		this.badge = badge;
	}

	public List<IngressoUscita> getIn_out() {
		return in_out;
	}

	public void setIn_out(List<IngressoUscita> in_out) {
		this.in_out = in_out;
	}

	@Override
	public String toString() {
		return "Dipendente [nome=" + nome + ", badge=" + badge + ", in_out=" + in_out + "]";
	}

	// Gestione degli ingressi/uscite del dipendente
	public Boolean Ingresso(String motivazione, String orario) {
		if (badgeSospeso) {
			return false;
		} else {
			in_out.add(new IngressoUscita(true, motivazione, orario));
			return true;
		}
	}

	public Boolean Uscita(String motivazione, String orario) {
		if (badgeSospeso) {
			return false;
		} else {
			in_out.add(new IngressoUscita(false, motivazione, orario));
			return true;
		}
	}

	public Boolean getBadgeSospeso() {
		return badgeSospeso;
	}

	public void setBadgeSospeso(Boolean badgeSospeso) {
		this.badgeSospeso = badgeSospeso;
	}

}

//La classe IngressoUscita la dichiaro all'interno della classe Dipentente.
class IngressoUscita {
	private Boolean ingresso; // se false allora è una uscita
	private String motivazione;
	private String orario;

	public IngressoUscita(Boolean ingresso, String motivazione, String orario) {
		super();
		this.ingresso = ingresso;
		this.motivazione = motivazione;
		this.orario = orario;
	}

	@Override
	public String toString() {
		return "IngressoUscita [ingresso=" + ingresso + ", motivazione=" + motivazione + ", orario=" + orario + "]";
	}

	public Boolean getIngresso() {
		return ingresso;
	}

	public void setIngresso(Boolean ingresso) {
		this.ingresso = ingresso;
	}

	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public IngressoUscita() {
		super();
	}
}