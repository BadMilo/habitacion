package net.ausiasmarch.habitacion.modelo;

import java.io.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 * Permite manejar una cadena musical
 *
 * @author Luis Mateo
 */
public class MiniCadena extends TimerTask implements Aparato {

    private final int num;
    private JLabel jLabel, jLabelTiempo;
    private Timer timer;
    private int time;
    private final int period = 1000;
    private boolean isPlay = false;
    private boolean encendido;
    private final BasicPlayer basicPlayer;

    /**
     * Constructor
     *
     * @param num
     */
    public MiniCadena(int num) {
        this.num = num;
        timer = null;
        basicPlayer = new BasicPlayer();
    }

    /**
     * Hace que suene la música en la cadena
     *
     * @param fichero
     */
    public void play(String fichero) {
        
        try {
            InputStream is;
            String path = "net/ausiasmarch/habitacion/recursos/" + fichero;
            ClassLoader cl = this.getClass().getClassLoader();

            if (cl == null) {
                is = ClassLoader.getSystemResourceAsStream(path);
            } else {
                is = cl.getResourceAsStream(path);
            }

            if (is == null) {
                throw new RuntimeException("No se puede reproducir la música");
            }
            
            basicPlayer.open(is);           
            basicPlayer.play();
            
            jLabel.setVisible(true);
            jLabelTiempo.setVisible(true);
            isPlay = true;

            if (timer == null) {
                time = 0;
                timer = new Timer();
                timer.scheduleAtFixedRate(this, 0, 1000);
            }
        } catch (BasicPlayerException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void pausa(){
        try {
            basicPlayer.pause();
        } catch (BasicPlayerException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    /**
     * Para la reproducción de la música
     */
    public void stop() {
        try {
            jLabel.setVisible(false);
            time = 0;
            isPlay = false;
            jLabelTiempo.setVisible(false);
            basicPlayer.stop();
        } catch (BasicPlayerException ex) {
           throw new RuntimeException(ex);
        }
    }

    /**
     * Establece a que habitación pertence el aparato
     *
     * @param habitacion Habitación a la que pertence el aparato
     */
    @Override
    public void setHabitacion(Habitacion habitacion) {
        jLabel = (JLabel) habitacion.getContentComponent(num);
        jLabelTiempo = (JLabel) habitacion.getContentComponent(num - 1);
    }

    @Override
    public void run() {

        String tiempo = String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes(time),
                TimeUnit.MILLISECONDS.toSeconds(time)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)));

        Time formatoTime;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
            formatoTime = new Time(sdf.parse(tiempo).getTime());
            tiempo = sdf.format(formatoTime);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        jLabelTiempo.setText(tiempo);
        time = time + period;
    }

    /**
     * @return the isPlay
     */
    public boolean isPlay() {
        return isPlay;
    }

    /**
     * @param isPlay the isPlay to set
     */
    public void setPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }

    /**
     * Comprueba si esta encendido
     *
     * @return boolean
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * Establese si  esta o n oencendido
     *
     * @param encendido
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
}
