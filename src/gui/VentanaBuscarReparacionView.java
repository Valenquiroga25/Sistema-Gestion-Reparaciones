package gui;

import controlador.Controlador;
import excepciones.notFoundExceptions.ReparacionNotFoundException;
import views.ReparacionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBuscarReparacionView {
    Controlador controlador = Controlador.getControlador();
    public void abrirVentanaBuscarReparacionView(){
        JFrame ventanaBuscarReparacionView = new JFrame("Cliente");
        ventanaBuscarReparacionView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaBuscarReparacionView.setLayout(new GridLayout(1, 1));

        JLabel lblBuscarReparacion = new JLabel("Buscar Reparacion");
        lblBuscarReparacion.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtBuscarReparacion = new JTextField();

        JButton btnBuscar = new JButton("Buscar");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
        panel.setLayout(new GridLayout(1, 2));
        panel.add(lblBuscarReparacion);
        panel.add(txtBuscarReparacion);
        panel.add(btnBuscar);
        ventanaBuscarReparacionView.add(panel);

        ventanaBuscarReparacionView.setVisible(true);
        ventanaBuscarReparacionView.pack();
        ventanaBuscarReparacionView.setLocationRelativeTo(null);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtBuscarReparacion.getText().equals("")){
                    JOptionPane.showMessageDialog(ventanaBuscarReparacionView, "El campo está vacío.", "Error mostrando la reparacion", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    int codigoReparacion = Integer.parseInt(txtBuscarReparacion.getText());
                    try {
                        ReparacionView reparacionView = controlador.mostrarReparacionView(codigoReparacion);
                        JOptionPane.showMessageDialog(ventanaBuscarReparacionView, reparacionView.toString(), "Reparacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ReparacionNotFoundException ex) {
                        txtBuscarReparacion.setText("");
                        JOptionPane.showMessageDialog(ventanaBuscarReparacionView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtBuscarReparacion.setText("");
            }
        });
    }
}
