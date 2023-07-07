package views;

import modelos.Vehiculo;

public class ClienteView {
    private String nombre;
    private String tipoDocumento;
    private String nroDocumento;
    private float cuentaCorriente;
    private float limiteCuentaCorriente;
    private Vehiculo vehiculo;

    public ClienteView(String nombre, String tipoDocumento, String nroDocumento, float cuentaCorriente, float limiteCuentaCorriente, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.cuentaCorriente = cuentaCorriente;
        this.limiteCuentaCorriente = limiteCuentaCorriente;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public float getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(float cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public float getLimiteCuentaCorriente() {
        return limiteCuentaCorriente;
    }

    public void setLimiteCuentaCorriente(float limiteCuentaCorriente) {
        this.limiteCuentaCorriente = limiteCuentaCorriente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return  "Nombre = " + nombre + '\n' +
                "Tipo de Documento = " + tipoDocumento + '\n' +
                "Numero de Documento = " + nroDocumento + '\n' +
                "Cuenta Corriente = " + cuentaCorriente + '\n' +
                "Limite de Cuenta Corriente = " + limiteCuentaCorriente + '\n' +
                "Matricula Vehiculo = " + vehiculo.getMatricula();
    }
}
