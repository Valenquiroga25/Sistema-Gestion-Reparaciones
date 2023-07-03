package modelos;

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
    public float calcularSueldo(){
        return 0f;
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
}
