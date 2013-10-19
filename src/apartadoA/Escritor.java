package apartadoA;

public class Escritor extends Thread {

    private Monitor monitor;
    private int id;

    public Escritor(Monitor monitor, int id) {
        this.monitor = monitor;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            monitor.permisoEscribir();
            System.out.println("Esta escribiendo el escritor " + id);
            sleep((long) (Math.random() * 10));
            System.out.println("Deja de escribir");
            monitor.finEscribir();
        } catch (InterruptedException ie) {
        }
    }
}
