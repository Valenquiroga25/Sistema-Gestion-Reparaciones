package gui;

import controlador.Controlador;
import excepciones.EstadoInvalidoException;
import excepciones.notFoundExceptions.ReparacionNotFoundException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VentanaFinalizarReparacion {
    public Controlador controlador = Controlador.getControlador();

    public void abrirVentanaFinalizarReparacion() {
        JFrame ventanaFinalizarReparacion = new JFrame("Finalizar reparación");
        ventanaFinalizarReparacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaFinalizarReparacion.setLayout(new GridLayout(2, 2));

        JLabel lblIdReparacion = new JLabel("Código de la reparación");
        lblIdReparacion.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtIdReparacion = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaFinalizarReparacion.add(lblIdReparacion);
        ventanaFinalizarReparacion.add(txtIdReparacion);
        ventanaFinalizarReparacion.add(new JLabel());
        ventanaFinalizarReparacion.add(panel);

        ventanaFinalizarReparacion.setVisible(true);
        ventanaFinalizarReparacion.pack();
        ventanaFinalizarReparacion.setLocationRelativeTo(null);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtIdReparacion.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaFinalizarReparacion, "El campo está vacío.", "Error encontrando reparación", JOptionPane.ERROR_MESSAGE);
                } else {
                    int codigo = Integer.parseInt(txtIdReparacion.getText());

                    try {
                        controlador.terminarReparacion(codigo);
                        JOptionPane.showMessageDialog(ventanaFinalizarReparacion, "La reparacion ha sido marcado como terminada", "Reparacion Terminada", JOptionPane.INFORMATION_MESSAGE);
                    } catch (EstadoInvalidoException | ReparacionNotFoundException ex) {
                        JOptionPane.showMessageDialog(ventanaFinalizarReparacion, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }

                txtIdReparacion.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIdReparacion.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaFinalizarReparacion.dispose();
            }
        });
    }
}