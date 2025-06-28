package clases;

public class Pasajero {  // Nota: Usa mayúscula en el nombre de la clase
    private int idPasajero;  // Atributos privados
    private String nombrePasajero;
    private String direccionPasajero;
    private String telefonoPasajero;

    // Constructor
    public Pasajero(int idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        this.idPasajero = idPasajero;
        this.nombrePasajero = nombrePasajero;
        this.direccionPasajero = direccionPasajero;
        this.telefonoPasajero = telefonoPasajero;
    }

    // Getters y Setters
    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    // ... (implementa getters/setters para direccion y telefono)
}