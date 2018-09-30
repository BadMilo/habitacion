/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.habitacion.modelo;

import javax.swing.JLabel;

/**
 * Manejo del radiador
 *
 * @author <a href="mailto:logongas@users.sourceforge.net">Lorenzo González</a>
 */
public class Radiador implements Aparato {

    private int num;
    private Habitacion habitacion;
    private JLabel jLabel;
    private boolean encendido;

    /**
     * @param num Nº de Radiador en la casa. Debe empezar desde 0 hasta el nº de
     * radiadores -1
     */
    public Radiador(int num) {
        this.num = num;
        encendido = false;
    }

    /**
     * Enciende el radiador para que caliente
     */
    public void calentar() {
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
     * Calentar/Apagar el radiador
     */
    public void calentarApagar(boolean tag) {
        jLabel.setVisible(tag);
        encendido = tag;
    }
    
    /**
     * Establece a que habitación pertence el aparato
     *
     * @param habitacion Habitación a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        jLabel = (JLabel) habitacion.getContentComponent(num);
    }

    /**
     * 
     * @return boolean
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * 
     * @param encendido 
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }


    
    
}
