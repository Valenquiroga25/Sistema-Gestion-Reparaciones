package modelos;

import java.time.Year;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private Year anio;
    private Cliente cliente;

    public Vehiculo(String matricula, String marca, String modelo, Year anio, Cliente cliente) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cliente = cliente;
    }
    public boolean soyEseVehiculo(String matriculaChequear){
        return matriculaChequear.equals(matricula);
    }
}
