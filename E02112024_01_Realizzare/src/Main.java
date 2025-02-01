import java.util.Scanner;
//Nel main
//* 1) creare due compagnie
//* 2) aggiungere le due compagnie alla agenzia
//* 3) aggiungere qualche aereo a ogni compagnia
//* 4) realizzare un menu per
//* 1) prenotare posto su un aereo
//* 2) Stampare per ogni compagnia e per ogni aereo i posti prenotati e il numero di posto ancora disponibili

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Compagnia compagnia1 = new Compagnia("Compagnia A");
		Compagnia compagnia2 = new Compagnia("Compagnia B");

		Biglietteria biglietteria = new Biglietteria(compagnia1, compagnia2);

		compagnia1.aggiungiAereo(new Aereo(10));
		compagnia1.aggiungiAereo(new Aereo(15));
		compagnia2.aggiungiAereo(new Aereo(8));
		compagnia2.aggiungiAereo(new Aereo(12));

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1) Prenotare posto su un aereo");
			System.out.println("2) Stampare posti prenotati e disponibili per ogni compagnia e aereo");
			System.out.println("0) Esci");
			System.out.print("Scelta: ");
			int scelta = scanner.nextInt();

			if (scelta == 0) {
				break;
			}

			switch (scelta) {
			case 1:
				System.out.print("Inserisci numero compagnia (1 o 2): ");
				int numeroCompagnia = scanner.nextInt();
				System.out.print("Inserisci numero aereo: ");
				int numeroAereo = scanner.nextInt();
				System.out.print("Inserisci numero posto: ");
				int numeroPosto = scanner.nextInt();

				boolean successo = biglietteria.prenotaPosto(numeroCompagnia, numeroAereo, numeroPosto);
				if (successo) {
					System.out.println("Posto prenotato con successo!");
				} else {
					System.out.println("Prenotazione fallita. Controlla i dati inseriti.");
				}
				break;
			case 2:
				biglietteria.stampaDettagliCompagnie();
				break;
			default:
				System.out.println("Scelta non valida.");
			}
		}

		scanner.close();
	}
}