import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in); //per utilizzare un solo scanner!;

	public static void main(String[] args) {

		// Il client, che mostra un menu, si collega al server, invia richieste e riceve
		// risposte
		// posso fare il tutto nel Main
		while (true) {
			ShowMenu();
		}
	}

	private static void ShowMenu() {
		// Uso il meccanismo delle parentesi dopo la try per chiudere in automatico lo
		// scanner
		System.out.print("""
				               M E N U
				1) Registrazione di un nuovo dipendente
				2) Ingresso di un dipendente
				3) Uscita di un dipendente
				4) Rientro di un dipendente
				5) Sospensione badge dipendente
				6) Riattivazione badge dipendente
				7) Stampa report ingressi e uscite di un dipendente

				0) Termina sessione
				""");

		// Gestisco le richieste come stringhe per evitaare il problema della lettura
		// dei numeri interi
		// In caso di errore ci pensa la catch della try che no messo!
		// leggo riga e faccio il parseint
		Integer richiesta = GetInt("Scelta");
		switch (richiesta) {
		case 1: { // Registrazione
			String nome = GetString("Nome del dipendente");
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Registrazione, nome, id, null, null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 2: // Ingresso
		{
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Ingresso, null, id, LocalDateTime.now().toString(), null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 3: { // Uscita
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Uscita, null, id, LocalDateTime.now().toString(), null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 4: // Rientro
		{
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Rientro, null, id, LocalDateTime.now().toString(), null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 5: { // Sospensione badge
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Sospensione, null, id, LocalDateTime.now().toString(), null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 6: { // Riattivazione badge
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Riattivazione, null, id, LocalDateTime.now().toString(), null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 7: { // Report ingressi e uscite dipendente
			Integer id = GetInt("Numero di badge    ");

			// creo il comando da inviare al server
			Comando cmd = new Comando(Comandi.e_Report, null, id, LocalDateTime.now().toString(), null, null);

			// Converte in JSON e invia al server. Ricorda host e porta del server!!!
			String risposta = Client(cmd.toJSon(), "127.0.0.1", 32456);
			if (risposta == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			// converto in oggetto della classe RIsposta e lo analizzo
			Risposta ans = Risposta.FromJSon(risposta);
			if (ans == null) {
				System.out.println("Problemi di connessione al server!");
				return;
			}
			System.out.println("Ricevuto: " + ans.getEsito() + "\n" + ans.getMessaggio());
			return;
		}
		// break;
		case 0: { // Termine della sessione di lavoro
			System.out.println("Termine del programma");
			System.exit(0);
		}
		// break;
		}
	}

	private static String Client(String jSon, String hostname, Integer port) {
		// Questo tipo di try fa le close dei socket e dei file in automatico, al
		// termine del metodo!
		try (Socket socket = new Socket(hostname, port);
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

			writer.println(jSon); // invia la stringa JSON al server
			String response = reader.readLine(); // prende la risposta

			return response;
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		}
		return null;
	}

	// metodi di utilità
	public static Integer GetInt(String msg) {
		// mostra un messaggio e torna un numero intero
		System.out.print(msg + ": ");
		Integer num = Integer.parseInt(scan.nextLine());
		return num;
	}

	public static Double GetDouble(String msg) {
		// mostra un messaggio e torna un numero double
		System.out.print(msg + ": ");
		Double num = Double.parseDouble(scan.nextLine());
		return num;
	}

	public static String GetString(String msg) {
		// mostra un messaggio e torna una stringa
		System.out.print(msg + ": ");
		String str = scan.nextLine().strip(); // e toglie spazi bianchi in testa e in coda alla riga
		return str;
	}

}
