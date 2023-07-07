
package gui;

import controlador.Controlador;
import excepciones.MesInvalidoException;
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

public class VentanaCalcularSalarioTecnico {
    public Controlador controlador = Controlador.getControlador();
    public void abrirVentanaCalcularSalarioTecnico() {
        JFrame ventanaCobrarReparacion = new JFrame("Calcular Salario");
        ventanaCobrarReparacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaCobrarReparacion.setLayout(new GridLayout(3, 2));

        JLabel lblDocumento = new JLabel("Documento del tecnico");
        lblDocumento.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtDocumento = new JTextField();

        JLabel lblMes = new JLabel("Mes a calcular");
        lblMes.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        JTextField txtMes = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaCobrarReparacion.add(lblDocumento);
        ventanaCobrarReparacion.add(txtDocumento);
        ventanaCobrarReparacion.add(lblMes);
        ventanaCobrarReparacion.add(txtMes);
        ventanaCobrarReparacion.add(new JLabel());
        ventanaCobrarReparacion.add(panel);

        ventanaCobrarReparacion.setVisible(true);
        ventanaCobrarReparacion.pack();
        ventanaCobrarReparacion.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDocumento.getText().equals("") || txtMes.getText().equals("")) {
                    JOptionPane.showMessageDialog(ventanaCobrarReparacion, "El campo está vacío.", "Error encontrando técnico", JOptionPane.ERROR_MESSAGE);
                } else {
                    String nroDocumento = txtDocumento.getText();
                    int mes = Integer.parseInt(txtMes.getText());
                    try {
                        float salarioTecnico = controlador.calcularSalarioTecnico(nroDocumento, mes);
                        JOptionPane.showMessageDialog(ventanaCobrarReparacion, "El salario del tecnico en el mes: " + mes + " es de: " + salarioTecnico, "Salario calculado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (MesInvalidoException | TecnicoNotFoundEception ex) {
                        txtDocumento.setText("");
                        txtMes.setText("");
                        JOptionPane.showMessageDialog(ventanaCobrarReparacion, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
                txtDocumento.setText("");
                txtMes.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDocumento.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCobrarReparacion.dispose();
            }
        });
    }
}
