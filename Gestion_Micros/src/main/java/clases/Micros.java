package clases;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Micros {
    private String idMicro;
    private String estadoMicro;       // Ej: "En servicio", "En mantenimiento"
    private String disponibilidadMicro; // Ej: "Disponible", "Ocupado"
    private Inventario inventario;


    // -------------------------------
    // Constructor
    // -------------------------------
    public Micros(String idMicro, String estadoMicro, String disponibilidadMicro, Inventario inventario) {
        this.idMicro = idMicro;
        this.estadoMicro = estadoMicro;
        this.disponibilidadMicro = disponibilidadMicro;
        this.inventario = inventario;
    }

    public static List<Micros> cargarMicros(String rutaArchivo, List<Inventario> inventarios) throws IOException {
        List<Micros> micros = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        // Verificar si hay inventarios disponibles
        if (inventarios.isEmpty()) {
            throw new IllegalStateException("No hay inventarios cargados para asignar a los micros");
        }

        String linea;
        int invIndex = 0;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            Inventario inv = inventarios.get(invIndex % inventarios.size());
            micros.add(new Micros(
                    datos[0],
                    datos[1],
                    datos[2],
                    inv
            ));
            invIndex++;
        }
        reader.close();
        return micros;
    }

    // -------------------------------
    // Getters y Setters básicos
    // -------------------------------

    // ID Micro
    public String getIdMicro() {
        return idMicro;
    }

    public void setIdMicro(String idMicro) {
        this.idMicro = idMicro;
    }

    // Estado Micro
    public String getEstadoMicro() {
        return estadoMicro;
    }

    public void setEstadoMicro(String estadoMicro) {
        this.estadoMicro = estadoMicro;
    }

    // Disponibilidad Micro
    public String getDisponibilidadMicro() {
        return disponibilidadMicro;
    }

    public void setDisponibilidadMicro(String disponibilidadMicro) {
        this.disponibilidadMicro = disponibilidadMicro;
    }

    // Inventario
    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }


}
