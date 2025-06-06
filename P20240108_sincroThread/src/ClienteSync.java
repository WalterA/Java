public class ClienteSync extends Thread {
    private final String nome;
    private final double somma;
    private final ContoCorrente conto;

    public ClienteSync(String nome, double somma, ContoCorrente conto) {
        super(nome);
        this.nome = nome;
        this.somma = somma;
        this.conto = conto;
    }

    @Override
    public void run() {
        conto.prelievo(somma);
    }
}
