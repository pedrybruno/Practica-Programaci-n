package apartadoB;

import java.util.concurrent.Semaphore;

public class Cola {

    private int[] dato;
    private int limite;
    private Semaphore sem;
    private int indice;

    public Cola(int limite) {
        this.limite = limite;
        this.dato = new int[limite];
        this.sem = new Semaphore(1);
        this.indice = 0;
    }

    public void setDato(int dato) {
         try {
         sem.acquire();
            if (indice < limite) {
                this.dato[indice] = dato;
                indice++;
            }
            sem.release();
        } catch (InterruptedException ex) {
        }
    }

    public int getDato() throws EstaVacio {
        int d = -1;
        try {
            sem.acquire();
            if (indice == 0){
                throw new EstaVacio();
            }else  {
                indice--;
                d = this.dato[indice];
            }
            sem.release();
        } catch (InterruptedException ex) { }
        return d;
    }
}
