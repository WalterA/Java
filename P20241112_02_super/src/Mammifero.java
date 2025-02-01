
public abstract class Mammifero {
	private int freqCard;
	private int peso;
	private int zampe;
	private int freqResp;
	public Mammifero(int freqCard, int peso, int zampe, int freqResp) {
		super();
		this.freqCard = freqCard;
		this.peso = peso;
		this.zampe = zampe;
		this.freqResp = freqResp;
	}
	public Mammifero() {
		super();
	}
	public int getFreqCard() {
		return freqCard;
	}
	public void setFreqCard(int freqCard) {
		this.freqCard = freqCard;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getZampe() {
		return zampe;
	}
	public void setZampe(int zampe) {
		this.zampe = zampe;
	}
	public int getFreqResp() {
		return freqResp;
	}
	public void setFreqResp(int freqResp) {
		this.freqResp = freqResp;
	}
	@Override
	public String toString() {
		return "Mammifero [freqCard=" + freqCard + ", peso=" + peso + ", zampe=" + zampe + ", freqResp=" + freqResp
				+ "]";
	}
	public abstract String Verso();
	
}
