package clases;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static GestorDatos gestor = new GestorDatos();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            gestor.cargarTodosLosDatos();
            mostrarMenuPrincipal();
        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA BOLETERO ===");
            System.out.println("1. Registrar nuevo pasajero");
            System.out.println("2. Vender pasaje");
            System.out.println("3. Consultar viajes");
            System.out.println("4. Listar pasajeros");

            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrarPasajero(); break;
                case 2: venderPasaje(); break;
                case 3: consultarViajes(); break;
                case 4: listarPasajeros(); break;
            }
        } while (opcion != 0);

        guardarDatos();
    }

    private static void registrarPasajero() {
        System.out.println("\n--- REGISTRAR PASAJERO ---");
        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        gestor.agregarPasajero(new Pasajero(dni, nombre, direccion, telefono));
        System.out.println("Pasajero registrado exitosamente!");
    }

    private static void venderPasaje() {
        System.out.println("\n--- VENDER PASAJE ---");
        // Implementación similar usando gestor.getViajes() y gestor.agregarPasaje()
    }

    private static void consultarViajes() {
        System.out.println("\n--- VIAJES DISPONIBLES ---");
        System.out.println("ID      | Origen         | Destino       | Salida  | Precio  | Choferes");
        System.out.println("-----------------------------------------------------------------------");

        for (Viaje viaje : gestor.getViajes()) {
            System.out.printf("%-7s | %-14s | %-13s | %-7s | $%-6.2f | %s y %s%n",
                    viaje.getIdViaje(),
                    viaje.getInicio(),
                    viaje.getDestino(),
                    viaje.getHorarioPartida(),
                    viaje.getPrecio(),
                    viaje.getChofer1().getNombre(),
                    viaje.getChofer2().getNombre());
        }
    }

    private static void listarPasajeros() {
        System.out.println("\n--- PASAJEROS REGISTRADOS ---");
        System.out.println("DNI         | Nombre                | Teléfono   | Dirección");
        System.out.println("------------------------------------------------------------");

        for (Pasajero pasajero : gestor.getPasajeros()) {
            System.out.printf("%-11s | %-21s | %-10s | %s%n",
                    pasajero.getIdPasajero(),
                    pasajero.getNombrePasajero(),
                    pasajero.getTelefonoPasajero(),
                    pasajero.getDireccionPasajero());
        }

        System.out.println("\nTotal de pasajeros: " + gestor.getPasajeros().size());
    }

    private static void guardarDatos() {
        try {
            gestor.guardarPasajeros();
            gestor.guardarPasajes();
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}