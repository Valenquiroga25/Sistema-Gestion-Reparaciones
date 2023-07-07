package gui;

import controlador.Controlador;
import excepciones.alreadyExistsExceptions.RepuestoAlreadyExistsException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class VentanaRegistrarRepuesto {
    public Controlador controlador = Controlador.getControlador();
    public void abrirVentanaRegistrarRepuesto() {
        JFrame ventanaRegistrarRepuesto = new JFrame("Agregar nuevo repuesto");
        ventanaRegistrarRepuesto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarRepuesto.setLayout(new GridLayout(4, 2));

        JLabel lblCodigoRepuesto = new JLabel("Código de repuesto");
        lblCodigoRepuesto.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCodigoRepuesto = new JTextField();

        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtDescripcion = new JTextField();

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtPrecio = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarRepuesto.add(lblCodigoRepuesto);
        ventanaRegistrarRepuesto.add(txtCodigoRepuesto);
        ventanaRegistrarRepuesto.add(lblDescripcion);
        ventanaRegistrarRepuesto.add(txtDescripcion);
        ventanaRegistrarRepuesto.add(lblPrecio);
        ventanaRegistrarRepuesto.add(txtPrecio);

        ventanaRegistrarRepuesto.add(new JLabel());
        ventanaRegistrarRepuesto.add(panel);

        ventanaRegistrarRepuesto.setVisible(true);
        ventanaRegistrarRepuesto.pack();
        ventanaRegistrarRepuesto.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigoRepuesto.getText().equals("") || txtDescripcion.getText().equals("") || txtPrecio.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaRegistrarRepuesto, "Alguno de los campos está vacío.");

                } else {
                    int codigo = Integer.parseInt(txtCodigoRepuesto.getText());
                    String descripcion = txtCodigoRepuesto.getText();
                    float precio = Float.parseFloat(txtPrecio.getText());

                    try {
                        controlador.registrarRepuesto(codigo, descripcion, precio);
                        JOptionPane.showMessageDialog(ventanaRegistrarRepuesto,"El repuesto ha sido registrado exitosamente!", "Mano de obra registrada", JOptionPane.INFORMATION_MESSAGE);
                    } catch (RepuestoAlreadyExistsException ex) {
                        txtCodigoRepuesto.setText("");
                        txtDescripcion.setText("");
                        txtPrecio.setText("");
                        JOptionPane.showMessageDialog(ventanaRegistrarRepuesto, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }

                txtCodigoRepuesto.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCodigoRepuesto.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistrarRepuesto.dispose();
            }
        });
    }
}