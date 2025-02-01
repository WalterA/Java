import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

class Server extends Thread {
	public Socket socket;

	public Server(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// Il thread!
		System.out.println("New client connected");

		// Handle client in a separate thread
		try (
				// Estraggo il canale di ingresso
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));

				// Estraggo il canale di uscita
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true)) {

			// Inizio a leggere e a scrivere finché non mi arriva la stringa "bye"
			String request = reader.readLine();
			if (request == null) {
				System.out.println("Errore nella ricezione della richiesta da client. Termina la sessione di lavoro");
			} else {
				System.out.println("Ricevuta la richiesta: " + request);

				// Qui il codice per gestire la richiesta e formulare la risposta
				String answer = ManageRequest(request);

				// Invia la risposta al client
				writer.println(answer);

				// Nota che qui il programma/thread termina la sua esecuzione e,
				// automaticamente (grazie al try/catch con le parentesi tonde)
				// chiude i canali di comunicazione aperti verso il client
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private String ManageRequest(String request) throws JsonMappingException, JsonProcessingException {
		// per prima cosa dobbiamo convertire la stringa JSON in un oggetto della classe
		// Comando
		// uso il metodo statico della classe per costruire tale oggetto
		Comando comando = Comando.FromJSon(request);

		// Lo switch dei comandi
		switch (comando.cmd) {
		case e_Registrazione: {
			// deve prendere nome e badge. Se non sono nell'archivio, allora inserisce il
			// nuovo dipendente
			if (Main.dipendenti.containsKey(comando.badge) || // per caso il badge è già presente?
					Main.nomi_badge.containsKey(comando.nome) // lo stesso per il nome
			) {
				return new Risposta("KO", "badge o nome già presente in archivio").toJSon();
			} else {
				Main.nomi_badge.put(comando.nome, comando.badge); // inserisco nome, badge e poi creo il dipendente!!!!
				Main.dipendenti.put(comando.badge, new Dipendente(comando.nome, comando.badge));
				return new Risposta("OK", "Nuovo dipendente inserito in archivio").toJSon();
			}
		}
		// break; Il break non serve poiché nel case ho fatto return!
		case e_Ingresso:
		case e_Rientro: // Il rientro lo tratto, per semplicità, come un ingresso! non c'è differenza
						// tra ingresso e rientro
		{
			// verifico che il badge esista e non sia sospeso
			if (!Main.dipendenti.containsKey(comando.badge)) {
				return new Risposta("KO", "Numero del Badge non presente in archivio").toJSon();
			} else if (Main.dipendenti.get(comando.badge).getBadgeSospeso()) {
				return new Risposta("KO", "Operazione non effettuata. Il badge è sospeso").toJSon();
			} else {
				/*
				 * questa sembra un'istruzione complessa ma è sufficiente leggerla da sinistra a
				 * destra 1) cerca il dipendente in base al badge
				 * Main.dipendenti.get(comando.badge) 2) l'oggetto Dipendente ha una lista di
				 * ingressi e uscite (il getter si chiama getIn_out) 3) ora abbiamo la lista
				 * degli ingressi e uscite, con la add aggiungo un elemento (infresso o uscita)
				 * 4) la new serve proprio a questo!
				 */
				Main.dipendenti.get(comando.badge).getIn_out()
						.add(new IngressoUscita(true, comando.motivo, comando.orario));
				return new Risposta("OK", "Registrato l'ingresso/rientro del dipendente").toJSon();
			}
		}
		// break; Il break non serve poiché nel case ho fatto return!
		case e_Uscita: {
			if (!Main.dipendenti.containsKey(comando.badge)) {
				return new Risposta("KO", "Numero del Badge non presente in archivio").toJSon();
			} else if (Main.dipendenti.get(comando.badge).getBadgeSospeso()) {
				return new Risposta("KO", "Operazione non effettuata. Il badge è sospeso").toJSon();
			} else {
				/*
				 * Come nell'ingresso ma stavolta metto a false il booleano che distingue tra
				 * ingresso e uscita
				 */
				Main.dipendenti.get(comando.badge).getIn_out()
						.add(new IngressoUscita(false, comando.motivo, comando.orario));
				return new Risposta("OK", "Registrata l'uscita del dipendente").toJSon();
			}
		}
		// break; Il break non serve poiché nel case ho fatto return!
		case e_Sospensione: {
			if (!Main.dipendenti.containsKey(comando.badge)) {
				return new Risposta("KO", "Numero del Badge non presente in archivio").toJSon();
			} else if (Main.dipendenti.get(comando.badge).getBadgeSospeso()) {
				return new Risposta("KO", "Operazione non effettuata. Il badge è già sospeso").toJSon();
			} else {
				// sospende il badge
				Main.dipendenti.get(comando.badge).setBadgeSospeso(true);
				return new Risposta("OK", "badge sospeso").toJSon();
			}
		}
		// break; Il break non serve poiché nel case ho fatto return!
		case e_Riattivazione: {
			if (!Main.dipendenti.containsKey(comando.badge)) {
				return new Risposta("KO", "Numero del Badge non presente in archivio").toJSon();
			} else if (!Main.dipendenti.get(comando.badge).getBadgeSospeso()) {
				return new Risposta("KO", "Operazione non effettuata. Il badge non risulta sospeso").toJSon();
			} else {
				// Riattiva il badge
				Main.dipendenti.get(comando.badge).setBadgeSospeso(false);
				return new Risposta("OK", "badge riattivato").toJSon();
			}
		}
		// break; Il break non serve poiché nel case ho fatto return!
		case e_Report: {
			if (!Main.dipendenti.containsKey(comando.badge)) {
				return new Risposta("KO", "Numero del Badge non presente in archivio").toJSon();
			} else {
				// Torna l'elenco dei dati presenti nella lista di ingressi e uscite
				var lista_in_out = Main.dipendenti.get(comando.badge).getIn_out();
				// per fornire un report, lo strutturo in modo semplice, un elemento per riga.

				StringBuilder sb = new StringBuilder(); // più veloce e efficiente delle stringhe!!!
				for (var x : lista_in_out) {
					sb.append(x.toString() + "\n"); // una per riga...
				}
				return new Risposta("OK", sb.toString()).toJSon();
			}
		}
		// break; Il break non serve poiché nel case ho fatto return!
		default: {
			return new Risposta("KO", "Richiesta non riconosciuta").toJSon();
		}
		}
	}
}

public class SocketServer {
	public void Server(int port) {
		// int port = 12345; // Port number

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			// con questa set il server potrà essere rimesso in
			// esecuzione anche immediatamente dopo la sua terminazione
			serverSocket.setReuseAddress(true);

			// Creo il socket sul quale sarò in "ascolto"
			System.out.println("Server is listening on port " + port);

			// resta in attesa finché un "client" chiederà di collegarsi
			while (true) {
				Socket socket = serverSocket.accept();

				// Qui devo far partire il thread
				Server srv = new Server(socket);
				srv.start();
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
