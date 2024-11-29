import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.IntStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {

//		int ai=10;
//		int a = ai++ + ai++ + ai++;

//		System.out.println(a + " , " + ai);
//		System.exit(0);

		// Costruire un Set di oggetti di tipo Wifi e inserire 100 Wifi casuali
		Set<Wifi> sWifi = new HashSet<Wifi>();

		// Aggiungere i 100 elementi
		for (int i = 0; i < 100; i++) {
			sWifi.add(Wifi.MakeWifi());
		}

//		//Al posto del for!!!!Ma queste cose le farete in seguito!!!
//		IntStream.range(0,100).forEach(i -> sWifi.add(Wifi.MakeWifi()));

		System.out.println(sWifi);

		if (false) {
			// Come posso scrivere su disco i dati contenuti in sWifi?
			// Scrivere nel file pippo.txt la stringa iniziale del 5 maggio
			// Chiudere il file (il bufferedWriter.close()
			// Appendere al file pippo.txt un pochino di righe della Vispa Teresa
			// Chiudere il file
			// Con un bufferedReader, leggere e stampare tutte le
			// righe del file pippo.txt

			// operatore ternario
			// <expr logica>?<expr se true>:<expr se false>

			// Scrivere nel file pippo.txt la stringa iniziale del 5 maggio
			BufferedWriter foutput = Util.OpenFileForWriting("pippo.txt");
			try {
				foutput.write("Ei fu, siccome immobile, \n");
				foutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Appendere al file pippo.txt un pochino di righe della Vispa Teresa
			foutput = Util.OpenFileForAppend("pippo.txt");
			try {
				foutput.write("La vispa Teresa, avea tra l'erbetta\n");
				foutput.write("A volo sorpresa gentil farfalletta\n");
				foutput.write("E tutta giuliva stringendola viva\rgridava distesa: \"L'ho presa! L'ho presa!\"\n");
				foutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedReader finput = Util.OpenFileForReading("pippo.txt");
			String riga;
			try {
				while ((riga = finput.readLine()) != null) {
					System.out.println(riga);
				}
				finput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 1: appendere anche dei numeri interi e reali al file pippo.txt
			// Scrivere nel file pippo.txt la stringa iniziale del 5 maggio
			BufferedWriter foutput2 = Util.OpenFileForWriting("pippo1.txt");
			try {
				int ii;
				ii = 1;
				foutput2.write(ii);
				foutput2.write("Ciao");
				ii = 3987;
				foutput2.write(ii);
				foutput2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				var fou = Files.newOutputStream(Path.of("prova.txt"));
				int ii = 510;
				fou.write(ii++);
				fou.write(ii++);
				fou.write("Ciao".getBytes("UTF-8"));
				fou.write(ii++);
				fou.write(ii++);
				fou.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// String.format("%s,%s,%d,%s", "Ciao", "uno", 10, "sette");

		// Scrivo sul file wifi.txt il contenuto del set swifi
		final String nomeFile = "wifi.txt";
		BufferedWriter fou = Util.OpenFileForWriting(nomeFile);
		for (Wifi x : sWifi) {
			try {
				// scrivo di seguito id,password,protocollo,frequenza
				fou.write(String.format("%f;%s;%s;%s\n", x.getFrequenza(), x.getId(), x.getPassword(),
						x.getProtocollo()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fou.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lo rileggo e ricostruisco il set
		sWifi.clear(); // Svuoto il set
		BufferedReader fin = Util.OpenFileForReading(nomeFile);
		String riga;
		try {
			// Ricorda che hai scritto id, protocollo,password e frequenza
			// e invece il costruttore vuole
			// Double frequenza, String id, String password, String protocollo
			while ((riga = fin.readLine()) != null) {
				String[] valori = riga.split(";");
				sWifi.add(
						new Wifi(Double.parseDouble(valori[0].replaceAll(",", ".")), valori[1], valori[2], valori[3]));
			}
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Rispampo la wifi
		System.out.println(sWifi);

		ObjectMapper objectmapper = new ObjectMapper();
		Wifi wi = Wifi.MakeWifi();

		String JsonString = "";

		try {
			JsonString = objectmapper.writeValueAsString(wi);
			System.out.println(JsonString);
		} catch (JsonProcessingException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		Wifi wi2;
		try {
			wi2 = objectmapper.readValue(JsonString, Wifi.class);
			System.out.println(wi2);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final String nomeF = "w.txt";
		BufferedWriter fo = Util.OpenFileForWriting(nomeF);
		try {
			JsonString = objectmapper.writeValueAsString(wi);
			System.out.println(JsonString);
		} catch (JsonProcessingException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		try {
			fo.write(JsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}