package modelos;

import excepciones.MesInvalidoException;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Tecnico {

    private String nombre;
    private String tipoDocumento;
    private String nroDocumento;
    private float salarioBase;
    private List<ManoDeObra> manosDeObras;
    private List<Reparacion> reparaciones;

    public Tecnico(String nombre, String tipoDocumento, String nroDocumento, float salarioBase) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.salarioBase = salarioBase;
        this.manosDeObras = new ArrayList<>();
        this.reparaciones = new ArrayList<>();
    }

    public void agregarManoDeObra(ManoDeObra manoDeObra){
        this.manosDeObras.add(manoDeObra);
    }
    public void agregarReparacion(Reparacion reparacion){
        this.reparaciones.add(reparacion);
    }
    public float calcularSueldo(int mes) throws MesInvalidoException {
        if (mes > 12 || mes < 1){
            throw new MesInvalidoException("El mes ingresado es invalido.");
        }
        float total = 0;
        total += this.salarioBase;
        for (Reparacion reparacion: reparaciones){
            if ((reparacion.getFecha().getYear() == LocalDate.now().getYear()) && (reparacion.getFecha().getMonth() == Month.of(mes)) && (reparacion.reparacionTerminada())){
                List<Tecnico> tecnicos = reparacion.getTecnicos();
                for (Tecnico tecnico: tecnicos){
                    if (this.nroDocumento.equals(tecnico.nroDocumento)){
                        int indice = tecnicos.indexOf(tecnico);
                        List<TareaPorReparacion> tareas = reparacion.getTareasPorReparacion();
                        TareaPorReparacion tarea = tareas.get(indice);
                        total += (tarea.calcularSubtotalTarea() * 0.1);
                    }
                }
            }
        }
        return total;
    }
    public String getNroDocumento(){
        return nroDocumento;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean soyEseTecnico(String nroDocumentoChequear){
        return nroDocumentoChequear.equals(nroDocumento);
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "nombre='" + nombre + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nroDocumento='" + nroDocumento + '\'' +
                ", salarioBase=" + salarioBase +
                ", manosDeObras=" + manosDeObras +
                ", reparaciones=" + reparaciones +
                '}';
    }
}
