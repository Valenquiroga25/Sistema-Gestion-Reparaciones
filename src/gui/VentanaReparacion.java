package gui;

import controlador.Controlador;
import excepciones.notFoundExceptions.ClienteNotFoundException;
import excepciones.notFoundExceptions.VehiculoNotFoundException;

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

public class VentanaReparacion {

    Controlador controlador = Controlador.getControlador();

    public void abrirVentanaRegistrarReparacion() {
        JFrame ventanaRegistrarReparacion = new JFrame("Generar reparación");
        ventanaRegistrarReparacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarReparacion.setLayout(new GridLayout(5, 2));

        JLabel lblFechaReparacion = new JLabel("Fecha de reparación");
        lblFechaReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtFechaReparacion = new JTextField();

        JLabel lblNroDocumentoCliente = new JLabel("Documento del cliente");
        lblNroDocumentoCliente.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtNroDocumentoCliente = new JTextField();

        JLabel lblMatricula = new JLabel("Matricula del vehículo");
        lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtMatricula = new JTextField();
        
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarReparacion.add(lblFechaReparacion);
        ventanaRegistrarReparacion.add(txtFechaReparacion);
        ventanaRegistrarReparacion.add(lblNroDocumentoCliente);
        ventanaRegistrarReparacion.add(txtNroDocumentoCliente);
        ventanaRegistrarReparacion.add(lblMatricula);
        ventanaRegistrarReparacion.add(txtMatricula);

        ventanaRegistrarReparacion.add(new JLabel());
        ventanaRegistrarReparacion.add(panel);

        ventanaRegistrarReparacion.setVisible(true);
        ventanaRegistrarReparacion.pack();
        ventanaRegistrarReparacion.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFechaReparacion.getText().equals("") || txtMatricula.getText().equals("") || txtNroDocumentoCliente.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaRegistrarReparacion, "Alguno de los campos está vacío.");
                } else {
                    String fecha = txtFechaReparacion.getText();
                    String nroDocumentoCliente = txtNroDocumentoCliente.getText();
                    String  matricula = txtMatricula.getText();

                    try {
                        controlador.generarReparacion(fecha, nroDocumentoCliente, matricula);
                        JOptionPane.showMessageDialog(ventanaRegistrarReparacion, "La reparacion ha sido creada exitosamente!");
                    } catch (ClienteNotFoundException | VehiculoNotFoundException ex) {
                        txtFechaReparacion.setText("");
                        txtMatricula.setText("");
                        txtNroDocumentoCliente.setText("");
                        JOptionPane.showMessageDialog(ventanaRegistrarReparacion, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtFechaReparacion.setText("");
                txtMatricula.setText("");
                txtNroDocumentoCliente.setText("");
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFechaReparacion.setText("");
                txtMatricula.setText("");
                txtNroDocumentoCliente.setText("");
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistrarReparacion.dispose();
            }
        });
    }
}
