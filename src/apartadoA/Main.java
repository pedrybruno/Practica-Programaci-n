package apartadoA;

import java.util.Random;


public class Main {
    
    public static void main(String[] args){
        Random numAl = new Random(101);
        Monitor monitor = new Monitor();
        int num;
        
        for (int i = 1; i <= 10; i++) {
            num = numAl.nextInt(101);
            if ((num % 2) == 0) {
                Lector lector = new Lector(monitor,i);
                lector.start();
            }
            else {
                Escritor escritor = new Escritor(monitor,i);
                escritor.start();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {}
        }
    }
    
}
