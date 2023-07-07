package gui;

import controlador.Controlador;
import excepciones.notFoundExceptions.ClienteNotFoundException;
import views.ClienteView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBuscarClienteView {
    Controlador controlador = Controlador.getControlador();
    public void abrirVentanaBuscarClienteView(){
        JFrame ventanaMostrarClienteView = new JFrame("Cliente");
        ventanaMostrarClienteView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaMostrarClienteView.setLayout(new GridLayout(1, 1));

        JLabel lblBuscarCliente = new JLabel("Buscar Cliente");
        lblBuscarCliente.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtBuscarCliente = new JTextField();

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
        panel.setLayout(new GridLayout(1, 2));
        panel.add(lblBuscarCliente);
        panel.add(txtBuscarCliente);
        panel.add(btnBuscar);
        ventanaMostrarClienteView.add(panel);

        ventanaMostrarClienteView.setVisible(true);
        ventanaMostrarClienteView.pack();
        ventanaMostrarClienteView.setLocationRelativeTo(null);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtBuscarCliente.getText().equals("")){
                    JOptionPane.showMessageDialog(ventanaMostrarClienteView, "Alguno de los campos está vacío.", "Error mostrando el cliente", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        ClienteView clienteView = controlador.mostrarClienteView(txtBuscarCliente.getText());
                        JOptionPane.showMessageDialog(ventanaMostrarClienteView, clienteView.toString(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ClienteNotFoundException ex) {
                        txtBuscarCliente.setText("");
                        JOptionPane.showMessageDialog(ventanaMostrarClienteView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtBuscarCliente.setText("");
            }
        });
    }
}
