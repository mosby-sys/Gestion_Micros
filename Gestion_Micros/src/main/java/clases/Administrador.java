package clases;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Administrador extends Empleados {

    private static List<Pasaje> pasajes = new ArrayList<>();

    public Administrador (String nombre, String id) {
        super(nombre, id);
    }

    public static List<Administrador> cargarAdministradores(String rutaArchivo) throws IOException {
        List<Administrador> administradores = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            administradores.add(new Administrador(datos[1], datos[0]));
        }
        reader.close();
        return administradores;
    }
    // ======================
    // MÉTODOS AUXILIARES (implementados y funcionales)
    // ======================

    private static Pasajero registrarNuevoPasajero(Scanner scanner, List<Pasajero> pasajeros) {
        System.out.println("\n=== REGISTRO DE NUEVO PASAJERO ===");

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Pasajero nuevoPasajero = new Pasajero(dni, nombre, direccion, telefono);
        pasajeros.add(nuevoPasajero);

        System.out.println("\n¡Pasajero registrado exitosamente!");
        return nuevoPasajero;
    }




}