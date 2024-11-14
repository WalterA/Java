
public class Balena extends Mammifero{
	String habitat;
	
	@Override
	public String toString() {
		return "Balena [habitat=" + habitat + ", toString()=" + super.toString() + "]";
	}

	@Override
	public String Verso() {
		return "ahahhah";
	}

	public Balena(int freqCard, int peso, int zampe, int freqResp, String habitat) {
		super(freqCard, peso, zampe, freqResp);
		this.habitat = habitat;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	
}
