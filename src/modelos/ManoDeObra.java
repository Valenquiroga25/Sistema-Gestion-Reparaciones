package modelos;

public class ManoDeObra {
    private static int contador;
    private int codigoManoDeObra;
    private String descripcion;
    private float precioPorHora;

    public ManoDeObra(String descripcion, float precioPorHora) {
        this.codigoManoDeObra = ++contador;
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

    @Override
    public String toString() {
        return "ManoDeObra{" +
                "codigoManoDeObra=" + codigoManoDeObra +
                ", descripcion='" + descripcion + '\'' +
                ", precioPorHora=" + precioPorHora +
                '}';
    }
}
