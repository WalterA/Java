public class Banca {
    private ContoCorrente[] contiCorrenti;
    private int numConti;

    public Banca() {
        contiCorrenti = new ContoCorrente[10];  // massimo 10 conti
        numConti = 0;
    }

    // Metodo per aggiungere un conto corrente
    public void aggiungiConto(ContoCorrente conto) {
        if (numConti < contiCorrenti.length) {
            contiCorrenti[numConti] = conto;
            numConti++;
            System.out.println("Conto corrente n. " + conto.getNumeroConto() + " aggiunto.");
        } else {
            System.out.println("Impossibile aggiungere il conto. Banca piena.");
        }
    }

    // Metodo per mostrare tutti i saldi
    public void mostraTuttiISaldi() {
        System.out.println("\nSaldi di tutti i conti:");
        for (int i = 0; i < numConti; i++) {
            contiCorrenti[i].mostraSaldo();
        }
    }
}
