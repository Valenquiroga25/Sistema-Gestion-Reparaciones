package gui;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaControlador extends JFrame {
    public VentanaControlador() {
        JFrame ventanaMenu = new JFrame("Menú");
        ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaMenu.setLayout(new GridLayout(2, 1));
        
        JLabel lblBienvenida = new JLabel("Bienvenido al Sistema");
        lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenida.setOpaque(true);
        lblBienvenida.setName("label");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2));
        JButton btnRegistrarCliente = new JButton("Registrar cliente");
        JButton btnRegistrarVehiculo = new JButton("Registrar vehículo");
        JButton btnRegistrarReparacion = new JButton("Generar reparación");
        JButton btnRegistrarTecnico = new JButton("Registrar técnico");
        JButton btnAgregarRepuesto = new JButton("Agregar nuevo repuesto");
        JButton btnAgregarManoObra = new JButton("Agregar mano de obra");
        
        VentanaCliente cliente = new VentanaCliente();
        VentanaVehiculo vehiculo = new VentanaVehiculo();
        VentanaReparacion reparacion = new VentanaReparacion();
        VentanaRepuesto repuesto = new VentanaRepuesto();
        VentanaTecnico tecnico = new VentanaTecnico();
        VentanaManoDeObra manoDeObra = new VentanaManoDeObra();
        
        ventanaMenu.add(lblBienvenida);
        ventanaMenu.add(panel);
        panel.add(btnRegistrarCliente);
        panel.add(btnRegistrarVehiculo);
        panel.add(btnRegistrarReparacion);
        panel.add(btnRegistrarTecnico);
        panel.add(btnAgregarRepuesto);
        panel.add(btnAgregarManoObra);

        ventanaMenu.setVisible(true);
        ventanaMenu.pack();
        ventanaMenu.setLocationRelativeTo(null);

        btnRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.abrirVentanaRegistrarCliente();
            }
        });

        btnRegistrarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculo.abrirVentanaRegistrarVehiculo();
            }
        });

        btnRegistrarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reparacion.abrirVentanaRegistrarReparacion();
            }
        });

        btnRegistrarTecnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tecnico.abrirVentanaRegistrarTecnico();
            }
        });

        btnAgregarRepuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repuesto.abrirVentanaAgregarRepuesto();
            }
        });

        btnAgregarManoObra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manoDeObra.abrirVentanaAgregarManoObra();
            }
        });
    }
}
