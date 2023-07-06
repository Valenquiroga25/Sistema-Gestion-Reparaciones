
package gui;

import controlador.Controlador;
import excepciones.notFoundExceptions.ReparacionNotFoundException;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaCostoReparacion {
    public Controlador controlador = Controlador.getControlador();
    public void abrirVentanaCostoReparacion() {
        JFrame ventanaCostoReparacion = new JFrame("Costo reparación");
        ventanaCostoReparacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaCostoReparacion.setLayout(new GridLayout(2, 2));

        JLabel lblCodigoReparacion = new JLabel("Código de la reparación");
        lblCodigoReparacion.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtCodigoReparacion = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaCostoReparacion.add(lblCodigoReparacion);
        ventanaCostoReparacion.add(txtCodigoReparacion);
        ventanaCostoReparacion.add(new JLabel());
        ventanaCostoReparacion.add(panel);

        ventanaCostoReparacion.setVisible(true);
        ventanaCostoReparacion.pack();
        ventanaCostoReparacion.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigoReparacion.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaCostoReparacion, "El campo está vacío.", "Error encontrando reparación", JOptionPane.ERROR_MESSAGE);
                } else {
                    int codigoReparacion = Integer.parseInt(txtCodigoReparacion.getText());
                    try {
                        float costoReparacion = controlador.costoReparacion(codigoReparacion);
                        JOptionPane.showMessageDialog(ventanaCostoReparacion, "El costo de la reparacion es de: " + costoReparacion, "Costo Reparacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ReparacionNotFoundException ex) {
                        txtCodigoReparacion.setText("");
                        JOptionPane.showMessageDialog(ventanaCostoReparacion, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtCodigoReparacion.setText("");
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCodigoReparacion.setText("");
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCostoReparacion.dispose();
            }
        });
    }}
