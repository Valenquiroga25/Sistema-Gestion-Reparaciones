package modelos;

public class TareaPorReparacion {
    private ManoDeObra manoDeObra;
    private int horasEmpleadas;

    public TareaPorReparacion(ManoDeObra manoDeObra, int horasEmpleadas) {
        this.manoDeObra = manoDeObra;
        this.horasEmpleadas = horasEmpleadas;
    }

    public int getHorasEmpleadas() {
        return horasEmpleadas;
    }
    public float calcularSubtotalTarea(){
        float total = 0;
        total += (manoDeObra.getPrecioPorHora() * horasEmpleadas);
        return total;
    }
}
