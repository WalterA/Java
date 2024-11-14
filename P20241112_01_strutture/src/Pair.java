//crea una classe che contiene coppie di Tipohe
public class Pair<Tipo> {
	private Tipo first;
	private Tipo second;

	public Pair() {
		super();

	}

	public Pair(Tipo first, Tipo second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	public Tipo getFirst() {
		return first;
	}

	public void setFirst(Tipo first) {
		this.first = first;
	}

	public Tipo getSecond() {
		return second;
	}

	public void setSecond(Tipo second) {
		this.second = second;
	}
}
