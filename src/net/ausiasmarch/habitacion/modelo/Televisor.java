/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.habitacion.modelo;

import javax.swing.JLabel;
import javazoom.jl.player.Player;
import javax.swing.ImageIcon;

/**
 * Controla los aparatos de reproducción de Video como DVDs o Videos VHS
 *
 * @author <a href="mailto:logongas@users.sourceforge.net">Lorenzo González</a>
 */
public class Televisor implements Aparato {

    int num;
    Player player;
    Thread thread;
    Habitacion habitacion;
    JLabel jLabel;
    JLabel jLabelImagen;
    boolean estado;
    boolean encendido = false;

    /**
     * Constructor
     *
     * @param num Nº del Televisor en la casa. Debe empezar desde 0 hasta el nº
     * de Televisores -1
     */
    public Televisor(int num) {
        this.num = num;
    }

    /**
     * Enciende el televisor
     */
    public void encender() {
        jLabel.setVisible(true);
        encendido = true;
    }

    /**
     * Apaga el televisor
     */
    public void apagar() {
        jLabel.setVisible(false);
        jLabelImagen.setVisible(false);
        encendido = false;
    }

    /**
     * Encender/Apagar el televisor
     */
    public void encenderApagar(boolean tag) {
        jLabel.setVisible(tag);
        jLabelImagen.setVisible(tag);
        encendido = tag;
    }
      
    /**
     * 
     * @param fichero 
     */
    public void setImagenVideo(String fichero) {
        if (fichero != null) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("../recursos/" + fichero));
            jLabelImagen.setIcon(imagen);
            jLabelImagen.setVisible(true);
        } else {
            jLabelImagen.setIcon(null);
            jLabelImagen.setVisible(false);
        }

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

    /**
     * Establece a que habitación pertence el aparato
     *
     * @param habitacion Habitación a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        jLabel = (JLabel) habitacion.getContentComponent(num);
        jLabelImagen = (JLabel) habitacion.getContentComponent(num - 1);
    }
}
