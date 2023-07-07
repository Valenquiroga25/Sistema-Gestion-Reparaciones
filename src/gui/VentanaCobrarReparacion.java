package gui;

import controlador.Controlador;
import excepciones.LimiteCreditoInsuficienteException;
import excepciones.alreadyExistsExceptions.ClienteAlreadyExistsException;
import excepciones.notFoundExceptions.ClienteNotFoundException;
import excepciones.notFoundExceptions.ReparacionNotFoundException;
import modelos.Vehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class VentanaCobrarReparacion {
    public Controlador controlador = Controlador.getControlador();
    public void abrirVentanaCobrarReparacion() {
        JFrame ventanaCobrarReparacion = new JFrame("Cobrar Reparación");
        ventanaCobrarReparacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaCobrarReparacion.setLayout(new GridLayout(2, 2));

        JLabel lblCodigoReparacion = new JLabel("ID de reparación");
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

        ventanaCobrarReparacion.add(lblCodigoReparacion);
        ventanaCobrarReparacion.add(txtCodigoReparacion);
        ventanaCobrarReparacion.add(new JLabel());
        ventanaCobrarReparacion.add(panel);

        ventanaCobrarReparacion.setVisible(true);
        ventanaCobrarReparacion.pack();
        ventanaCobrarReparacion.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigoReparacion.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaCobrarReparacion, "El campo está vacío.", "Error cobrando reparación", JOptionPane.ERROR_MESSAGE);
                } else {
                    int codigoReparacion = Integer.parseInt(txtCodigoReparacion.getText());
                    try {
                        float totalCobrar = controlador.cobrarReparacion(codigoReparacion);
                        JOptionPane.showMessageDialog(ventanaCobrarReparacion, "La reparacion ha sido abonada exitosamente! Importe: " + totalCobrar, "Reparacion abonada", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex ) {
                        txtCodigoReparacion.setText("");
                        JOptionPane.showMessageDialog(ventanaCobrarReparacion, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                ventanaCobrarReparacion.dispose();
            }
        });
    }
}
