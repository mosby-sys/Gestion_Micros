package clases;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Inventario {
    private int idInventario;
    private int cantidadRuedas;
    private int cantidadAsientos;
    private int cantidadMotores;
    private int cantidadVentanas;

    public static void mostrarMenuInventarios(Scanner scanner, List<Inventario> inventarios) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
            System.out.println("1. Modificar inventario");
            System.out.println("2. Mostrar stock");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    modificarInventario(scanner, inventarios);
                    break;
                case 2:
                    mostrarStock(inventarios);
                    break;
            }
        } while (opcion != 0);
    }

    // -------------------------------
    // Constructor
    // -------------------------------
    public Inventario(int idInventario, int cantidadRuedas, int cantidadAsientos,
                      int cantidadMotores, int cantidadVentanas) {
        this.idInventario = idInventario;
        this.cantidadRuedas = cantidadRuedas;
        this.cantidadAsientos = cantidadAsientos;
        this.cantidadMotores = cantidadMotores;
        this.cantidadVentanas = cantidadVentanas;
    }

    // -------------------------------
    // Getters y Setters
    // -------------------------------

    // ID Inventario
    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    // Ruedas
    public int getCantidadRuedas() {
        return cantidadRuedas;
    }

    public void setCantidadRuedas(int cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }

    // Asientos
    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    // Motores
    public int getCantidadMotores() {
        return cantidadMotores;
    }

    public void setCantidadMotores(int cantidadMotores) {
        this.cantidadMotores = cantidadMotores;
    }

    // Ventanas
    public int getCantidadVentanas() {
        return cantidadVentanas;
    }

    public void setCantidadVentanas(int cantidadVentanas) {
        this.cantidadVentanas = cantidadVentanas;
    }

    // Método para cargar inventarios desde archivo
    public static List<Inventario> cargarInventarios(String rutaArchivo) throws IOException {
        List<Inventario> inventarios = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            inventarios.add(new Inventario(
                    Integer.parseInt(datos[0].substring(4)), // Extrae el número de ID (ej: "INV-001" -> 1)
                    Integer.parseInt(datos[1]), // cantidadRuedas
                    Integer.parseInt(datos[2]), // cantidadAsientos
                    Integer.parseInt(datos[3]), // cantidadMotores
                    Integer.parseInt(datos[4])  // cantidadVentanas
            ));
        }
        reader.close();
        return inventarios;
    }


    // Métodos
    private static void modificarInventario(Scanner scanner, List<Inventario> inventarios) {
        System.out.print("ID del inventario (ej: INV-001): ");
        String id = scanner.nextLine();
        Inventario inventario = buscarPorId(inventarios, id);

        if (inventario != null) {
            System.out.println("1. Ruedas | 2. Asientos | 3. Motores | 4. Ventanas");
            System.out.print("Qué desea modificar?: ");
            int tipo = scanner.nextInt();
            System.out.print("Nueva cantidad: ");
            int cantidad = scanner.nextInt();

            switch (tipo) {
                case 1: inventario.setCantidadRuedas(cantidad); break;
                case 2: inventario.setCantidadAsientos(cantidad); break;
                case 3: inventario.setCantidadMotores(cantidad); break;
                case 4: inventario.setCantidadVentanas(cantidad); break;
            }
            System.out.println("¡Inventario actualizado!");
        }
    }

    private static Inventario buscarPorId(List<Inventario> inventarios, String id) {
        return null;
    }

    private static void mostrarStock(List<Inventario> inventarios) {
        System.out.println("\n=== STOCK ACTUAL ===");
        for (Inventario inv : inventarios) {
            System.out.printf("ID: %s | Ruedas: %d | Asientos: %d | Motores: %d | Ventanas: %d%n",
                    "INV-" + inv.getIdInventario(), inv.getCantidadRuedas(),
                    inv.getCantidadAsientos(), inv.getCantidadMotores(), inv.getCantidadVentanas());
        }
    }
}

