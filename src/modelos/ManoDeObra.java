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
    public float getPrecioPorHora() {
        return precioPorHora;
    }

    @Override
    public String toString() {
        return "ManoDeObra{" +
                "codigoManoDeObra=" + codigoManoDeObra +
                ", descripcion='" + descripcion + '\'' +
                ", precioPorHora=" + precioPorHora +
                '}';
    }
}
