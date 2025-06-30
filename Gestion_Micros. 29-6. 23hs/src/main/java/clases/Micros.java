package clases;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Micros {
    private String idMicro;
    private String estadoMicro;       // Ej: "En servicio", "En mantenimiento"
    private String disponibilidadMicro; // Ej: "Disponible", "Ocupado"
    private Inventario inventario;


    public static void mostrarMenuMicros(Scanner scanner, List<Micros> micros) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE MICROS ===");
            System.out.println("1. Listar micros");
            System.out.println("2. Ver disponibilidad");
            System.out.println("3. Cambiar estado");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarMicros(micros);
                    break;
                case 2:
                    verDisponibilidad(scanner, micros);
                    break;
                case 3:
                    cambiarEstado(scanner, micros);
                    break;
            }
        } while (opcion != 0);
    }

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

        String linea;
        int invIndex = 0;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            // Asigna inventarios de forma rotativa
            Inventario inv = inventarios.get(invIndex % inventarios.size());
            micros.add(new Micros(datos[0], datos[1], datos[2], inv));
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

    // Métodos

    public void verDisponibilidadMicro(String idMicro) {
        if (this.idMicro.equals(idMicro)) {
            System.out.println("Disponibilidad del micro: " + disponibilidadMicro);
        } else {
            System.out.println("El ID del micro no coincide.");
        }
    }
    private static void cambiarEstado(Scanner scanner, List<Micros> micros) {
        System.out.print("ID del micro: ");
        String id = scanner.nextLine();
        Micros micro = buscarPorId(micros, id);

        if (micro != null) {
            System.out.print("Nuevo estado (Disponible/En servicio/En reparación): ");
            String estado = scanner.nextLine();
            micro.setEstadoMicro(estado);
            System.out.println("Estado actualizado.");
        }
    }


    public void verEstadoMicro(String idMicro) {
        if (this.idMicro.equals(idMicro)) {
            System.out.println("Estado del micro: " + estadoMicro);
        } else {
            System.out.println("El ID del micro no coincide.");
        }
    }

    public static void listarMicrosDisponibles(List<Micros> micros) {
        System.out.println("\n=== MICROS DISPONIBLES ===");
        for (Micros micro : micros) {
            if ("Disponible".equalsIgnoreCase(micro.getDisponibilidadMicro())) {
                System.out.printf("ID: %s | Estado: %s%n",
                        micro.getIdMicro(), micro.getEstadoMicro());
            }
        }
    }
}
