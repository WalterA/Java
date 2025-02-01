import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		/*
		 * Realizzare, in gruppi di due sviluppatori/progettisti, un sistema di servizi
		 * client-server per la gestione delle presenze giornaliere in un ufficio. Il
		 * sistema deve prevedere le seguenti funzionalità: registrazione di un nuovo
		 * impiegato (assegnazione di un badge) ingresso/rientro del personale uscita
		 * del personale (con motivazione: pranzo, appuntamento di lavoro, termine
		 * giornata, ecc) sospensione/riattivazione del badge stampa delle presenze
		 * mensili/giornaliere/settimanali
		 * 
		 * Il progetto prevede la realizzazione di un modulo server (in carico al back
		 * office) e di un modulo client (front office) che interagisce con il personale
		 * e provvede anche alle operazioni di stampa.
		 * 
		 * E' un requisito non derogabile l'uso del formalismo JSON per strutturare lo
		 * scambio dati tra client e server. Il protocollo di comunicazione deve essere
		 * TCP/IP.
		 * 
		 */
		/*
		 * Realizziamo due progetti che condividono le stesse strutture di gestione dei
		 * comandi un progetto si chiamerà P20241219_02_Server e un progetto si chiamerà
		 * P20241219_03_Client
		 * 
		 * Inoltre, gli archivi dell'applicazione (registrazioni, presenze, ecc.) per
		 * semplicità sono dichiarati come strutture statiche in questo programma Main e
		 * dovranno consentire di gestire: - registrazione di un nuovo impiegato
		 * (assegnazione di un badge) - ingresso/rientro del personale, uscita del
		 * personale con motivazione(pranzo, appuntamento di lavoro, termine giornata,
		 * ecc.) - sospensione/riattivazione del badge - stampa delle presenze
		 * mensili/giornaliere/settimanali
		 * 
		 * Potrei utilizzare una struttura tipo HashMap con indice il numero del badge e
		 * con parte dati un oggetto che contiene - nome del dipendente - numero di
		 * badge - un booleano che indica se il badge è attivo oppure no - una lista di
		 * registrazioni di ingresso e uscita dalla struttura
		 * 
		 * Quindi l'enumerazione Comandi, la classe Comando, la classe Risposta, la
		 * classe Dipendente, sono condivise tra i due progetti. Per semplicità in
		 * questo caso sono duplicate.
		 */

		/*
		 * Questo è il server. Viene eseguito utilizzando i thread in modo da rendere
		 * possibile l'accesso contemporaneo al server da parte di più client Il modello
		 * di funzionamento dell'applicazione è il seguente: 1) il client si collega al
		 * server e gli invia la sua richiesta 2) il server riceve la richiesta, la
		 * esegue e invia la risposta al client 3) il client riceve la risposta 4) il
		 * client chiude la connessione 5) il server chiude la connessione
		 */

		SocketServer srv = new SocketServer();
		srv.Server(32456);
	}

	// Le struttura di archiviazione le dichiaro in questo punto in modo che siano
	// statiche e visibili
	// al resto del codice
	public static HashMap<Integer, Dipendente> dipendenti = new HashMap<Integer, Dipendente>();

	// per semplicità di gestione, cosa che non faremmo utilizzando un DB, utilizzo
	// un secondo hashmap per ricordare i
	// nomi del personale registrato, associato al numero di badge.
	// questo potrebbe sembrare ridondante ma è per semplificare ricerca e
	// registrazione di nuovo
	// personale e per controllare che non ci siano due dipendenti con lo stesso
	// nome!
	public static HashMap<String, Integer> nomi_badge = new HashMap<String, Integer>();

	//
	//
	//
	// Qui un paio di metodi statici per convertire date in stringa e viceversa.
	// Solo per vostra informazione ma non utilizzate nel progetto
	// Semplice da inserire. Nel progetto utilizzeremo esclusivamente stringhe 
	public static String DateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(date);
		return dateString;
	}

	public static Date StringToDate(String sdate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = null;
		try {
			date = formatter.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return date;
	}

}
