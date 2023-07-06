package main;

import controlador.Controlador;
import excepciones.EstadoInvalidoException;
import excepciones.LimiteCreditoInsuficienteException;
import excepciones.MesInvalidoException;
import excepciones.alreadyExistsExceptions.*;
import excepciones.notFoundExceptions.*;
import gui.VentanaControlador;

public class Main {
    public static void main(String[] args) throws VehiculoAlreadyExistsException, VehiculoNotFoundException, ClienteAlreadyExistsException, TecnicoAlreadyExistsException, RepuestoAlreadyExistsException, ManoDeObraAlreadyExistsException, ClienteNotFoundException, ReparacionNotFoundException, RepuestoNotFoundException, TecnicoNotFoundEception, ManoDeObraNotFoundException, MesInvalidoException, EstadoInvalidoException, LimiteCreditoInsuficienteException {
        Controlador controlador = Controlador.getControlador();
        // registrar 3 vehiculos
        controlador.registrarVehiculo("KAI378", "Nissan", "Tiida", 2013);
        controlador.registrarVehiculo("AB938JL", "Citroen", "C4", 2018);
        controlador.registrarVehiculo("PLA121", "Mustang", "Mach 1", 2021);

        // registrar de 3 clientes
        controlador.registrarCliente("Valentin Quiroga", "DNI", "12312312", 25_000f, 10_000f, "KAI378");
        controlador.registrarCliente("Julian Serrano", "DNI", "98798798", 70_000f, 20_000f, "AB938JL");
        controlador.registrarCliente("Ramiro Landajo", "DNI", "44729962", 100_000f, 50_000f, "PLA121");

        // registrar 3 tecnicos
        controlador.registrarTecnico("Ivo Bandoni", "DNI", "43243243", 80_000f);
        controlador.registrarTecnico("Claudio Godio", "DNI", "13213213", 150_000f);
        controlador.registrarTecnico("Lionel Messi", "DNI", "10101010", 1_000_000f);

        // registrar 3 repuestos
        controlador.registrarRepuesto(123456, "Optica Nissan Tiida", 25_000f);
        controlador.registrarRepuesto(987654, "Parabrisas Citroen C4", 60_000f);
        controlador.registrarRepuesto(102030, "Llanta Mustang Mach 1", 40_000f);

        // registrar 3 manos de obra
        controlador.registrarManoDeObra(100, "Remplazo de optica", 10_000f);
        controlador.registrarManoDeObra(200, "Remplazo de parabrisas", 15_000f);
        controlador.registrarManoDeObra(300, "Remplazo de llanta", 5_000f);

        // registrar 3 reparaciones
        controlador.generarReparacion("2023-07-06", "12312312", "KAI378");
        controlador.generarReparacion("2023-07-05", "98798798", "AB938JL");
        controlador.generarReparacion("2023-07-04", "44729962", "PLA121");

        controlador.agregarRepuesto(1,123456, 1);
        controlador.agregarRepuesto(2,987654, 1);
        controlador.agregarRepuesto(3,102030, 2);

        controlador.agregarManoDeObra(1, 100, 1, "43243243");
        controlador.agregarManoDeObra(2, 200, 2, "13213213");
        controlador.agregarManoDeObra(3, 300, 1, "10101010");

        // cobrar reparaciones
//        controlador.terminarReparacion(3);
//        controlador.terminarReparacion(2);
//        controlador.terminarReparacion(1);
//        System.out.println("cliente 3 cuenta: " + controlador.buscarCliente("44729962").getCuentaCorriente());
//        System.out.println(controlador.costoReparacion(3));
//        controlador.cobrarReparacion(3);
//        System.out.println("cliente 3 cuenta: " + controlador.buscarCliente("44729962").getCuentaCorriente());
//
//        System.out.println("cliente 2 cuenta: " + controlador.buscarCliente("98798798").getCuentaCorriente());
//        System.out.println(controlador.costoReparacion(2));
//        controlador.cobrarReparacion(2);
//        System.out.println("cliente 2 cuenta: " + controlador.buscarCliente("98798798").getCuentaCorriente());
//
//        System.out.println("cliente 1 cuenta: " + controlador.buscarCliente("12312312").getCuentaCorriente());
//        System.out.println(controlador.costoReparacion(1));
//        controlador.cobrarReparacion(1);
//        System.out.println("cliente 1 cuenta: " + controlador.buscarCliente("12312312").getCuentaCorriente());



        new VentanaControlador();
    }
}
