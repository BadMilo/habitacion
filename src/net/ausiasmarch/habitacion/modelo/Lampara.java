package net.ausiasmarch.habitacion.modelo;

import javax.swing.JLabel;

/**
 * Manejo de una l�mpara
 * @author <a href="mailto:logongas@users.sourceforge.net">Lorenzo Gonz�lez</a>
 */
public class Lampara implements Aparato {

    private int num;
    private Habitacion habitacion;
    private JLabel jLabel;
    private boolean encendida;
    private double potencia;

    /**
     * @param num N� de l�mpara en la casa. Debe empezar desde 0 hasta el n� de l�mparas -1
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
     * Enciende la l�mpara
     */
    public void encender() {
        jLabel.setVisible(true);
        encendida = true;    
    }
       
    /**
     * Apaga la l�mpara
     */
    public void apagar() {
         jLabel.setVisible(false);
         encendida = false;
    }

     /**
     * Enciende o apaga la l�mpara 
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
     * Establece a que habitaci�n pertence el aparato
     * @param habitacion Habitaci�n a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        jLabel= (JLabel)habitacion.getContentComponent(num);
    }
   
}
