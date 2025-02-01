
public class Main {

	public static void main(String[] args) {
		Persona p1 = new Persona("Fe", "al", 121);
		System.out.println(p1);
		Modifica(p1);
		System.out.println(p1);
	}

	private static void Modifica(Persona p1) {
		p1.setEta(10); 
	}

}
