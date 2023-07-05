package controlador;

import excepciones.LimiteCreditoInsuficienteException;
import excepciones.alreadyExistsExceptions.ClienteAlreadyExistsException;
import excepciones.alreadyExistsExceptions.VehiculoAlreadyExistsException;
import excepciones.notFoundExceptions.ClienteNotFoundException;
import excepciones.notFoundExceptions.VehiculoNotFoundException;
import modelos.*;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Controlador {
    private List<Cliente> clientes;
    private List<ManoDeObra> manosDeObra;
    private List<Reparacion> reparaciones;
    private List<Repuesto> repuestos;
    private List<Tecnico> tecnicos;
    private List<Vehiculo> vehiculos;

    private static Controlador controlador;
    private Controlador(){}
    public static Controlador getControlador(){
        return controlador;
    }
    public void registrarCliente(String nombre, String tipoDocumento, String nroDocumento, float cuentaCorriente, float limiteCuentaCorriente, Vehiculo vehiculo) throws ClienteAlreadyExistsException {
        Optional<Cliente> clienteOp = Optional.ofNullable(buscarCliente(nroDocumento));
        if (clienteOp.isPresent()){
            throw new ClienteAlreadyExistsException("El cliente que esta intentando registrar, ya se encuentra registrado");
        }
        else {
            Cliente nuevoCliente = new Cliente(nombre, tipoDocumento, nroDocumento, cuentaCorriente, limiteCuentaCorriente, vehiculo);
            clientes.add(nuevoCliente);
            System.out.println("El cliente ha sido registrado exitosamente!");
        }
    }
    public void registrarVehiculo(String matricula, String marca, String modelo, Year anio) throws VehiculoAlreadyExistsException {
        Optional<Vehiculo> vehiculoOp = Optional.ofNullable(buscarVehiculo(matricula));
        if (vehiculoOp.isPresent()){
            throw new VehiculoAlreadyExistsException("El vehiculo que esta intentando registrar, ya se encuentra registrado");
        }
        else {
            Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, anio);
            vehiculos.add(nuevoVehiculo);
            System.out.println("El vehiculo ha sido registrado exitosamente!");
        }
    }
    public void generarReparacion(LocalDate fecha, String nroDocumento, String matricula) throws ClienteNotFoundException, VehiculoNotFoundException {
        Optional<Cliente> clienteOp = Optional.ofNullable(buscarCliente(nroDocumento));
        if (clienteOp.isEmpty()){
            throw new ClienteNotFoundException("El cliente de documento: " + nroDocumento + " no se encuentra en nuestra base de datos");
        }
        else{
            Optional<Vehiculo> vehiculoOp = Optional.ofNullable(buscarVehiculo(matricula));
            if (vehiculoOp.isEmpty()){
                throw new VehiculoNotFoundException("El cliente de matricula: " + matricula + " no se encuentra en nuestra base de datos");
            }
            else {
                Reparacion nuevaReparacion = new Reparacion(fecha, buscarCliente(nroDocumento), buscarVehiculo(matricula));
                reparaciones.add(nuevaReparacion);
                System.out.println("La reparacion codigo: " + nuevaReparacion.getCodigoReparacion() + " ha sido creada exitosamente");
            }
        }
    }
    public void cobrarReparacion(int codigoReparacion) throws LimiteCreditoInsuficienteException {
        Optional<Reparacion> reparacionOp = Optional.ofNullable(buscarReparacion(codigoReparacion));
        if (reparacionOp.isPresent()){
            Reparacion reparacion = reparacionOp.get();
            float totalCobrar = reparacion.calcularCostoReparacion();
            Cliente cliente = reparacion.getCliente();
            if (!limiteCreditoSuficiente(totalCobrar, cliente.getNroDocumento())){
                throw new LimiteCreditoInsuficienteException("El credito que tiene en la cuenta es insuficiente");
            }
            else {
                cliente.pagarReparacion(totalCobrar);
                System.out.println("La reparacion: " + reparacion.getCodigoReparacion() + " ha sido abonada exitosamente");
            }
        }
    }
    public float costoReparacion(int codigoReparacion){
        return 0.0f;
    }
    public float calcularSalarioTecnico(String nroDocumento){
        return 0.0f;
    }
    public void agregarRepuesto(int codigoReparacion, int codigoRepuesto, int cantidad){

    }
    public void agregarManoDeObra(int codigoReparacion, int codigoRepuesto, int cantidadHoras){

    }

    private boolean limiteCreditoSuficiente(float precioReparacion, String nroDocumentoCliente){
        return false;
    }
    private Cliente buscarCliente(String nroDocumento){
        return null;
    }
    private Vehiculo buscarVehiculo(String matricula){
        return null;
    }
    private Tecnico buscarTecnico(String nroDocumento){
        return null;
    }
    private Reparacion buscarReparacion(int codigoReparacion){
        return null;
    }
    private Repuesto buscarRepuesto(int codigoRepuesto){
        return null;
    }
    private ManoDeObra buscarManoDeObra(int codigoManoDeObra){
        return null;
    }
}
