package clases;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pasajero {  // Nota: Usa mayúscula en el nombre de la clase
    private String idPasajero;  // Atributos privados
    private String nombrePasajero;
    private String direccionPasajero;
    private String telefonoPasajero;

    public static List<Pasajero> cargarPasajeros(String rutaArchivo) throws IOException {
        List<Pasajero> pasajeros = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            pasajeros.add(new Pasajero(
                    datos[0], // ID
                    datos[1], // Nombre
                    datos[2], // Dirección
                    datos[3]  // Teléfono
            ));
        }
        reader.close();
        return pasajeros;
    }

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

    public String getNombrePasajero() {return nombrePasajero;}

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