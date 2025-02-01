
public class Main {

	public static void main(String[] args) {
		VerificatoreParola verifica = (a,b) -> a.length()>= b;
		String a = "Ciao";
		Integer b =3;
		Boolean r = verifica.verifica(a,b);
		System.out.println(r);
		

	}

}
