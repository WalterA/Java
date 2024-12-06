import java.time.LocalTime;

public class Volo {
/* 
 * voli(da,a,orario,nome aereo) lista
 */
	private String cittaPartenza;
	private String cittaArrivo;
	private LocalTime oraPartenza;
	private LocalTime oraArrivo;
	private Boolean partenza;
	private Boolean imbarco;
	private Aereo aereo;
	
	public String getCittaPartenza() {
		return cittaPartenza;
	}
	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}
	public String getCittaArrivo() {
		return cittaArrivo;
	}
	public void setCittaArrivo(String cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}
	public LocalTime getOraPartenza() {
		return oraPartenza;
	}
	public void setOraPartenza(LocalTime oraPartenza) {
		this.oraPartenza = oraPartenza;
	}
	public LocalTime getOraArrivo() {
		return oraArrivo;
	}
	public void setOraArrivo(LocalTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	public Boolean getPartenza() {
		return partenza;
	}
	public void setPartenza(Boolean partenza) {
		this.partenza = partenza;
	}
	public Boolean getImbarco() {
		return imbarco;
	}
	public void setImbarco(Boolean imbarco) {
		this.imbarco = imbarco;
	}
	public Aereo getAereo() {
		return aereo;
	}
	public void setAereo(Aereo aereo) {
		this.aereo = aereo;
	}
	public Volo(String cittaPartenza, String cittaArrivo, LocalTime oraPartenza, LocalTime oraArrivo, Boolean partenza,
			Boolean imbarco, Aereo aereo) {
		super();
		this.cittaPartenza = cittaPartenza;
		this.cittaArrivo = cittaArrivo;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
		this.partenza = partenza;
		this.imbarco = imbarco;
		this.aereo = aereo;
	}
	public Volo() {
		super();
	}
	@Override
	public String toString() {
		return "Volo [cittaPartenza=" + cittaPartenza + ", cittaArrivo=" + cittaArrivo + ", oraPartenza=" + oraPartenza
				+ ", oraArrivo=" + oraArrivo + ", partenza=" + partenza + ", imbarco=" + imbarco + ", aereo=" + aereo
				+ "]";
	}


	
	
}
