import java.util.Random;

public class Consumatore extends Thread {
    public void run() {
        Random rng = new Random();
        int tempo = 0;
        int quanti = 0;
        int somma = 0;

        while (true) {
            int attesa = rng.nextInt(100,500);
            tempo += attesa;
            try {
                Thread.sleep(attesa);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            if(tempo>=2000) {
            System.out.println("letti finora "+ quanti+ " numeri");
            if (quanti >0) {
                    System.out.println("Somma "+ somma + " Media: "+ somma *1.0/quanti);
                }
                tempo = 0;
            }

            while(!Main.qi.isEmpty()) {
                Integer num = Main.qi.poll();
                quanti ++;
                somma += num;
            }
        }
    }
}
