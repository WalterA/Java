import java.io.*;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() {
        try (Socket socket = new Socket(hostname, port);
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true);
             InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            // Menu per l'utente
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String comando;
            while (true) {
                System.out.println("Scegli un comando:");
                System.out.println("1 - Registrazione");
                System.out.println("2 - Ingresso");
                System.out.println("3 - Uscita");
                System.out.println("4 - Report");
                System.out.println("0 - Esci");

                comando = consoleReader.readLine();
                if (comando.equals("0")) {
                    System.out.println("Chiusura del client.");
                    break;
                }

                String jsonRequest = "";
                switch (comando) {
                    case "1":
                        System.out.println("Inserisci badge ID:");
                        int badgeRegistrazione = Integer.parseInt(consoleReader.readLine());
                        System.out.println("Inserisci nome:");
                        String nome = consoleReader.readLine();
                        jsonRequest = "{\"cmd\": \"e_Registrazione\", \"badge\": " + badgeRegistrazione + ", \"nome\": \"" + nome + "\"}";
                        break;
                    case "2":
                        System.out.println("Inserisci badge ID:");
                        int badgeIngresso = Integer.parseInt(consoleReader.readLine());
                        System.out.println("Inserisci orario (es. 09:00):");
                        String orarioIngresso = consoleReader.readLine();
                        jsonRequest = "{\"cmd\": \"e_Ingresso\", \"badge\": " + badgeIngresso + ", \"orario\": \"" + orarioIngresso + "\"}";
                        break;
                    case "3":
                        System.out.println("Inserisci badge ID:");
                        int badgeUscita = Integer.parseInt(consoleReader.readLine());
                        System.out.println("Inserisci orario (es. 17:00):");
                        String orarioUscita = consoleReader.readLine();
                        jsonRequest = "{\"cmd\": \"e_Uscita\", \"badge\": " + badgeUscita + ", \"orario\": \"" + orarioUscita + "\"}";
                        break;
                    case "4":
                        jsonRequest = "{\"cmd\": \"e_Report\"}";
                        break;
                    default:
                        System.out.println("Comando non valido.");
                        continue;
                }

                // Invia la richiesta al server
                writer.println(jsonRequest);

                // Legge la risposta dal server
                String response = reader.readLine();
                System.out.println("Risposta del server: " + response);
            }

        } catch (IOException e) {
            System.err.println("Errore di connessione al server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
