package modelos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String tipoDocumento;
    private String nroDocumento;
    private float cuentaCorriente;
    private float limiteCuentaCorriente;
    private Vehiculo vehiculo;
    private List<Reparacion> reparaciones;

    public Cliente(String nombre, String tipoDocumento, String nroDocumento) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
    }

    public Cliente(String nombre, String tipoDocumento, String nroDocumento, float cuentaCorriente, float limiteCuentaCorriente, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.cuentaCorriente = cuentaCorriente;
        this.limiteCuentaCorriente = limiteCuentaCorriente;
        this.vehiculo = vehiculo;
        reparaciones = new ArrayList<>();
    }
    public void agregarReparacion(Reparacion reparacion){
        this.reparaciones.add(reparacion);
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public List<Reparacion> getReparacion() {
        return reparaciones;
    }
    public boolean soyEseCliente(String nroDocumentoChequear){
        return nroDocumentoChequear.equals(nroDocumento);
    }
    public void agregarSaldoCuenta(float dineroAgregado){
        this.cuentaCorriente += dineroAgregado;
    }
    public void setLimiteCuentaCorriente(float limiteCuentaCorriente) {
        this.limiteCuentaCorriente = limiteCuentaCorriente;
    }
    public String getNombre() {
        return nombre;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public float getCuentaCorriente() {
        return cuentaCorriente;
    }

    public float getLimiteCuentaCorriente() {
        return limiteCuentaCorriente;
    }

    public void pagarReparacion(float costoReparacion){
        this.cuentaCorriente -= costoReparacion;
    }
}
