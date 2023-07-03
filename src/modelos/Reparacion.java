package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reparacion {
    private int codigoReparacion;
    private Date fecha;
    private String estado;
    private List<Integer> horasManoDeObra;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private List<Tecnico> tecnicos;
    private List<ItemRepuesto> itemsRepuesto;
    private List<Repuesto> repuestos;
    private List<ManoDeObra> manosDeObra;

    public Reparacion(int codigoReparacion, Date fecha, String estado, Cliente cliente, Vehiculo vehiculo) {
        this.codigoReparacion = codigoReparacion;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.tecnicos = new ArrayList<>();
        this.itemsRepuesto = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.manosDeObra = new ArrayList<>();
        this.horasManoDeObra = new ArrayList<>();
    }

    public void modificarEstado(String estado){
        this.estado = estado;
    }
    public float calcularCostoReparacion(){
        float total = 0;
        for (ItemRepuesto item: itemsRepuesto) {
            total += item.calcularSubtotal();
        }
        return total;
    }
    public boolean soyEsaReparacion(int codigoReparacion){
        return this.codigoReparacion == codigoReparacion;
    }
    public void agregarRepuesto(Repuesto repuesto, int cantidad){
        if (!(this.estado == "Terminada")){
            this.repuestos.add(repuesto);
            this.itemsRepuesto.add(new ItemRepuesto(repuesto, cantidad));
        }

    }
    public void agregarManoDeObra(ManoDeObra manoDeObra, int cantidadHoras, List<Tecnico> tecnicos){
        this.manosDeObra.add(manoDeObra);
        this.horasManoDeObra.add(cantidadHoras);
        this.tecnicos.addAll(tecnicos);
    }

    public List<ManoDeObra> getManosDeObra() {
        return manosDeObra;
    }
}
