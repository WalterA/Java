public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new T());

        System.out.println(t1.getName() +" Stato:" + t1.getState());

        t1.start();

        try {
            t1.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (t1.isAlive()) 
            System.out.println(t1.getName() +" Stato:" + t1.getState());
        else
            System.out.println(t1.getName() +" Stato:" + t1.getState());

    }
}
