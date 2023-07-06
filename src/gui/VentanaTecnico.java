package gui;

import controlador.Controlador;
import excepciones.alreadyExistsExceptions.TecnicoAlreadyExistsException;

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

public class VentanaTecnico {
    Controlador controlador = Controlador.getControlador();
    public void abrirVentanaRegistrarTecnico() {
        JFrame ventanaRegistrarTecnico = new JFrame("Registrar técnico");
        ventanaRegistrarTecnico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarTecnico.setLayout(new GridLayout(5, 2));

        JLabel lblNombreTecnico = new JLabel("Nombre");
        lblNombreTecnico.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtNombreTecnico = new JTextField();

        JLabel lblTipoDocumento = new JLabel("Tipo de documento");
        lblTipoDocumento.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtTipoDocumento = new JTextField();

        JLabel lblNumeroDocumento = new JLabel("Número de documento");
        lblNumeroDocumento.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtNumeroDocumento = new JTextField();

        JLabel lblSalarioBase = new JLabel("Salario Base");
        lblSalarioBase.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtSalarioBase = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarTecnico.add(lblNombreTecnico);
        ventanaRegistrarTecnico.add(txtNombreTecnico);
        ventanaRegistrarTecnico.add(lblTipoDocumento);
        ventanaRegistrarTecnico.add(txtTipoDocumento);
        ventanaRegistrarTecnico.add(lblNumeroDocumento);
        ventanaRegistrarTecnico.add(txtNumeroDocumento);
        ventanaRegistrarTecnico.add(lblSalarioBase);
        ventanaRegistrarTecnico.add(txtSalarioBase);

        ventanaRegistrarTecnico.add(new JLabel());
        ventanaRegistrarTecnico.add(panel);

        ventanaRegistrarTecnico.setVisible(true);
        ventanaRegistrarTecnico.pack();
        ventanaRegistrarTecnico.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNombreTecnico.getText().equals("") || txtTipoDocumento.getText().equals("") || txtNumeroDocumento.getText().equals("") || txtSalarioBase.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaRegistrarTecnico, "Alguno de los campos está vacío.");
                } else {
                    String nombre = txtNombreTecnico.getText();
                    String tipoDoc = txtTipoDocumento.getText();
                    String nroDoc = txtNumeroDocumento.getText();
                    float salarioBase = Float.parseFloat(txtSalarioBase.getText());
                    try {
                        controlador.registrarTecnico(nombre, tipoDoc, nroDoc, salarioBase);
                        JOptionPane.showMessageDialog(ventanaRegistrarTecnico, "El tecnico ha sido registrado exitosamente!");
                    } catch (TecnicoAlreadyExistsException ex) {
                        txtNombreTecnico.setText("");
                        txtTipoDocumento.setText("");
                        txtNumeroDocumento.setText("");
                        txtSalarioBase.setText("");
                        JOptionPane.showMessageDialog(ventanaRegistrarTecnico, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtNombreTecnico.setText("");
                txtTipoDocumento.setText("");
                txtNumeroDocumento.setText("");
                txtSalarioBase.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombreTecnico.setText("");
                txtTipoDocumento.setText("");
                txtNumeroDocumento.setText("");
                txtSalarioBase.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistrarTecnico.dispose();
            }
        });
    }
}