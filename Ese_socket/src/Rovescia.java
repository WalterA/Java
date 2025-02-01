
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Server extends Thread {
	public Socket socket;

	public Server(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// Questa parte deve diventare un thread!
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
			String text;
			while ((text = reader.readLine()) != null) {
				System.out.println("Received: " + text);
				String invertita = new StringBuilder(text).reverse().toString();
				// Echo the received message
				writer.println("Server: " + invertita);

				// Exit condition
				if ("bye".equalsIgnoreCase(text)) {
					System.out.println("Client disconnected");
					break;
				}
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}

public class Rovescia {
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
				// Come faccio a fare la start del thread?
				Server srv = new Server(socket);
				srv.start();
			}
		} catch (

		IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
