package modelos;

public class Repuesto {
    private static int contador;
    private int codigoRepuesto;
    private String descripcion;
    private float precio;

    public Repuesto(String descripcion, float precio) {
        this.codigoRepuesto = ++contador;
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
