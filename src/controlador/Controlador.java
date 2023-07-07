package controlador;

import excepciones.EstadoInvalidoException;
import excepciones.LimiteCreditoInsuficienteException;
import excepciones.MesInvalidoException;
import excepciones.alreadyExistsExceptions.*;
import excepciones.notFoundExceptions.*;
import modelos.*;
import views.ClienteView;
import views.ReparacionView;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controlador {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final List<Cliente> clientes;
    private final List<ManoDeObra> manosDeObra;
    private final List<Reparacion> reparaciones;
    private final List<Repuesto> repuestos;
    private final List<Tecnico> tecnicos;
    private final List<Vehiculo> vehiculos;

    private static Controlador controlador;
    private Controlador(){
        clientes = new ArrayList<>();
        manosDeObra = new ArrayList<>();
        reparaciones = new ArrayList<>();
        repuestos = new ArrayList<>();
        tecnicos = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }
    public static Controlador getControlador(){
        if (controlador == null){
            controlador = new Controlador();
        }
        return controlador;
    }

    public void registrarCliente(String nombre, String tipoDocumento, String nroDocumento, float cuentaCorriente, float limiteCuentaCorriente, String matriculaVehiculo) throws ClienteAlreadyExistsException, VehiculoNotFoundException {
        Optional<Cliente> clienteOp = Optional.ofNullable(buscarCliente(nroDocumento));
        if (clienteOp.isPresent()){
            throw new ClienteAlreadyExistsException("El cliente que esta intentando registrar, ya se encuentra registrado");
        }
        Optional<Vehiculo> vehiculoOp = Optional.ofNullable(buscarVehiculo(matriculaVehiculo));
        if (vehiculoOp.isEmpty()){
            throw new VehiculoNotFoundException("El vehiculo de matricula " + matriculaVehiculo + " no se encuentra registrado en nuestra base de datos");
        }
        Vehiculo vehiculo = vehiculoOp.get();
        Cliente nuevoCliente = new Cliente(nombre, tipoDocumento, nroDocumento, cuentaCorriente, limiteCuentaCorriente, vehiculo);
        clientes.add(nuevoCliente);
        System.out.println("El cliente ha sido registrado exitosamente!" + nuevoCliente.toString());

    }
    public void registrarVehiculo(String matricula, String marca, String modelo, int anio) throws VehiculoAlreadyExistsException {
        Optional<Vehiculo> vehiculoOp = Optional.ofNullable(buscarVehiculo(matricula));
        if (vehiculoOp.isPresent()){
            throw new VehiculoAlreadyExistsException("El vehiculo que esta intentando registrar ya se encuentra registrado");
        }
        else {
            Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, Year.of(anio));
            vehiculos.add(nuevoVehiculo);
            System.out.println("El vehiculo ha sido registrado exitosamente! " + nuevoVehiculo.toString());
        }
    }
    public void registrarTecnico(String nombre, String tipoDocumento, String nroDocumento, float salarioBase) throws TecnicoAlreadyExistsException {
        Optional<Tecnico> tecnicoOp = Optional.ofNullable(buscarTecnico(nroDocumento));
        if (tecnicoOp.isPresent()){
            throw new TecnicoAlreadyExistsException("El tecnico que esta intentando registrar ya se encuentra registrado");
        }
        else {
            Tecnico nuevoTecnico = new Tecnico(nombre, tipoDocumento, nroDocumento, salarioBase);
            tecnicos.add(nuevoTecnico);
            System.out.println("El tecnico ha sido registrado exitosamente! " + nuevoTecnico.toString());
        }
    }
    public void registrarManoDeObra(int codigoManoDeObra, String descripcion, float precioPorHora) throws ManoDeObraAlreadyExistsException {
        Optional<ManoDeObra> manoDeObraOp = Optional.ofNullable(buscarManoDeObra(codigoManoDeObra));
        if (manoDeObraOp.isPresent()){
            throw new ManoDeObraAlreadyExistsException("La mano de obra que esta intentando registrar ya se encuentra registrada");
        }
        else {
            ManoDeObra nuevaManoDeObra = new ManoDeObra(codigoManoDeObra, descripcion, precioPorHora);
            manosDeObra.add(nuevaManoDeObra);
            System.out.println("La mano de obra ha sido registrada exitosamente! " + nuevaManoDeObra.toString());
        }
    }
    public void registrarRepuesto(int codigoRepuesto, String descripcion, float precio) throws RepuestoAlreadyExistsException {
        Optional<Repuesto> repuestoOp = Optional.ofNullable(buscarRepuesto(codigoRepuesto));
        if (repuestoOp.isPresent()){
            throw new RepuestoAlreadyExistsException("El repuesto que esta intentando registrar ya se encuentra registrado");
        }
        else {
            Repuesto nuevoRepuesto = new Repuesto(codigoRepuesto, descripcion, precio);
            repuestos.add(nuevoRepuesto);
            System.out.println("El repuesto ha sido registrado exitosamente! " + nuevoRepuesto.toString());
        }
    }
    public void generarReparacion(String fecha, String nroDocumentoCliente, String matricula) throws ClienteNotFoundException, VehiculoNotFoundException {
        Optional<Cliente> clienteOp = Optional.ofNullable(buscarCliente(nroDocumentoCliente));
        if (clienteOp.isEmpty()){
            throw new ClienteNotFoundException("El cliente de documento: " + nroDocumentoCliente + " no se encuentra en nuestra base de datos");
        }
        else {
            Optional<Vehiculo> vehiculoOp = Optional.ofNullable(buscarVehiculo(matricula));
            if (vehiculoOp.isEmpty()){
                throw new VehiculoNotFoundException("El cliente de matricula: " + matricula + " no se encuentra en nuestra base de datos");
            }
            else {
                Cliente cliente = clienteOp.get();
                Vehiculo vehiculo = vehiculoOp.get();
                Reparacion nuevaReparacion = new Reparacion(LocalDate.parse(fecha, formatter), cliente, vehiculo);
                reparaciones.add(nuevaReparacion);
                System.out.println("La reparacion codigo: " + nuevaReparacion.getCodigoReparacion() + " ha sido creada exitosamente");
            }
        }
    }
    public float cobrarReparacion(int codigoReparacion) throws Exception {
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isPresent()){
            Reparacion reparacion = reparacionOp.get();
            if (reparacion.reparacionTerminada()){
                float totalCobrar = reparacion.calcularCostoReparacion();
                Cliente cliente = reparacion.getCliente();
                if (!limiteCreditoSuficiente(reparacion.getCodigoReparacion())){
                    throw new LimiteCreditoInsuficienteException("El credito que tiene en la cuenta es insuficiente");
                }
                else {
                    System.out.println("Balance del cliente: " + cliente.getCuentaCorriente());
                    cliente.pagarReparacion(totalCobrar);
                    System.out.println("La reparacion: " + reparacion.getCodigoReparacion() + " ha sido abonada exitosamente");
                    System.out.println("Balance nuevo del cliente: " + cliente.getCuentaCorriente());
                    return totalCobrar;
                }
            }
            else {
                throw new Exception("El estado de la reparacion aun no se encuentra marcada como \"Terminada\"");
            }
        }
        else {
            throw new ReparacionNotFoundException("La reparacion de codigo: " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
    }
    public float costoReparacion(int codigoReparacion) throws ReparacionNotFoundException {
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isPresent()){
            Reparacion reparacion = reparacionOp.get();
            System.out.println("El costo de la reparacion es de: " + reparacion.calcularCostoReparacion());
            return reparacion.calcularCostoReparacion();
        }
        else {
            throw new ReparacionNotFoundException("La reparacion de codigo: " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
    }
    public float calcularSalarioTecnico(String nroDocumento, int mes) throws MesInvalidoException, TecnicoNotFoundEception {
        Optional<Tecnico> tecnicoOp = Optional.ofNullable(buscarTecnico(nroDocumento));
        if (tecnicoOp.isPresent()){
            Tecnico tecnico = tecnicoOp.get();
            System.out.println("El salario del tecnico en el mes: " + mes + " es de: " + tecnico.calcularSueldo(mes));
            return tecnico.calcularSueldo(mes);
        }
        else {
            throw new TecnicoNotFoundEception("El tecnico de numero de documento: " + nroDocumento + " no se encuentra en nuestra base de datos");
        }
    }
    public void agregarRepuesto(int codigoReparacion, int codigoRepuesto, int cantidad) throws RepuestoNotFoundException, ReparacionNotFoundException {
        if (cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isPresent()){
            Optional<Repuesto> repuestoOp = Optional.ofNullable(buscarRepuesto(codigoRepuesto));
            if (repuestoOp.isPresent()){
                Reparacion reparacion = reparacionOp.get();
                Repuesto repuesto = repuestoOp.get();
                reparacion.agregarRepuesto(repuesto, cantidad);
                System.out.println("El repuesto ha sido agregado exitosamente!");
            }
            else {
                throw new RepuestoNotFoundException("El repuesto de codigo: " + codigoRepuesto + " no se encuentra en nuestra base de datos");
            }
        }
        else {
            throw new ReparacionNotFoundException("La reparacion de codigo: " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
    }
    public void agregarManoDeObra(int codigoReparacion, int codigoManoDeObra, int cantidadHoras, String nroDocumentoTecnico) throws ReparacionNotFoundException, ManoDeObraNotFoundException, TecnicoNotFoundEception, EstadoInvalidoException {
        if (cantidadHoras <= 0){
            throw new IllegalArgumentException("La cantidad de horas debe ser mayor a 0");
        }
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isEmpty()) {
            throw new ReparacionNotFoundException("La reparacion de codigo " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
        Optional<ManoDeObra>  manoDeObraOp = Optional.ofNullable(buscarManoDeObra(codigoManoDeObra));
        if (manoDeObraOp.isEmpty()) {
            throw new ManoDeObraNotFoundException("La mano de obra de codigo " + codigoManoDeObra + " no se encuentra en nuestra base de datos");
        }
        Optional<Tecnico> tecnicoOp = Optional.ofNullable(buscarTecnico(nroDocumentoTecnico));
        if (tecnicoOp.isEmpty()) {
            throw new TecnicoNotFoundEception("El tecnico de numero de documento " + nroDocumentoTecnico + " no se encuentra en nuestra base de datos");
        }
        Reparacion reparacion = reparacionOp.get();
        ManoDeObra manoDeObra = manoDeObraOp.get();
        Tecnico tecnico = tecnicoOp.get();
        reparacion.modificarEstado("En proceso");
        reparacion.agregarManoDeObra(manoDeObra, cantidadHoras, tecnico);
        tecnico.agregarReparacion(reparacion);
        tecnico.agregarManoDeObra(manoDeObra);
        System.out.println("La mano de obra ha sido agregada exitosamente!");
    }
    public void terminarReparacion(int codigoReparacion) throws EstadoInvalidoException, ReparacionNotFoundException {
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isPresent()){
            Reparacion reparacion = reparacionOp.get();
            reparacion.modificarEstado("Terminada");
        }
        else {
            throw new ReparacionNotFoundException("La reparacion de codigo: " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
    }

    // metodos para mostrar views
    public ClienteView mostrarClienteView(String nroDocumentoCliente) throws ClienteNotFoundException {
        Optional<Cliente> clienteOp = Optional.ofNullable(buscarCliente(nroDocumentoCliente));
        if (clienteOp.isEmpty()){
            throw new ClienteNotFoundException("El cliente de numero de documento: " + nroDocumentoCliente + " no se encuentra registrado en nuestra base de datos");
        }
        Cliente cliente = clienteOp.get();
        ClienteView clienteView = new ClienteView(cliente.getNombre(), cliente.getTipoDocumento(), cliente.getNroDocumento(),
                cliente.getCuentaCorriente(), cliente.getLimiteCuentaCorriente(),cliente.getVehiculo());
        return clienteView;
    }
    public ReparacionView mostrarReparacionView(int codigoReparacion) throws ReparacionNotFoundException {
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isEmpty()){
            throw new ReparacionNotFoundException("La reparacion de codigo: " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
        Reparacion reparacion = reparacionOp.get();
        ReparacionView reparacionView = new ReparacionView(reparacion.getCodigoReparacion(), reparacion.getFecha(), reparacion.getEstado(), reparacion.getCliente(), reparacion.getVehiculo());
        return reparacionView;
    }
    // metodos privados

    private boolean limiteCreditoSuficiente(int codigoReparacion) throws ReparacionNotFoundException {
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isPresent()){
            Reparacion reparacion = reparacionOp.get();
            Cliente cliente = reparacion.getCliente();
            float precioReparacion = reparacion.calcularCostoReparacion();
            return cliente.limiteCreditoSuficiente(precioReparacion);
        }
        else {
            throw new ReparacionNotFoundException("La reparacion de codigo: " + codigoReparacion + " no se encuentra en nuestra base de datos");
        }
    }
    private Cliente buscarCliente(String nroDocumento){
        for (Cliente cliente: clientes){
            if (cliente.soyEseCliente(nroDocumento)){
                return cliente;
            }
        }
        return null;
    }
    private Vehiculo buscarVehiculo(String matricula){
        for (Vehiculo vehiculo: vehiculos){
            if (vehiculo.soyEseVehiculo(matricula)){
                return vehiculo;
            }
        }
        return null;
    }
    private Tecnico buscarTecnico(String nroDocumento){
        for (Tecnico tecnico: tecnicos){
            if (tecnico.soyEseTecnico(nroDocumento)){
                return tecnico;
            }
        }
        return null;
    }
    private Reparacion buscarReparacion(int codigoReparacion){
        for (Reparacion reparacion: reparaciones){
            if (reparacion.soyEsaReparacion(codigoReparacion)){
                return reparacion;
            }
        }
        return null;
    }
    private Repuesto buscarRepuesto(int codigoRepuesto){
        for (Repuesto repuesto: repuestos){
            if (repuesto.soyEseRepuesto(codigoRepuesto)){
                return repuesto;
            }
        }
        return null;
    }
    private ManoDeObra buscarManoDeObra(int codigoManoDeObra){
        for (ManoDeObra manoDeObra: manosDeObra){
            if (manoDeObra.soyEsaManoDeObra(codigoManoDeObra)){
                return manoDeObra;
            }
        }
        return null;
    }
}
