
public class WI_FI {
	private Double frequenza;
	private String id;
	private String password;
	private String protocollo;

	public Double getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(Double frequenza) {
		this.frequenza = frequenza;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public WI_FI(Double frequenza, String id, String password, String protocollo) {
		super();
		this.frequenza = frequenza;
		this.id = id;
		this.password = password;
		this.protocollo = protocollo;
	}
	
	@Override
	public String toString() {
		return "WI_FI [frequenza=" + frequenza + ", id=" + id + ", password=" + password + ", protocollo=" + protocollo
				+ "]";
	}
	public static WI_FI MakeWifi() {
		return new WI_FI(Util.getFrequenza(), Util.getPassword(false), Util.getPassword(true), Util.GetRandomAuthProto());
		
	}
}