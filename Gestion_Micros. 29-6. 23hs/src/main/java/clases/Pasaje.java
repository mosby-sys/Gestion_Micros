package clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Pasaje extends Pasajero {
    private String idPasaje;
    private String asiento;
    private String horarioPartida;  // copiado desde viaje
    private String horarioLlegada;//copiado desde viaje

    public Pasaje(String idPasaje, String dni, String nombre, String asiento, String idViaje) {
        super();
    }

    public static List<Pasaje> cargarPasajes(String rutaArchivo, List<Pasajero> pasajeros, List<Viaje> viajes) throws IOException {
        List<Pasaje> pasajes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            Pasajero pasajero = buscarPasajero(pasajeros, datos[1]);
            Viaje viaje = buscarViaje(viajes, datos[5]);

            Pasaje pasaje = new Pasaje(
                    datos[0], // idPasaje
                    datos[2], // asiento
                    pasajero.getIdPasajero(),
                    pasajero.getNombrePasajero(),
                    pasajero.getDireccionPasajero(),
                    pasajero.getTelefonoPasajero()
            );
            pasaje.setHorarioPartida(viaje.getHorarioPartida());
            pasaje.setHorarioLlegada(viaje.getHorarioLlegada());
            pasajes.add(pasaje);
        }
        reader.close();
        return pasajes;
    }

    private static Pasajero buscarPasajero(List<Pasajero> pasajeros, String id) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getIdPasajero().equals(id)) {
                return pasajero;
            }
        }
        return null;
    }

    private static Viaje buscarViaje(List<Viaje> viajes, String id) {
        for (Viaje viaje : viajes) {
            if (viaje.getIdViaje().equals(id)) {
                return viaje;
            }
        }
        return null;
    }


    //herencia de pasajero
    public Pasaje(String idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
    }
    //constructor
    public Pasaje(String idPasaje, String asiento, String idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
        this.idPasaje = idPasaje;
        this.asiento = asiento;
        this.horarioPartida = horarioPartida;
        this.horarioLlegada = horarioLlegada;

    }
    public void mostrarPasaje() {
        System.out.println("ID Pasaje: " + idPasaje);
        System.out.println("Asiento: " + asiento);
        System.out.println("Horario Partida: " + horarioPartida);
        System.out.println("Horario Llegada: " + horarioLlegada);
        System.out.println("ID Pasajero: " + getIdPasajero());
        System.out.println("Nombre Pasajero: " + getNombrePasajero());
    }



    // GET para idPasaje
    public String getIdPasaje() {return idPasaje;}
    // SET para idPasaje
    public void setIdPasaje(String idPasaje) {
        this.idPasaje = idPasaje;
    }
    // GET para asiento
    public String getAsiento() {
        return asiento;
    }
    // SET para asiento
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    // GET para horarioPartida
    public String getHorarioPartida() {
        return horarioPartida;
    }
    // SET para horarioPartida
    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }
    // GET para horarioLlegada
    public String getHorarioLlegada() {
        return horarioLlegada;
    }
    // SET para horarioLlegada
    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public String getNombrePasajero() {
        return "";
    }

    public void setNombrePasajero(String nombrePasajero) {
        // Implementación del setter
    }

    public String getIdPasajero() { return ""; }

    public void setIdPasajero(String idPasajero) {
        // Implementación del setter
    }

    public CharSequence getIdViaje() {
        return null;
    }
}
