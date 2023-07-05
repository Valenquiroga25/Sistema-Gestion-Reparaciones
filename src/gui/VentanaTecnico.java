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

public class VentanaTecnico {

    public void abrirVentanaRegistrarTecnico() {
        JFrame ventanaRegistrarTecnico = new JFrame("Registrar técnico");
        ventanaRegistrarTecnico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarTecnico.setLayout(new GridLayout(4, 2));

        JLabel lblNombreTecnico = new JLabel("Nombre");
        lblNombreTecnico.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtNombreTecnico = new JTextField();

        JLabel lblEdadTecnico = new JLabel("Edad");
        lblEdadTecnico.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtEdadTecnico = new JTextField();

        JLabel lblCuitTecnico = new JLabel("Cuit");
        lblCuitTecnico.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtCuitTecnico = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarTecnico.add(lblCuitTecnico);
        ventanaRegistrarTecnico.add(txtCuitTecnico);
        ventanaRegistrarTecnico.add(lblNombreTecnico);
        ventanaRegistrarTecnico.add(txtNombreTecnico);
        ventanaRegistrarTecnico.add(lblEdadTecnico);
        ventanaRegistrarTecnico.add(txtEdadTecnico);
        ventanaRegistrarTecnico.add(new JLabel());
        ventanaRegistrarTecnico.add(panel);

        ventanaRegistrarTecnico.setVisible(true);
        ventanaRegistrarTecnico.pack();
        ventanaRegistrarTecnico.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCuitTecnico.getText().equals("") || txtNombreTecnico.getText().equals("") || txtEdadTecnico.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío.");
                    txtCuitTecnico.setText("");
                    txtNombreTecnico.setText("");
                    txtEdadTecnico.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Se aceptaron los datos.");
                    txtCuitTecnico.setText("");
                    txtNombreTecnico.setText("");
                    txtEdadTecnico.setText("");
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar los datos del cliente
                txtCuitTecnico.setText("");
                txtNombreTecnico.setText("");
                txtEdadTecnico.setText("");
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
