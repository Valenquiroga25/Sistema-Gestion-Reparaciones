package gui;

import controlador.Controlador;
import excepciones.alreadyExistsExceptions.ClienteAlreadyExistsException;
import excepciones.notFoundExceptions.ClienteNotFoundException;
import modelos.Vehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class VentanaCliente {
    public Controlador controlador = Controlador.getControlador();
    public void abrirVentanaRegistrarCliente() {
        JFrame ventanaRegistrarCliente = new JFrame("Registrar cliente");
        ventanaRegistrarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarCliente.setLayout(new GridLayout(4, 2));

        JLabel lblDocumento = new JLabel("Documento");
        lblDocumento.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtDocumento = new JTextField();

        JLabel lblTipoDocumento = new JLabel("Tipo de Documento");
        lblTipoDocumento.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtTipoDocumento = new JTextField();

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtNombre = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarCliente.add(lblDocumento);
        ventanaRegistrarCliente.add(txtDocumento);
        ventanaRegistrarCliente.add(lblNombre);
        ventanaRegistrarCliente.add(txtNombre);
        ventanaRegistrarCliente.add(lblTipoDocumento);
        ventanaRegistrarCliente.add(txtTipoDocumento);
        ventanaRegistrarCliente.add(new JLabel());
        ventanaRegistrarCliente.add(panel);

        ventanaRegistrarCliente.setVisible(true);
        ventanaRegistrarCliente.pack();
        ventanaRegistrarCliente.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDocumento.getText().equals("") || txtNombre.getText().equals("") || txtTipoDocumento.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaRegistrarCliente, "Alguno de los campos está vacío.", "Error registrando el cliente", JOptionPane.ERROR_MESSAGE);
                    txtDocumento.setText("");
                    txtNombre.setText("");
                    txtTipoDocumento.setText("");
                } else {
                    JOptionPane.showMessageDialog(ventanaRegistrarCliente, "Se aceptaron los datos.", "Cliente registrado", JOptionPane.INFORMATION_MESSAGE);
                    txtDocumento.setText("");
                    txtNombre.setText("");
                    txtTipoDocumento.setText("");
                }
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar los datos del cliente
                txtDocumento.setText("");
                txtNombre.setText("");
                txtTipoDocumento.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistrarCliente.dispose();
            }
        });
    }

}
