package apartadoB;

public class Monitor {
    
    private int escritoresEsperando = 0;
    private int numeroEscritores;
    private int numeroLectores;
    
    public Monitor() {
        escritoresEsperando = 0;
        numeroEscritores = 0;
        numeroLectores = 0;
    }
    
    public synchronized void permisoLeer() throws InterruptedException{
        while ((numeroEscritores > 0) || (escritoresEsperando > 0)){
          wait();
        }
        numeroLectores++;
    }
    
    
    public synchronized void finLeer() {
        numeroLectores--;
        notifyAll();
    }
    
    public synchronized void permisoEscribir() throws InterruptedException{
        escritoresEsperando++;
        while (numeroLectores > 0){
                wait();
        }
        escritoresEsperando--;
        numeroEscritores++;
    }
    
    public synchronized void finEscribir() {
        numeroEscritores--;
         notifyAll();
    }

}