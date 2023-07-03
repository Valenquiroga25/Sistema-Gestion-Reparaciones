package modelos;

public class ManoDeObra {

    private int codigoManoDeObra;
    private String descripcion;
    private float precioPorHora;

    public ManoDeObra(int codigoManoDeObra, String descripcion, float precioPorHora) {
        this.codigoManoDeObra = codigoManoDeObra;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
    }

    public boolean soyEsaManoDeObra(int codigoManoDeObra){
        return this.codigoManoDeObra == codigoManoDeObra;
    }
    public int getCodigoManoDeObra() {
        return codigoManoDeObra;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public float getPrecioPorHora() {
        return precioPorHora;
    }
}
