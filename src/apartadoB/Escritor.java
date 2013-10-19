package apartadoB;


public class Escritor extends Thread {

    private Monitor monitor;
    private Cola cola;
    private int id;

    public Escritor(Monitor monitor, Cola cola, int id) {
        this.monitor = monitor;
        this.cola = cola;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            monitor.permisoEscribir();
            int dato = (int) (Math.random() * 10);
            cola.setDato(dato);
            System.out.println("Esta escribiendo el escritor " + id + " y escribe el numero " + dato);
            sleep((long) (Math.random() * 10));
            System.out.println("Deja de escribir");
            monitor.finEscribir();
        } catch (InterruptedException ie) {
        }
    }
}
