package modelos;

public class TareasPorReparacion {
    private Reparacion reparacion;
    private ManoDeObra manoDeObra;
    private int horasEmpleadas;

    public TareasPorReparacion(Reparacion reparacion, ManoDeObra manoDeObra, int horasEmpleadas) {
        this.reparacion = reparacion;
        this.manoDeObra = manoDeObra;
        this.horasEmpleadas = horasEmpleadas;
    }

    public int getHorasEmpleadas() {
        return horasEmpleadas;
    }
    public float calcularSubtotalTarea(){
        return 0f;
    }
}
