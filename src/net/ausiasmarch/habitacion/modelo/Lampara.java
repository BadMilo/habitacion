package net.ausiasmarch.habitacion.modelo;

import javax.swing.JLabel;

/**
 * Manejo de una lámpara
 * @author <a href="mailto:logongas@users.sourceforge.net">Lorenzo González</a>
 */
public class Lampara implements Aparato {

    private int num;
    private Habitacion habitacion;
    private JLabel jLabel;
    private boolean encendida;
    private double potencia;

    /**
     * @param num Nº de lámpara en la casa. Debe empezar desde 0 hasta el nº de lámparas -1
     */
    public Lampara(int num) {
        this.num = num;
        encendida = false;
    }

    /**
     * Lampara encendida si o no 
     * @return boolean
     */
    public boolean isEncendida() {
        return encendida;
    }

    /**
     * 
     * @param encendida 
     */
    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    /**
     * Ontiene la Potencia en watios
     * @return 
     */
    public double getPotencia() {
        return potencia;
    }

    /**
     * Establece la potencia en watios
     * @param potencia 
     */
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    

    /**
     * Enciende la lámpara
     */
    public void encender() {
        jLabel.setVisible(true);
        encendida = true;    
    }
       
    /**
     * Apaga la lámpara
     */
    public void apagar() {
         jLabel.setVisible(false);
         encendida = false;
    }

     /**
     * Enciende o apaga la lámpara 
     * @param tag
     */
    public void encenderApagar(boolean tag) {
         jLabel.setVisible(tag);
         encendida = tag;
    }
    
    public void intensidad(int valor){
       jLabel= (JLabel)habitacion.getContentComponent(valor); 
    }
   
    
    /**
     * Establece a que habitación pertence el aparato
     * @param habitacion Habitación a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        jLabel= (JLabel)habitacion.getContentComponent(num);
    }
   
}
