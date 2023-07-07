package views;

import modelos.Cliente;
import modelos.Tecnico;
import modelos.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public class ReparacionView {
    private int codigoReparacion;
    private LocalDate fecha;
    private String estado;
    private Cliente cliente;
    private Vehiculo vehiculo;
    public ReparacionView(int codigoReparacion, LocalDate fecha, String estado, Cliente cliente, Vehiculo vehiculo) {
        this.codigoReparacion = codigoReparacion;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public int getCodigoReparacion() {
        return codigoReparacion;
    }

    public void setCodigoReparacion(int codigoReparacion) {
        this.codigoReparacion = codigoReparacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return  "Codigo de Reparacion = " + codigoReparacion + '\n' +
                "Fecha = " + fecha + '\n' +
                "Estado = " + estado + '\n' +
                "Cliente = " + cliente.getNombre() + '\n' +
                "Vehiculo = " + vehiculo.getMatricula();
    }
}
