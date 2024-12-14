import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tessitrice extends Thread {
	private static String[] tessuti = { "Cotone", "Lino", "Lana", "Seta", "Poliestere", "Nylon" };
	private Random rng = new Random();
	private String id;
	private final Integer periodo=10; //secondi
	private final Integer min_metri = 20;
	private final Integer max_metri = 60;
	private final String file_path="/tmp/tessitrice_";
	private final ObjectMapper om = new ObjectMapper(); //per conversioni da e verso json
	
	
	public Tessitrice(String id) {
		super();
		this.id = id;
	}
	
	public void run() {
		//ogni periodo secondi...
		//crea una quantità di prodotto e la appende a un file
		while (true) {
			//Genera i tre elementi da archiviare nel prodotto
			String tessuto = tessuti[rng.nextInt(0, tessuti.length)]; //un tessuto a caso
			int metri = rng.nextInt(min_metri, max_metri+1); // per includere max_metri
			
			//l'id è il nome della tessitrice
			Prodotto pr = new Prodotto(tessuto, metri, id);
			String pr_json;
			try {
				//genero la conversione in JSON
				pr_json = om.writeValueAsString(pr);

				//formulo il nome del file
				String nomeFile = file_path+id+".txt"; //il nome completo del file

				//Appendo in fondo al file
				var fu = Util.OpenFileForAppend(nomeFile);
				fu.write(pr_json+"\n"); // per andare a capo ogni riga
				fu.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Ed ora aspetto i secondi che servono
			try {
				Thread.sleep(periodo*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //sleep vuole millisecondi
		}
	}
}
