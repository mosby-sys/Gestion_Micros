package clases;

public class pasajero {
    public int idPasajero;
    public String nombrePasajero;
    private String direccionPasajero;
    private String telefonoPasajero;

    // constructor
    public pasajero(int idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        this.idPasajero = idPasajero;
        this.nombrePasajero = nombrePasajero;
        this.direccionPasajero = direccionPasajero;
        this.telefonoPasajero = telefonoPasajero;
    }
}
