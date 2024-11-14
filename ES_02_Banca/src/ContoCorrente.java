public class ContoCorrente {
    private int numeroConto;
    private double saldo;

    public ContoCorrente(int numeroConto, double saldo) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    public double getSaldo() {
        return saldo;
    }

    // Metodo per depositare denaro
    public void deposita(double importo) {
        saldo += importo;
        System.out.println("Deposito di " + importo + " effettuato. Saldo attuale: " + saldo);
    }

    // Metodo per prelevare denaro
    public void preleva(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
            System.out.println("Prelievo di " + importo + " effettuato. Saldo attuale: " + saldo);
        } else {
            System.out.println("Errore: saldo insufficiente per il prelievo di " + importo);
        }
    }

    // Metodo per mostrare il saldo
    public void mostraSaldo() {
        System.out.println("Conto n. " + numeroConto + " - Saldo: " + saldo);
    }
}
