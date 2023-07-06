package gui;

import controlador.Controlador;
import excepciones.alreadyExistsExceptions.ClienteAlreadyExistsException;
import excepciones.notFoundExceptions.VehiculoNotFoundException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaCliente {
    public Controlador controlador = Controlador.getControlador();
    public void abrirVentanaRegistrarCliente() {
        JFrame ventanaRegistrarCliente = new JFrame("Registrar cliente");
        ventanaRegistrarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarCliente.setLayout(new GridLayout(7, 2));

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtNombre = new JTextField();

        JLabel lblTipoDocumento = new JLabel("Tipo de Documento");
        lblTipoDocumento.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtTipoDocumento = new JTextField();

        JLabel lblNroDocumento = new JLabel("Numero Documento");
        lblNroDocumento.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtNroDocumento = new JTextField();

        JLabel lblCuentaCorriente = new JLabel(("Salario Cuenta Corriente"));
        lblCuentaCorriente.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtCuentaCorriente = new JTextField();

        JLabel lblLimiteCuentaCorriente = new JLabel(("Limite Cuenta Corriente"));
        lblLimiteCuentaCorriente.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtLimiteCuentaCorriente = new JTextField();

        JLabel lblMatricula = new JLabel(("Matricula"));
        lblMatricula.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtMatricula = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarCliente.add(lblNombre);
        ventanaRegistrarCliente.add(txtNombre);
        ventanaRegistrarCliente.add(lblTipoDocumento);
        ventanaRegistrarCliente.add(txtTipoDocumento);
        ventanaRegistrarCliente.add(lblNroDocumento);
        ventanaRegistrarCliente.add(txtNroDocumento);
        ventanaRegistrarCliente.add(lblCuentaCorriente);
        ventanaRegistrarCliente.add(txtCuentaCorriente);
        ventanaRegistrarCliente.add(lblLimiteCuentaCorriente);
        ventanaRegistrarCliente.add(txtLimiteCuentaCorriente);
        ventanaRegistrarCliente.add(lblMatricula);
        ventanaRegistrarCliente.add(txtMatricula);

        ventanaRegistrarCliente.add(new JLabel());
        ventanaRegistrarCliente.add(panel);

        ventanaRegistrarCliente.setVisible(true);
        ventanaRegistrarCliente.pack();
        ventanaRegistrarCliente.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNombre.getText().equals("") || txtTipoDocumento.getText().equals("") || txtNroDocumento.getText().equals("") ||
                                txtCuentaCorriente.getText().equals("") || txtLimiteCuentaCorriente.getText().equals("") || txtMatricula.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaRegistrarCliente, "Alguno de los campos está vacío.", "Error registrando el cliente", JOptionPane.ERROR_MESSAGE);
                } else {
                    String nombre = txtNombre.getText();
                    String tipoDocumento = txtTipoDocumento.getText();
                    String nroDocumento = txtNroDocumento.getText();
                    float cuentaCorriente = Float.parseFloat(txtCuentaCorriente.getText());
                    float limiteCuentaCorriente = Float.parseFloat(txtLimiteCuentaCorriente.getText());
                    String matricula = txtMatricula.getText();

                    try {
                        controlador.registrarCliente(nombre, tipoDocumento, nroDocumento, cuentaCorriente, limiteCuentaCorriente, matricula);
                        JOptionPane.showMessageDialog(ventanaRegistrarCliente, "El cliente ha sido registrado exitosamente!", "Cliente registrado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ClienteAlreadyExistsException | VehiculoNotFoundException ex) {
                        JOptionPane.showMessageDialog(ventanaRegistrarCliente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        txtNombre.setText("");
                        txtTipoDocumento.setText("");
                        txtNroDocumento.setText("");
                        txtCuentaCorriente.setText("");
                        txtLimiteCuentaCorriente.setText("");
                        txtMatricula.setText("");
                        throw new RuntimeException(ex);
                    }
                }
                txtNombre.setText("");
                txtTipoDocumento.setText("");
                txtNroDocumento.setText("");
                txtCuentaCorriente.setText("");
                txtLimiteCuentaCorriente.setText("");
                txtMatricula.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtTipoDocumento.setText("");
                txtNroDocumento.setText("");
                txtCuentaCorriente.setText("");
                txtLimiteCuentaCorriente.setText("");
                txtMatricula.setText("");
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
