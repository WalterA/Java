
public class T implements Runnable {


//Creare un thread e stampare lo stato quando è NEW, RUNNABLE e TERMINATED

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Stato: "+ Thread.currentThread().getState() + " Priorità: "
                + Thread.currentThread().getPriority() );
    }
}


