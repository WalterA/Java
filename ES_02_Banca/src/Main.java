public class Main {
    public static void main(String[] args) {
        // Creazione dell'istanza della banca
        Banca banca = new Banca();

        // Creazione dei conti correnti
        ContoCorrente conto1 = new ContoCorrente(1001, 500.0);
        ContoCorrenteRisparmio conto2 = new ContoCorrenteRisparmio(1002, 1000.0, 5.0);  // Tasso di interesse 5%

        // Aggiunta dei conti correnti alla banca
        banca.aggiungiConto(conto1);
        banca.aggiungiConto(conto2);

        // Deposito e prelievo per testare i metodi
        conto1.deposita(200.0);
        conto1.preleva(150.0);
        conto2.deposita(300.0);
        conto2.preleva(500.0);
        conto2.applicaInteressi();  // Applica gli interessi al conto risparmio

        // Visualizzazione dei saldi di tutti i conti
        banca.mostraTuttiISaldi();
    }
}
