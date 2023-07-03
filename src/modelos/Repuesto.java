package modelos;

public class Repuesto {

    private int codigoRepuesto;
    private String descripcion;
    private float precio;

    public Repuesto(int codigoRepuesto, String descripcion, float precio) {
        this.codigoRepuesto = codigoRepuesto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }
}
