public class ContoCorrenteRisparmio extends ContoCorrente {
    private double tassoInteresse;

    public ContoCorrenteRisparmio(int numeroConto, double saldo, double tassoInteresse) {
        super(numeroConto, saldo);
        this.tassoInteresse = tassoInteresse;
    }

    public double getTassoInteresse() {
        return tassoInteresse;
    }

    // Metodo per applicare gli interessi
    public void applicaInteressi() {
        double interessi = getSaldo() * tassoInteresse / 100;
        deposita(interessi);
        System.out.println("Interessi applicati: " + interessi + ". Saldo attuale: " + getSaldo());
    }
}
