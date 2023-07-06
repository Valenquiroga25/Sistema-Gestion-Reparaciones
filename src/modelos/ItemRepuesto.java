package modelos;

public class ItemRepuesto {
    private int cantidad;
    private Repuesto repuesto;
    public ItemRepuesto(Repuesto repuesto, int cantidad) {
        this.repuesto = repuesto;
        this.cantidad = cantidad;
    }

    public float calcularSubtotal(){
        float total = 0;
        total += (repuesto.getPrecio() * cantidad);
        return total;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
