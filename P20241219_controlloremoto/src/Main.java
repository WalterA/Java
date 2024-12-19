public class Main {
    public static void main(String[] args) {
        String hostname = "localhost"; // Indirizzo del server
        int port = 12345;             // Porta del server

        Client client = new Client(hostname, port);
        client.start();
    }
}
