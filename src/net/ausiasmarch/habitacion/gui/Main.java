package net.ausiasmarch.habitacion.gui;
import net.ausiasmarch.habitacion.modelo.*;

/**
 * Main
 * 
 * @author Programador
 */
public class Main {

    /**
     * Principal
     * @param args 
     */
    public static void main(String[] args) {
        // No borrar estas 2 lineas ------------------------
        VentanaPrincipal ventana = new VentanaPrincipal();
        Habitacion habitacion = ventana.getHabitacion();
       // --------------------------------------------------

        // Creamos los objetos
        Persiana persiana = new Persiana(15);


        // Los ponemos en la habitacion
        persiana.setHabitacion(habitacion);

        // Los usamos
        pausa(2);           // hace una pausa de 5 seg
        persiana.bajar();
        pausa(2);

        
  











        

    }


    /**
     * Hace una pausa en milisegundos
     *
     * @param sleep
     */
    private static void pausa(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

}
