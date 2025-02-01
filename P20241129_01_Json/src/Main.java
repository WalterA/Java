import java.util.LinkedList;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		// Con questo statement indicate il locale da utilizzare
		// Locale.setDefault(Locale.US); Con jsonmapper il locale non serve
		Persona p1 = new Persona(1L, false, 47000.5);
		
		String st = p1.SerializeJson();
		System.out.println(st);
		String serializza = p1.SerializeJson();
		
		Persona pdeserializza = p1.DeserializeJson(serializza);
		System.out.println(pdeserializza);
		System.exit(0);
		

		LinkedList<Persona> lp = new LinkedList<Persona>();
		lp.add(p1);
		lp.add(new Persona(2L,true, 78.25));
		lp.add(new Persona (4L,false,78.55));
		
		ObjectMapper objectMapper = new ObjectMapper();
		String slp = objectMapper.writeValueAsString(lp);
		System.out.println(slp);
		
		var lp1 = objectMapper.readValue(slp,new LinkedList<Persona>().getClass());
		System.out.println(lp1);
		
		
		
		

	}

}
