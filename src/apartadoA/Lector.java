package apartadoA;

public class Lector extends Thread{
    
    private Monitor monitor;
    private int id;

    public Lector(Monitor monitor, int id) {
        this.monitor = monitor;
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            monitor.permisoLeer();
            System.out.println("Esta leyendo el lector "+ id);
            
            sleep((long) (Math.random()*10));
            System.out.println("Deja de leer");
            monitor.finLeer();
        } catch (InterruptedException ie) {}
    }
}
