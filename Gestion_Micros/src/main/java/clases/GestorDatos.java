package clases;

import java.io.*;
import java.util.*;

public class GestorDatos {

    private static final String RUTA_BASE = "D:\\Usuario\\Escritorio\\Gestion_Micros. 29-6. 23hs\\datos\\";

    // Datos de solo lectura
    private List<Chofer> choferes = new ArrayList<>();
    private List<Viaje> viajes = new ArrayList<>();
    private List<Micros> micros = new ArrayList<>();
    private List<Inventario> inventarios = new ArrayList<>();
    private List<Mecanicos> mecanicos = new ArrayList<>();
    private List<Administrador> administradores = new ArrayList<>();

    // Datos editables
    private List<Pasajero> pasajeros = new ArrayList<>();
    private List<Pasaje> pasajes = new ArrayList<>();

    // Carga inicial de todos los datos
    public void cargarTodosLosDatos() throws IOException {
        // Datos de solo lectura
        inventarios = Inventario.cargarInventarios(RUTA_BASE + "DatosInventarios.txt");
        choferes = Chofer.cargarChoferes(RUTA_BASE + "DatosChoferes.txt");
        viajes = Viaje.cargarViajes(RUTA_BASE + "DatosViajes.txt", choferes);
        micros = Micros.cargarMicros(RUTA_BASE + "DatosMicros.txt", inventarios);
        mecanicos = Mecanicos.cargarMecanicos(RUTA_BASE + "DatosMecanicos.txt");
        administradores = Administrador.cargarAdministradores(RUTA_BASE + "DatosAdministradores.txt");

        // Datos editables
        pasajeros = cargarPasajeros();
        pasajes = cargarPasajes();
    }

    // Métodos para datos editables
    public void guardarPasajeros() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_BASE + "DatosPasajeros.txt"))) {
            for (Pasajero p : pasajeros) {
                writer.write(String.join("|",
                        p.getIdPasajero(),
                        p.getNombrePasajero(),
                        p.getDireccionPasajero(),
                        p.getTelefonoPasajero()));
                writer.newLine();
            }
        }
    }

    public void guardarPasajes() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_BASE + "DatosPasajes.txt"))) {
            for (Pasaje p : pasajes) {
                writer.write(String.join("|",
                        p.getIdPasaje(),
                        p.getIdPasajero(),
                        p.getAsiento(),
                        p.getHorarioPartida(),
                        p.getHorarioLlegada(),
                        p.getIdViaje()));
                writer.newLine();
            }
        }
    }

    // Métodos de ayuda para carga
    private List<Pasajero> cargarPasajeros() throws IOException {
        List<Pasajero> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_BASE + "DatosPasajeros.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 4) {
                    lista.add(new Pasajero(datos[0], datos[1], datos[2], datos[3]));
                }
            }
        }
        return lista;
    }

    private List<Pasaje> cargarPasajes() throws IOException {
        List<Pasaje> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_BASE + "DatosPasajes.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 8) {  // Ahora espera 8 campos
                    Pasajero pasajero = buscarPasajero(this.pasajeros, datos[1]);
                    if (pasajero != null) {
                        Pasaje p = new Pasaje(
                                datos[0],  // idPasaje
                                datos[2],  // asiento
                                pasajero.getIdPasajero(),
                                pasajero.getNombrePasajero(),
                                pasajero.getDireccionPasajero(),
                                pasajero.getTelefonoPasajero(),
                                datos[6],  // origen
                                datos[7]   // destino
                        );
                        p.setHorarioPartida(datos[3]);
                        p.setHorarioLlegada(datos[4]);
                        lista.add(p);
                    }
                }
            }
        }
        return lista;
    }

    // Método auxiliar para buscar un pasajero por ID
    private Pasajero buscarPasajero(List<Pasajero> pasajeros, String idPasajero) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getIdPasajero().equals(idPasajero)) {
                return pasajero;
            }
        }
        return null;
    }

    // Getters para todos los datos
    public List<Chofer> getChoferes() { return Collections.unmodifiableList(choferes); }
    public List<Viaje> getViajes() { return Collections.unmodifiableList(viajes); }
    public List<Micros> getMicros() { return Collections.unmodifiableList(micros); }

    // Getters para datos editables
    public List<Pasajero> getPasajeros() { return pasajeros; }
    public List<Pasaje> getPasajes() { return pasajes; }

    // Métodos para agregar datos editables
    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public void agregarPasaje(Pasaje pasaje) {
        pasajes.add(pasaje);
    }


}
