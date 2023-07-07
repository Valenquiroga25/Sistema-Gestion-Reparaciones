package gui;

import views.ClienteView;
import views.ReparacionView;

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
        panel.setBorder(BorderFactory.createEmptyBorder(2,3,2,3));
        panel.setLayout(new GridLayout(8,2));

        JButton btnRegistrarCliente = new JButton("Registrar cliente");
        JButton btnRegistrarVehiculo = new JButton("Registrar vehículo");
        JButton btnRegistrarReparacion = new JButton("Generar reparación");
        JButton btnRegistrarTecnico = new JButton("Registrar técnico");
        JButton btnRegistrarRepuesto = new JButton("Registrar repuesto");
        JButton btnRegistrarManoDeObra = new JButton("Registrar mano de obra");
        JButton btnAgregarRepuesto = new JButton("Agregar nuevo repuesto");
        JButton btnAgregarManoObra = new JButton("Agregar mano de obra");
        JButton btnCobrarReparacion= new JButton("Cobrar reparación");
        JButton btnCalcularSalarioTecnico = new JButton("Calcular salario de técnico");
        JButton btnCostoReparacion = new JButton("Costo de reparación");
        JButton btnTerminarReparacion = new JButton("Finalizar reparación");
        JButton btnBuscarCliente = new JButton("Buscar cliente");
        JButton btnBuscarReparacion = new JButton("Buscar reparación");

        VentanaCliente cliente = new VentanaCliente();
        VentanaVehiculo vehiculo = new VentanaVehiculo();
        VentanaReparacion reparacion = new VentanaReparacion();
        VentanaAgregarRepuesto AgregarRepuesto = new VentanaAgregarRepuesto();
        VentanaTecnico tecnico = new VentanaTecnico();
        VentanaAgregarManoDeObra AgregarManoDeObra = new VentanaAgregarManoDeObra();
        VentanaManoDeObra manoDeObra = new VentanaManoDeObra();
        VentanaRegistrarRepuesto repuesto = new VentanaRegistrarRepuesto();
        VentanaCobrarReparacion cobrarReparacion = new VentanaCobrarReparacion();
        VentanaCalcularSalarioTecnico calcularSalario = new VentanaCalcularSalarioTecnico();
        VentanaCostoReparacion costoReparacion = new VentanaCostoReparacion();
        VentanaFinalizarReparacion finalizarReparacion = new VentanaFinalizarReparacion();
        VentanaBuscarClienteView clienteView = new VentanaBuscarClienteView();
        VentanaBuscarReparacionView reparacionView = new VentanaBuscarReparacionView();

        ventanaMenu.add(lblBienvenida);
        ventanaMenu.add(panel);
        panel.add(btnRegistrarCliente);
        panel.add(btnRegistrarVehiculo);
        panel.add(btnRegistrarReparacion);
        panel.add(btnRegistrarTecnico);
        panel.add(btnRegistrarRepuesto);
        panel.add(btnRegistrarManoDeObra);
        panel.add(btnAgregarRepuesto);
        panel.add(btnAgregarManoObra);
        panel.add(btnCobrarReparacion);
        panel.add(btnCalcularSalarioTecnico);
        panel.add(btnCostoReparacion);
        panel.add(btnTerminarReparacion);
        panel.add(btnBuscarCliente);
        panel.add(btnBuscarReparacion);

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

        btnRegistrarRepuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repuesto.abrirVentanaRegistrarRepuesto();
            }
        });

        btnRegistrarManoDeObra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manoDeObra.abrirVentanaRegistrarManoDeObra();
            }
        });

        btnAgregarRepuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarRepuesto.abrirVentanaAgregarRepuesto();
            }
        });

        btnAgregarManoObra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarManoDeObra.abrirVentanaAgregarManoObra();
            }
        });

        btnCobrarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cobrarReparacion.abrirVentanaCobrarReparacion();
            }
        });

        btnCalcularSalarioTecnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSalario.abrirVentanaCalcularSalarioTecnico();
            }
        });

        btnCostoReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                costoReparacion.abrirVentanaCostoReparacion();
            }
        });

        btnTerminarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarReparacion.abrirVentanaFinalizarReparacion();
            }
        });

        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteView.abrirVentanaBuscarClienteView();
            }
        });

        btnBuscarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reparacionView.abrirVentanaBuscarReparacionView();
            }
        });
    }
}