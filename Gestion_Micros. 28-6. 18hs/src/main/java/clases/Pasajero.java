package clases;

public class Pasajero {  // Nota: Usa mayúscula en el nombre de la clase
    private String idPasajero;  // Atributos privados
    private String nombrePasajero;
    private String direccionPasajero;
    private String telefonoPasajero;

    // Constructor
    public Pasajero(String idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        this.idPasajero = idPasajero;
        this.nombrePasajero = nombrePasajero;
        this.direccionPasajero = direccionPasajero;
        this.telefonoPasajero = telefonoPasajero;
    }

    // Getters y Setters
    public String getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getDireccionPasajero() {
        return direccionPasajero;
    }

    public void setDireccionPasajero(String direccionPasajero) {
        this.direccionPasajero = direccionPasajero;
    }

    public String getTelefonoPasajero() {
        return telefonoPasajero;
    }

    public void setTelefonoPasajero(String telefonoPasajero) {
        this.telefonoPasajero = telefonoPasajero;
    }
}