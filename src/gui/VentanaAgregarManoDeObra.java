package gui;

import controlador.Controlador;
import excepciones.EstadoInvalidoException;
import excepciones.notFoundExceptions.ManoDeObraNotFoundException;
import excepciones.notFoundExceptions.ReparacionNotFoundException;
import excepciones.notFoundExceptions.TecnicoNotFoundEception;

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

public class VentanaAgregarManoDeObra {
    Controlador controlador = Controlador.getControlador();
    public void abrirVentanaAgregarManoObra() {
        JFrame ventanaAgregarManoObra = new JFrame("Agregar mano de obra");
        ventanaAgregarManoObra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaAgregarManoObra.setLayout(new GridLayout(5, 2));

        JLabel lblCodigoReparacion= new JLabel("Código de reparación");
        lblCodigoReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCodigoReparacion = new JTextField();

        JLabel lblCodigoManoObra = new JLabel("Código de mano de obra");
        lblCodigoManoObra.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCodigoManoObra = new JTextField();

        JLabel lblCantidadHoras = new JLabel("Cantidad de horas");
        lblCantidadHoras.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtCantidadHoras = new JTextField();

        JLabel lblDocumentoTecnico = new JLabel("Documento del técnico");
        lblDocumentoTecnico.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtDocumentoTecnico = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaAgregarManoObra.add(lblCodigoReparacion);
        ventanaAgregarManoObra.add(txtCodigoReparacion);
        ventanaAgregarManoObra.add(lblCodigoManoObra);
        ventanaAgregarManoObra.add(txtCodigoManoObra);
        ventanaAgregarManoObra.add(lblCantidadHoras);
        ventanaAgregarManoObra.add(txtCantidadHoras);
        ventanaAgregarManoObra.add(lblDocumentoTecnico);
        ventanaAgregarManoObra.add(txtDocumentoTecnico);
        
        ventanaAgregarManoObra.add(new JLabel());
        ventanaAgregarManoObra.add(panel);

        ventanaAgregarManoObra.setVisible(true);
        ventanaAgregarManoObra.pack();
        ventanaAgregarManoObra.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigoReparacion.getText().equals("") || txtCodigoManoObra.getText().equals("") || txtCantidadHoras.getText().equals("") || txtDocumentoTecnico.getText().equals("")){
                    JOptionPane.showMessageDialog(ventanaAgregarManoObra, "Alguno de los campos está vacío.");
                } else {
                    int codigoReparacion = Integer.parseInt(txtCodigoReparacion.getText());
                    int codigoManoDeObra = Integer.parseInt(txtCodigoManoObra.getText());
                    int cantidadHoras = Integer.parseInt(txtCantidadHoras.getText());
                    String nroDocumentoTecnico = txtDocumentoTecnico.getText();
                    try {
                        controlador.agregarManoDeObra(codigoReparacion, codigoManoDeObra, cantidadHoras, nroDocumentoTecnico);
                        JOptionPane.showMessageDialog(ventanaAgregarManoObra, "La mano de obra ha sido agregada exitosamente!");
                    } catch (ReparacionNotFoundException | ManoDeObraNotFoundException | TecnicoNotFoundEception |
                             EstadoInvalidoException ex) {
                        txtCodigoReparacion.setText("");
                        txtCodigoManoObra.setText("");
                        txtCantidadHoras.setText("");
                        txtDocumentoTecnico.setText("");
                        JOptionPane.showMessageDialog(ventanaAgregarManoObra, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtCodigoReparacion.setText("");
                txtCodigoManoObra.setText("");
                txtCantidadHoras.setText("");
                txtDocumentoTecnico.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar los datos del cliente
                txtCodigoReparacion.setText("");
                txtCodigoManoObra.setText("");
                txtCantidadHoras.setText("");
                txtDocumentoTecnico.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAgregarManoObra.dispose();
            }
        });
    }
}
