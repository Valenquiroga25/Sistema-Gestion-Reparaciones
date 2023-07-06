package gui;

import controlador.Controlador;
import excepciones.notFoundExceptions.ReparacionNotFoundException;
import excepciones.notFoundExceptions.RepuestoNotFoundException;

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

public class VentanaAgregarRepuesto {
    Controlador controlador = Controlador.getControlador();
    public void abrirVentanaAgregarRepuesto() {
        JFrame ventanaAgregarRepuesto = new JFrame("Agregar Repuesto");
        ventanaAgregarRepuesto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaAgregarRepuesto.setLayout(new GridLayout(4, 2));

        JLabel lblCodigoReparacion = new JLabel("Código de reparación");
        lblCodigoReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCodigoReparacion = new JTextField();

        JLabel lblCodigoRepuesto = new JLabel("Código de repuesto");
        lblCodigoRepuesto.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCodigoRepuesto = new JTextField();

        JLabel lblCantidad = new JLabel("Cantidad de unidades deseadas");
        lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCantidad = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaAgregarRepuesto.add(lblCodigoReparacion);
        ventanaAgregarRepuesto.add(txtCodigoReparacion);
        ventanaAgregarRepuesto.add(lblCodigoRepuesto);
        ventanaAgregarRepuesto.add(txtCodigoRepuesto);
        ventanaAgregarRepuesto.add(lblCantidad);
        ventanaAgregarRepuesto.add(txtCantidad);

        ventanaAgregarRepuesto.add(new JLabel());
        ventanaAgregarRepuesto.add(panel);

        ventanaAgregarRepuesto.setVisible(true);
        ventanaAgregarRepuesto.pack();
        ventanaAgregarRepuesto.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigoReparacion.getText().equals("") || txtCodigoRepuesto.getText().equals("") || txtCantidad.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaAgregarRepuesto, "Alguno de los campos está vacío.");
                } else {
                    int codigoReparacion = Integer.parseInt(txtCodigoReparacion.getText());
                    int codigoRepuesto = Integer.parseInt(txtCodigoRepuesto.getText());
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    try {
                        controlador.agregarRepuesto(codigoReparacion, codigoRepuesto, cantidad);
                        JOptionPane.showMessageDialog(ventanaAgregarRepuesto, "El repuesto ha sido agregado exitosamente!");
                    } catch (RepuestoNotFoundException | ReparacionNotFoundException ex) {
                        txtCodigoReparacion.setText("");
                        txtCodigoRepuesto.setText("");
                        txtCantidad.setText("");
                        JOptionPane.showMessageDialog(ventanaAgregarRepuesto, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtCodigoReparacion.setText("");
                txtCodigoRepuesto.setText("");
                txtCantidad.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar los datos del cliente
                txtCodigoReparacion.setText("");
                txtCodigoRepuesto.setText("");
                txtCantidad.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAgregarRepuesto.dispose();
            }
        });
    }
}
