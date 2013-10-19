package apartadoB;

public class Lector extends Thread{
    
    private Monitor monitor;
    private Cola cola;
    private int id;

    public Lector(Monitor monitor, Cola cola, int id) {
        this.monitor = monitor;
        this.cola = cola;
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            monitor.permisoLeer();
            int dato = cola.getDato();
            System.out.println("Esta leyendo el lector " + id + " y lee " + dato);
            sleep((long) (Math.random()*10));
            System.out.println("Deja de leer");
            monitor.finLeer();
        } 
        catch (InterruptedException ie) {} 
        catch (EstaVacio ex) {}
    }
}
