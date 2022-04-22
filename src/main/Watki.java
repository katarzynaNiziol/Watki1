package main;

class NowyWatek implements Runnable{

    private String name;

    Thread t;

    NowyWatek(String nazwa) {
        this.name = nazwa;
        t = new Thread(this, nazwa);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Uruchomiono wątek potomny " + name);

        try {
            System.out.println("Wątek potomny " + name + " uśpiony.");
            Thread.sleep(2000);
            System.out.println("Wątek potomny " + name + "  wznowiony.");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Zakończono działanie wątku potomnego " + name);
    }
}
public class Watki {
    public static void main (String[] args) {
        new NowyWatek("JEDEN");
        new NowyWatek("DWA");
        new NowyWatek("TRZY");
        new NowyWatek("CZTERY");
        new NowyWatek("PIĘĆ");

        try {
            System.out.println("Usypiam wątek główny");
            Thread.sleep(8000);
            System.out.println("Wznawiam wątek glówny");
        }catch (InterruptedException e) {
            System.out.println("Przerwano wątek głowny");
        }
        System.out.println("Zakończono wykonywanie wątku głównego");
        }
    }
