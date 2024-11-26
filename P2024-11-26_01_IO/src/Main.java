import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Costruire un set insieme di oggetti di tipo wifi e inserire 100 wifi casuali

		Set<WI_FI> sWifi = new HashSet<WI_FI>();
		for (int i = 0; i < 100; i++) {
			sWifi.add(WI_FI.MakeWifi());
		}
		System.out.println(sWifi);
		
		//scrivere su disco
		//scrivere nel file pippo.txt la stringa iniziale del 5 maggio 
		//chiudere il file (il bufferedwritter.close()
		//appendere al file pippo.txt un pochino di righe della vispa teresa
		//chiudere il file
		//con u bufferereader, leggere e stampare tutte le righe del file pippo.txt
		var fou = Util.OpenFileForWriting("pippo.txt");
		
		try {
			fou.write("Ei fu, siccome immobile" );
			fou.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		fou = Util.OpenFileForAppend("pippo.txt");
		try {
			fou.write("La vispa Teresa, un di dall'\ngigigi\ndadasdas");
			fou.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		var fou1 = Util.OpenFileForReading("pippo.txt");
		try {
			String line;
			while ((line = fou1.readLine()) != null) { // Legge riga per riga
                System.out.println(line); 
			}
			fou1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// operatore ternario <expr logica> ?<exp se true>:<expr se false>
		
		
		
		
		
	}
	//Al posto del for!! Ma queste cose le farete in seguito!!
	//IntStream.range(0,100).forEach(i ->sWifi.add(Wifi.MakeWifi()));
	
	

}
