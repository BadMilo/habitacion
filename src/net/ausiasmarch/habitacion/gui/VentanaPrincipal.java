/*
 * VentanaPrincipal.java
 */
package net.ausiasmarch.habitacion.gui;

import javax.swing.JOptionPane;
import net.ausiasmarch.habitacion.modelo.Habitacion;

/**
 * VentanaPrincipal
 *
 * @author Programador
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public VentanaPrincipal() {
        initComponents();
        setSize(900, 700);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void listaMensaje(String mensajes) {
        jTextAreaMensajes.setText(mensajes);
    }

    public void limpiaListaMensaje() {
        jTextAreaMensajes.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        habitacion = new net.ausiasmarch.habitacion.modelo.Habitacion();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMensajes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Habitaci�n");
        setMinimumSize(new java.awt.Dimension(1020, 668));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        habitacion.setToolTipText("");
        getContentPane().add(habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 640));

        jTextAreaMensajes.setEditable(false);
        jTextAreaMensajes.setColumns(20);
        jTextAreaMensajes.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMensajes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 940, 130));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.ausiasmarch.habitacion.modelo.Habitacion habitacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMensajes;
    // End of variables declaration//GEN-END:variables
}