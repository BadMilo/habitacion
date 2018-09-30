package net.ausiasmarch.habitacion.modelo;

import javax.swing.JLabel;

/**
 * Aparate de Aire Acondicionado
 */
public class AireAcondicionado implements Aparato {

    private int num;
    private JLabel jLabel;
    private boolean encendido;
    private double potencia;

    /**
     * @param num 
     */
    public AireAcondicionado(int num) {
        this.num = num;
        encendido = false;
    }

    /**
     * Enciende el aire acondicionado para que enfrie
     */
    public void enfriar() {
        jLabel.setVisible(true);
        encendido = true;
    }
    /**
     * Apaga el radiador
     */
    public void apagar() {
        jLabel.setVisible(false);      
        encendido = false;
    }

    /**
     * Enfriar/Apagar el aire acondicionado
     * @param tag
     */
    public void enfriarApagar(boolean tag) {
        jLabel.setVisible(tag);
        encendido = tag;
    }
    
    /**
     * Establece a que habitación pertence el aparato
     * @param habitacion Habitación a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
      //  this.habitacion = habitacion;
        jLabel = (JLabel) habitacion.getContentComponent(num);
    }

    /**
     * Comprueba si esta encendido
     * @return boolean
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * Establese si esta o n oencendido
     * @param encendido 
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }
    
    

}
