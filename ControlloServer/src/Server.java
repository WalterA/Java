import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Map<Integer, String> impiegati = new HashMap<>();
    private static Map<Integer, String> presenze = new HashMap<>();
    private static Map<Integer, Boolean> badgeStatus = new HashMap<>();

    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("Comando ricevuto: " + text);

                // Deserializza la stringa JSON in un oggetto Comando
                Comando comando = Comando.FromJSon(text);
                String jsonResponse;

                // Gestisce il comando in base al tipo
                switch (comando.getCmd()) {
                    case e_Registrazione:
                        jsonResponse = gestisciRegistrazione(comando);
                        break;
                    case e_Ingresso:
                        jsonResponse = gestisciIngresso(comando);
                        break;
                    case e_Uscita:
                        jsonResponse = gestisciUscita(comando);
                        break;
                    case e_Report:
                        jsonResponse = gestisciReport(comando);
                        break;
                    default:
                        jsonResponse = "{\"risposta\": \"ko\", \"motivo\": \"Comando non riconosciuto\"}";
                        break;
                }

                // Invia la risposta al client
                writer.println(jsonResponse);
            }

        } catch (IOException e) {
            System.err.println("Errore di comunicazione con il client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String gestisciRegistrazione(Comando comando) {
        if (impiegati.containsKey(comando.getBadge())) {
            return "{\"risposta\": \"ko\", \"motivo\": \"utente già presente\"}";
        }
        impiegati.put(comando.getBadge(), comando.getNome());
        badgeStatus.put(comando.getBadge(), true);
        return "{\"risposta\": \"ok\"}";
    }

    private String gestisciIngresso(Comando comando) {
        if (!badgeStatus.containsKey(comando.getBadge()) || !badgeStatus.get(comando.getBadge())) {
            return "{\"risposta\": \"ko\", \"motivo\": \"badge non valido\"}";
        }
        presenze.put(comando.getBadge(), comando.getOrario());
        return "{\"risposta\": \"ok\"}";
    }

    private String gestisciUscita(Comando comando) {
        if (!badgeStatus.containsKey(comando.getBadge()) || !badgeStatus.get(comando.getBadge())) {
            return "{\"risposta\": \"ko\", \"motivo\": \"badge non valido\"}";
        }
        presenze.put(comando.getBadge(), comando.getOrario());
        return "{\"risposta\": \"ok\"}";
    }

    private String gestisciReport(Comando comando) {
        StringBuilder report = new StringBuilder("Report presenze:\n");
        for (Map.Entry<Integer, String> entry : presenze.entrySet()) {
            report.append("Badge: ").append(entry.getKey()).append(" - Orario: ").append(entry.getValue()).append("\n");
        }
        return "{\"risposta\": \"ok\", \"report\": \"" + report.toString().replace("\n", "\\n") + "\"}";
    }
}
