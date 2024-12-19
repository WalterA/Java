import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 12345; // Porta di ascolto
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server in ascolto sulla porta " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuovo client connesso: " + socket.getInetAddress());

                // Crea un'istanza del server per il client connesso
                Server server = new Server(socket);
                new Thread(server::run).start(); // Avvia il server in un nuovo thread
            }
        } catch (IOException e) {
            System.err.println("Errore di avvio del server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
