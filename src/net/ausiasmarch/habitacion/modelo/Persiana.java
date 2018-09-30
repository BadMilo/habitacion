package net.ausiasmarch.habitacion.modelo;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Permite subir o bajar una persiana
 */
public class Persiana implements Aparato, Runnable {

    private JPanel habitacion;
    private Thread hiloPersiana;
    // posiciones de la persiana antes de estar bajada del todo
    private int posiciones = 3;
    private int num;
    private boolean subida;
    private int posInicio;
    private boolean parar;

    public static enum Accion {
        SUBE, BAJA
    };
    public Accion accion;

    /**
     * @param num
     */
    public Persiana(int num) {
        this.num = num;
        subida = true;
        posInicio = num;
        parar = false;
    }

    /**
     * Baja la persiana
     */
    public void bajar() {
        accion = Accion.BAJA;
        hiloPersiana = new Thread(this);    // this es un objeto persiana
        hiloPersiana.start();
    }

    /**
     * Sube la persiana
     */
    public void subir() {
        accion = Accion.SUBE;
        hiloPersiana = new Thread(this);
        hiloPersiana.start();
    }

    /**
     * Sube/baja la presiana
     * @param tag
     */
    public void subirBajar(boolean tag) {
        accion = tag?Accion.SUBE:Accion.BAJA;  
        hiloPersiana = new Thread(this);
        hiloPersiana.start();
    }
    
    /**
     * Establece a que habitación pertence el aparato
     *
     * @param habitacion Habitación a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public void run() {
        switch (accion) {  // si la persiana esta subida
            case BAJA:
                // Bajamos la persiana     
                for (int i = posInicio; i <= num + posiciones && parar == false; i++) {
                    posInicio = i;
                    persianaVisible(i, true);
                }
                if (posInicio == num + posiciones) {
                    subida = false;
                }
                if (parar == true) {
                    posInicio++;
                }
                break;

            case SUBE:
                // Subimos la persiana   
                for (int i = num + posiciones; i >= num && parar == false; i--) {
                    posInicio = i;
                    persianaVisible(i, false);
                }
                if (posInicio == num) {
                    subida = true;
                }
                if (parar == true) {
                    posInicio--;
                }
        }
    }

    /**
     * Persiana visible
     * @param i
     * @param sn 
     */
    private void persianaVisible(int i, boolean sn) {
        try {
            ((JLabel) habitacion.getComponent(i)).setVisible(sn);
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Comprueba si la persiana esta subida
     * @return 
     */
    public boolean isSubida() {
        return subida;
    }

    /**
     * Pone la persiana subidad o bajada
     * @param subida 
     */
    public void setSubida(boolean subida) {
        this.subida = subida;
    }

    /**
     * Obtiene las posiciones de la persiana
     * @return 
     */
    public int getPosiciones() {
        return posiciones;
    }

    /**
     * 
     * @return int
     */
    public int getPosInicio() {
        return posInicio;
    }

    /**
     * 
     * @return boolean
     */
    public boolean isParar() {
        return parar;
    }

    /**
     * 
     * @param parar 
     */
    public void setParar(boolean parar) {
        this.parar = parar;
    }

    /**
     * 
     * @param posInicio 
     */
    public void setPosInicio(int posInicio) {
        this.posInicio = posInicio;
    }

    /**
     * 
     * @param posiciones 
     */
    public void setPosiciones(int posiciones) {
        this.posiciones = posiciones;
    }
}
