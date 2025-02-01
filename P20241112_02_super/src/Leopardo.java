
public class Leopardo extends Mammifero{
	Integer velocità;

	@Override
	public String Verso() {
		return "Road";
	}

	public Leopardo(int freqCard, int peso, int zampe, int freqResp, Integer velocità) {
		super(freqCard, peso, zampe, freqResp);
		this.velocità = velocità;
	}

	

	@Override
	public String toString() {
		return "Leopardo [velocità=" + velocità + "]";
	}

	public Integer getVelocità() {
		return velocità;
	}

	public void setVelocità(Integer velocità) {
		this.velocità = velocità;
	}
	
	
}
