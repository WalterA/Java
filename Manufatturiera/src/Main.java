public class Main {

	public static void main(String[] args) {
		/*
		  * Un'azienda manufatturiera ha un gruppo di macchine filatrici che producono
		  * tessuti di tipo differente.
		  * - Cotone
		  * - Lino
		  * - Lana
		  * - Seta
		  * - Poliestere
		  * - Nylon
		  * Ogni filatrice è governata da un thread software che scrive 
		  * su un file (specifico della filatrice) a intervalli regolari la 
		  * quantità (in metri) e il tipo di tessuto prodotto.
		  * 
		  * Tutti i file sono scritti su un file system condiviso in modo da
		  * consentirne l'uso da parte di un gestore centralizzato.
		  *
		  * Le tessitrici, 
		  * ogni 10 secondi (per semplicità del testing) aggiornano i file di produzione.
		  * I file di produzione hanno un nome che corrisponde al numero della filatrice
		  * Esempio: sia <filatrice> il nome dell'app filatrice
		  * a tempo di costruzione del thread relativo, assegno il 
		  * nome della specifica tessitrice
		  * Questa, ogni 10 secondi, scriverà nel file produzione_tessitrice_1.dat
		  * una riga (in formato JSON) che descrive il suo identificativo, 
		  * l'elenco e la quantità dei tessuti prodotti
		  * NB: quindi la tessitrice è una classe figlia di thread che prende il nome nel 
		  * costruttore e poi il metodo run (lanciato come thread quando si chiama start()
		  * sull'oggetto) ogni 10 secondi genera un semplice oggetto (Prodotto)
		  * - un nome di tessuto preso in modo casuale tra i tessuti
		  * - un numero intero (es: tra 20 e 60) che indica i metri di tessuto prodotto
		  * - il nome della tessitrice
		  * Tramite ObjectMapper (vi ricordate JSON? e le external jar?) converte 
		  * questo oggetto in JSON e lo appende (ora vi dò una classe corretta per i file)
		  * a un file chiamato "/tmp/tessitrice_<nome della tessitrice>.txt" 
		  *
		*/
		
		//Iniziamo !!!!
		Tessitrice t1 = new Tessitrice("1");
		Tessitrice t2 = new Tessitrice("2");
		Tessitrice t3 = new Tessitrice("3");
		t1.start();
		t2.start();
		t3.start();
		
		//e quindi non si esce mai poiché le tessitrici
		//sono thread che fanno un while (true) con cicli infiniti
	}

}
