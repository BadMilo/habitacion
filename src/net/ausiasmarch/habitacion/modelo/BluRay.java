package net.ausiasmarch.habitacion.modelo;

import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 * Controla los aparatos de reproducción de Video como DVDs o Videos VHS
 *
 * @author Luis Mateo
 */
public class BluRay extends TimerTask implements Aparato {

    private final int num;
    private JLabel jLabel, jLabelTiempo;
    private Timer timer = null;
    private int time;
    private final int period = 1000;
    private Televisor televisor;
    private boolean isPlay = false;
    private boolean encendido;
    private final BasicPlayer basicPlayer;

    /**
     * Constructor
     *
     * @param num
     */
    public BluRay(int num) {
        this.num = num;
        timer = null;
        isPlay = false;
        encendido = false;
        basicPlayer = new BasicPlayer();
    }

    /**
     * Reproduce el DVD en el televisor
     *
     * @param audio
     * @param imagen
     * @param tv
     */
    public void play(String audio, String imagen, Televisor tv) throws RuntimeException {
        try {
            InputStream is;
            String path = "net/ausiasmarch/habitacion/recursos/" + audio;
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

            if (tv != null) {
                televisor = tv;
                televisor.encender();
                televisor.setImagenVideo(imagen);
            }

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

    /**
     * Detiene la reproducción de la película
     */
    public void stop() {
        try {
            jLabel.setVisible(false);
            jLabelTiempo.setVisible(false);
            time = 0;
            if (televisor != null) {
                televisor.setImagenVideo(null);
            }
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
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        jLabelTiempo.setText(tiempo);
        time = time + period;
    }

    /**
     * Establece el televisor para el BluRay
     *
     * @param televisor
     */
    public void setTelevisor(Televisor televisor) {
        this.televisor = televisor;
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
     * Comprueba si el aire acondicionado esta encendido
     *
     * @return boolean
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * Establese si la aire acondicionado esta o n oencendido
     *
     * @param encendido
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

}
