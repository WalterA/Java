
public class Aereo {
	private String id;
	private Integer posti;
	private Boolean[] postiDisponibili;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPosti() {
		return posti;
	}
	public void setPosti(Integer posti) {
		this.posti = posti;
	}

	public Boolean[] getPostiDisponibili() {
		return postiDisponibili;
	}
	public void setPostiDisponibili(Boolean[] postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	public Aereo(String id, Integer posti) {
		super();
		this.id = id;
		this.posti = posti;
		this.postiDisponibili = new Boolean[posti];
		for (int i =0 ; i<posti; i++) {
			postiDisponibili[i] = true;
		}
	}
	public Aereo() {
		super();
	}
	@Override
	public String toString() {
		return "Aereo [id=" + id + ", posti=" + posti + ", postiDisponibili=" + postiDisponibili + "]";
	}
	
}
