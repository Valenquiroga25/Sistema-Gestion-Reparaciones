package controlador;

import modelos.*;

import javax.naming.ldap.Control;
import java.time.Year;
import java.util.Date;
import java.util.List;

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
    public void registrarCliente(String nombre, String tipoDocumento, String nroDocumento){
        return;
    }
    public void registrarVehiculo(String matricula, String modelo, Year anio){
        return;
    }
    public void generarReparacion(int codigo, Date fecha, String nroDocumento, String matricula){
        return;
    }
    public void cobrarReparacion(int codigoReparacion){

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
