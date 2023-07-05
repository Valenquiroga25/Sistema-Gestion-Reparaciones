package Ventana;

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

public class VentanaRepuesto {

    public void abrirVentanaAgregarRepuesto() {
        JFrame ventanaAgregarRepuesto = new JFrame("Agregar nuevo repuesto");
        ventanaAgregarRepuesto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaAgregarRepuesto.setLayout(new GridLayout(4, 2));

        JLabel lblcodigoReparacion = new JLabel("Código de reparación");
        lblcodigoReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtcodigoReparacion = new JTextField();

        JLabel lblcodigoRepuesto = new JLabel("Código de repuesto");
        lblcodigoRepuesto.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtcodigoRepuesto = new JTextField();

        JLabel lblcantidad = new JLabel("Cantidad de unidades deseadas");
        lblcantidad.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtcantidad = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaAgregarRepuesto.add(lblcodigoReparacion);
        ventanaAgregarRepuesto.add(txtcodigoReparacion);
        ventanaAgregarRepuesto.add(lblcodigoRepuesto);
        ventanaAgregarRepuesto.add(txtcodigoRepuesto);
        ventanaAgregarRepuesto.add(lblcantidad);
        ventanaAgregarRepuesto.add(txtcantidad);

        ventanaAgregarRepuesto.add(new JLabel());
        ventanaAgregarRepuesto.add(panel);

        ventanaAgregarRepuesto.setVisible(true);
        ventanaAgregarRepuesto.pack();
        ventanaAgregarRepuesto.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtcodigoReparacion.getText().equals("") || txtcodigoRepuesto.getText().equals("") || txtcantidad.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío.");
                    txtcodigoReparacion.setText("");
                    txtcodigoRepuesto.setText("");
                    txtcantidad.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Se aceptaron los datos.");
                    txtcodigoReparacion.setText("");
                    txtcodigoRepuesto.setText("");
                    txtcantidad.setText("");
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar los datos del cliente
                txtcodigoReparacion.setText("");
                txtcodigoRepuesto.setText("");
                txtcantidad.setText("");
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
