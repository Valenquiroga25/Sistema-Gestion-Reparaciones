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
    public boolean soyEseRepuesto(int codigoRepuesto){
        return this.codigoRepuesto == codigoRepuesto;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                "codigoRepuesto=" + codigoRepuesto +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
