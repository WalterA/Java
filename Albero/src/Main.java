import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		        Scanner scanner = new Scanner(System.in);

		        // Chiedere all'utente l'altezza dell'albero
		        System.out.print("Inserisci l'altezza dell'albero: ");
		        int altezza = scanner.nextInt();

		        // Stampare la chioma dell'albero
		        for (int i = 0; i < altezza; i++) {
		            // Stampare gli spazi
		            for (int j = 0; j < altezza - i - 1; j++) {
		                System.out.print(" ");
		            }
		            // Stampare le stelle
		            for (int j = 0; j < 2 * i + 1; j++) {
		                System.out.print("*");
		            }
		            System.out.println();
		        }

		        // Stampare il tronco dell'albero
		        int larghezzaTronco = altezza / 3; // larghezza del tronco proporzionale all'altezza
		        larghezzaTronco = (larghezzaTronco % 2 == 0) ? larghezzaTronco + 1 : larghezzaTronco; // Deve essere dispari
		        int altezzaTronco = altezza / 4; // altezza del tronco proporzionale all'altezza

		        for (int i = 0; i < altezzaTronco; i++) {
		            // Stampare gli spazi
		            for (int j = 0; j < altezza - larghezzaTronco / 2 - 1; j++) {
		                System.out.print(" ");
		            }
		            // Stampare il tronco
		            for (int j = 0; j < larghezzaTronco; j++) {
		                System.out.print("|");
		            }
		            System.out.println();
		        }

		        scanner.close();
		    }
		


	}


