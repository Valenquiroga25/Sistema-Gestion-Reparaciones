package modelos;

import excepciones.EstadoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reparacion {
    private static int contador;
    private int codigoReparacion;
    private LocalDate fecha;
    private String estado;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private List<Tecnico> tecnicos;
    private List<ItemRepuesto> itemsRepuesto;
    private List<Repuesto> repuestos;
    private List<ManoDeObra> manosDeObra;
    private List<TareaPorReparacion> tareasPorReparacion;

    public Reparacion(LocalDate fecha, Cliente cliente, Vehiculo vehiculo) {
        this.codigoReparacion = ++contador;
        this.fecha = fecha;
        this.estado = "Pendiente";
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.tecnicos = new ArrayList<>();
        this.itemsRepuesto = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.manosDeObra = new ArrayList<>();
        this.tareasPorReparacion = new ArrayList<>();
    }

    public void modificarEstado(String estado) throws EstadoInvalidoException {
        if ((!estado.equals("En proceso")) && (!estado.equals("Terminada"))){
            throw new EstadoInvalidoException("El estado ingresado no es valido. Ingrese estado \"En proceso\" o \"Terminada\"");
        }
        this.estado = estado;
    }
    public float calcularCostoReparacion(){
        float total = 0;
        for (ItemRepuesto item: itemsRepuesto) {
            total += item.calcularSubtotal();
        }
        for (TareaPorReparacion tareaPorReparacion: tareasPorReparacion){
            total += tareaPorReparacion.calcularSubtotalTarea();
        }
        return total;
    }
    public boolean soyEsaReparacion(int codigoReparacion){
        return this.codigoReparacion == codigoReparacion;
    }
    public void agregarRepuesto(Repuesto repuesto, int cantidad){
        if (!reparacionTerminada()){
            this.repuestos.add(repuesto);
            this.itemsRepuesto.add(new ItemRepuesto(repuesto, cantidad));
        }
    }
    public void agregarManoDeObra(ManoDeObra manoDeObra, int cantidadHoras, Tecnico tecnico){
        if (!reparacionTerminada()) {
            this.manosDeObra.add(manoDeObra);
            this.tareasPorReparacion.add(new TareaPorReparacion(manoDeObra, cantidadHoras));
            this.tecnicos.add(tecnico);
        }
    }
    public int getCodigoReparacion(){
        return codigoReparacion;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public List<ManoDeObra> getManosDeObra() {
        return manosDeObra;
    }
    public List<Tecnico> getTecnicos(){
        return tecnicos;
    }
    public List<TareaPorReparacion> getTareasPorReparacion(){
        return tareasPorReparacion;
    }
    public boolean reparacionTerminada(){
        return this.estado.equals("Terminada");
    }
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "codigoReparacion=" + codigoReparacion +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", tecnicos=" + tecnicos +
                ", itemsRepuesto=" + itemsRepuesto +
                ", repuestos=" + repuestos +
                ", manosDeObra=" + manosDeObra +
                ", tareasPorReparacion=" + tareasPorReparacion +
                '}';
    }
}
