package modelos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String tipoDocumento;
    private String nroDocumento;
    private float cuentaCorriente;
    private float limiteCuentaCorriente;
    private Vehiculo vehiculo;

    public Cliente(String nombre, String tipoDocumento, String nroDocumento, float cuentaCorriente, float limiteCuentaCorriente, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.cuentaCorriente = cuentaCorriente;
        this.limiteCuentaCorriente = limiteCuentaCorriente;
        this.vehiculo = vehiculo;
    }
    public boolean soyEseCliente(String nroDocumentoChequear){
        return nroDocumentoChequear.equals(nroDocumento);
    }
    public float getCuentaCorriente() {
        return cuentaCorriente;
    }
    public void pagarReparacion(float costoReparacion){
        this.cuentaCorriente -= costoReparacion;
    }
    public boolean limiteCreditoSuficiente(float costoReparacion){
        return (costoReparacion <= (this.cuentaCorriente + this.limiteCuentaCorriente));
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nroDocumento='" + nroDocumento + '\'' +
                ", cuentaCorriente=" + cuentaCorriente +
                ", limiteCuentaCorriente=" + limiteCuentaCorriente +
                ", vehiculo=" + vehiculo;
    }
}
