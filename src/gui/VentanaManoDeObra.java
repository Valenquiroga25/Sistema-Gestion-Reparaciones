package gui;

import controlador.Controlador;
import excepciones.alreadyExistsExceptions.ManoDeObraAlreadyExistsException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaManoDeObra {

    public Controlador controlador = Controlador.getControlador();

    public void abrirVentanaRegistrarManoDeObra() {
        JFrame ventanaRegistrarManoDeObra = new JFrame("Registrar cliente");
        ventanaRegistrarManoDeObra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarManoDeObra.setLayout(new GridLayout(4, 2));

        JLabel lblcodigoManoDeObra = new JLabel("Código");
        lblcodigoManoDeObra.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtCodigoManoDeObra = new JTextField();

        JLabel lblDescripcion = new JLabel("Descipción");
        lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtDescripcion = new JTextField();

        JLabel lblprecioPorHora = new JLabel("Precio por hora");
        lblprecioPorHora.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtPrecioPorHora = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarManoDeObra.add(lblcodigoManoDeObra);
        ventanaRegistrarManoDeObra.add(txtCodigoManoDeObra);
        ventanaRegistrarManoDeObra.add(lblDescripcion);
        ventanaRegistrarManoDeObra.add(txtDescripcion);
        ventanaRegistrarManoDeObra.add(lblprecioPorHora);
        ventanaRegistrarManoDeObra.add(txtPrecioPorHora);
        ventanaRegistrarManoDeObra.add(new JLabel());
        ventanaRegistrarManoDeObra.add(panel);

        ventanaRegistrarManoDeObra.setVisible(true);
        ventanaRegistrarManoDeObra.pack();
        ventanaRegistrarManoDeObra.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigoManoDeObra.getText().equals("") || txtDescripcion.getText().equals("") || txtPrecioPorHora.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaRegistrarManoDeObra, "Alguno de los campos está vacío.", "Error registrando el cliente", JOptionPane.ERROR_MESSAGE);

                } else {
                    int codigo = Integer.parseInt(txtCodigoManoDeObra.getText());
                    String descripcion = txtDescripcion.getText();
                    float precio = Float.parseFloat(txtPrecioPorHora.getText());

                    try {
                        controlador.registrarManoDeObra(codigo, descripcion, precio);
                        JOptionPane.showMessageDialog(ventanaRegistrarManoDeObra,"La mano de obra ha sido registrado exitosamente!", "Mano de obra registrada", JOptionPane.INFORMATION_MESSAGE);

                    } catch (ManoDeObraAlreadyExistsException ex) {
                        txtCodigoManoDeObra.setText("");
                        txtDescripcion.setText("");
                        txtPrecioPorHora.setText("");
                        JOptionPane.showMessageDialog(ventanaRegistrarManoDeObra,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }

                txtCodigoManoDeObra.setText("");
                txtDescripcion.setText("");
                txtPrecioPorHora.setText("");
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
                txtCodigoManoDeObra.setText("");
                txtDescripcion.setText("");
                txtPrecioPorHora.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistrarManoDeObra.dispose();
            }
        });
    }
}