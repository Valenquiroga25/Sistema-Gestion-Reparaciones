package gui;

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

    public void abrirVentanaRegistrarReparacion() {
        JFrame ventanaRegistrarReparacion = new JFrame("Generar reparación");
        ventanaRegistrarReparacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarReparacion.setLayout(new GridLayout(5, 2));

        JLabel lblNroReparacion = new JLabel("Código de reparación");
        lblNroReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtNroReparacion = new JTextField();

        JLabel lblFechaReparacion = new JLabel("Fecha de reparación");
        lblFechaReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtFechaReparacion = new JTextField();

        JLabel lblVehiculo = new JLabel("Matricula del vehículo");
        lblVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtVehiculo = new JTextField();

        JLabel lblCliente = new JLabel("Documento del cliente");
        lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCliente = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarReparacion.add(lblNroReparacion);
        ventanaRegistrarReparacion.add(txtNroReparacion);
        ventanaRegistrarReparacion.add(lblFechaReparacion);
        ventanaRegistrarReparacion.add(txtFechaReparacion);
        ventanaRegistrarReparacion.add(lblVehiculo);
        ventanaRegistrarReparacion.add(txtVehiculo);
        ventanaRegistrarReparacion.add(lblCliente);
        ventanaRegistrarReparacion.add(txtCliente);
        ventanaRegistrarReparacion.add(new JLabel());
        ventanaRegistrarReparacion.add(panel);

        ventanaRegistrarReparacion.setVisible(true);
        ventanaRegistrarReparacion.pack();
        ventanaRegistrarReparacion.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNroReparacion.getText().equals("") || txtFechaReparacion.getText().equals("") || txtVehiculo.getText().equals("") || txtCliente.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío.");
                    txtNroReparacion.setText("");
                    txtFechaReparacion.setText("");
                    txtVehiculo.setText("");
                    txtCliente.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Se aceptaron los datos.");
                    txtNroReparacion.setText("");
                    txtFechaReparacion.setText("");
                    txtVehiculo.setText("");
                    txtCliente.setText("");
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar los datos del cliente
                txtNroReparacion.setText("");
                txtFechaReparacion.setText("");
                txtVehiculo.setText("");
                txtCliente.setText("");
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
