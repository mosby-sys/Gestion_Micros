package clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Pasaje extends Pasajero {
    private String idPasaje;
    private String asiento;
    private String horarioPartida;  // copiado desde viaje
    private String horarioLlegada;//copiado desde viaje
    private String origen;
    private String destino;


    public static List<Pasaje> cargarPasajes(String rutaArchivo, List<Pasajero> pasajeros, List<Viaje> viajes) throws IOException {
        List<Pasaje> pasajes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");

            // Validación básica de campos
            if (datos.length < 8) {
                System.err.println("Línea incompleta: " + linea);
                continue;
            }

            Pasajero pasajero = buscarPasajero(pasajeros, datos[1]);
            Viaje viaje = buscarViaje(viajes, datos[5]);

            // Validación de objetos encontrados
            if (pasajero == null || viaje == null) {
                System.err.println("No se encontró pasajero o viaje para: " + datos[0]);
                continue;
            }

            Pasaje pasaje = new Pasaje(
                    datos[0], // idPasaje
                    datos[2], // asiento
                    pasajero.getIdPasajero(),
                    pasajero.getNombrePasajero(),
                    pasajero.getDireccionPasajero(),
                    pasajero.getTelefonoPasajero(),
                    viaje.getInicio(),  // origen desde Viaje
                    viaje.getDestino()  // destino desde Viaje
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


    public Pasaje(
            String idPasaje,
            String asiento,
            String idPasajero,
            String nombrePasajero,
            String direccionPasajero,
            String telefonoPasajero,
            String origen,             // Nuevo parámetro
            String destino             // Nuevo parámetro
    ) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
        this.idPasaje = idPasaje;
        this.asiento = asiento;
        this.origen = origen;      // Asignación
        this.destino = destino;    // Asignación
    }
    public void mostrarPasaje() {
        System.out.println("ID Pasaje: " + idPasaje);
        System.out.println("Asiento: " + asiento);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
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
        return super.getNombrePasajero(); // Usar el método del padre
    }

    public String getIdPasajero() {
        return super.getIdPasajero(); // Usar el método del padre
    }

    public void setNombrePasajero(String nombrePasajero) {
        // Implementación del setter
    }

    public void setIdPasajero(String idPasajero) {
        // Implementación del setter
    }

    public CharSequence getIdViaje() {
        return null;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
