import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		String esempio = " 123 + 876 ";
//
//        //per prima cosa tolgo tutti gli spazi bianchi
//        esempio = esempio.replaceAll(" ", "");
//        System.out.println(esempio);
//
//        //poi provo a separare gli operandi (ci sarà una split?)
//        String[] operandi = esempio.split("[\\+\\-\\*\\/]");
//        for (String s: operandi) {
//            System.out.println(s);
//        }
//
//        //poi provo a estrarre l'operatore
//        String[] voperatore = esempio.split("[0-9]+");
//        for (String s: voperatore) {
//            System.out.println("<" + s + ">");
//        }
//        //Quindi l'operatore sarà al secondo posto del vettore voperatori
//        String operatore = voperatore[1];

		// ora avete operandi e operatore!!! Potete eseguire i calcoli
		Scanner scanner = new Scanner(System.in);
		int somma = 0;
		// Chiediamo all'utente di inserire un nome
		System.out.print("Inserisci l'operazione: ");
		String nome = scanner.nextLine();
		nome = nome.replaceAll(" ", "");
		System.out.println(nome);
		String[] voperatore = nome.split("[0-9]+");
		for (String s : voperatore) {
			System.out.println("<" + s + ">");
		}

		String[] operandi = nome.split("[\\+\\-\\*\\/]");
		for (String f : operandi) {
			System.out.println(f);
		}
//		String z = voperatore[1];
//		for (int i=0; i<voperatore.length; i++) {
//			if (z.compareTo("+") == 0) {
//				int num1 = Integer.parseInt(operandi[0]);
//				int num2 = Integer.parseInt(operandi[1]);
//				somma = num1 + num2;}
//			if  (z.compareTo("-") == 0 ) {
//					int num3 = Integer.parseInt(operandi[2]);
//					somma -= num3;
//			}
		int op1 = Integer.parseInt(operandi[0]);
		int op2 = Integer.parseInt(operandi[1]);
		for (int i=1; i<voperatore.length; i++) {
			switch (voperatore[i]) {
			case "+":
				System.out.println(op1 += Integer.parseInt(operandi[i]));
				break;
			case "-":
				System.out.println(op1 -= Integer.parseInt(operandi[i]));
				break;
			case "/":
				System.out.println(op1 /= Integer.parseInt(operandi[i]));
				break;
			case "*":
				System.out.println(op1 *= Integer.parseInt(operandi[i]));
				break;
			}
	}
	}}
/*
 * scrivere un programma che interpreta stringhe che eseguono operazioni
 * aritmetiche del tipo 10
 * 
 * 10 + 20
 * 
 * 30 * 7
 * 
 * e, una volta letta la stringa di input,
 * 
 * verifica se ci sono operatori o se è n solo operando se è un solo operando ne
 * stampa il valore se c'è un operatore, separa i due operandi, esegue
 * l'operazionie e stampa il risultato per estrarre gli operandi in py farei una
 * cosa del tipo [x.strip for x in re.split("\\+|\\-|\\*|\\/","22*41")] [x.strip
 * for x in re.split("[0-9]+","22*41")]
 */
