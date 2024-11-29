import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		//Con questo statement indicate il locale da utilizzare
		//Locale.setDefault(Locale.US); Con jsonmapper il locale non serve
		Persona p1 = new Persona(1L, false, 47000.5);
		String st=p1.SerializeJson();
		System.out.println(st);
		
	}

}
