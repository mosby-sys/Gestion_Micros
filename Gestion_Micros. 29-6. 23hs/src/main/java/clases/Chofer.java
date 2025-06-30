package clases;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chofer extends Empleados {
    private int horasTrabajadas;
    private String disponibilidadDeChofer;

    public static void mostrarMenuChoferes(Scanner scanner, List<Chofer> choferes) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CHOFERES ===");
            System.out.println("1. Mostrar disponibles");
            System.out.println("2. Calcular prioridad por horas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarChoferesDisponibles(choferes);
                    break;
                case 2:
                    calcularPrioridadHoras(choferes);
                    break;
            }
        } while (opcion != 0);
    }

    // Método completado para calcular prioridad
    private static void calcularPrioridadHoras(List<Chofer> choferes) {
        Map<String, Integer> horasMap = new HashMap<>();
        for (Chofer chofer : choferes) {
            horasMap.put(chofer.getID(), chofer.getHorasTrabajadas());
        }
        new Chofer(null, null, 0, null).calcularPrioridad(horasMap);
    }

    // Constructor público
    public Chofer(String nombre, String ID, int horasTrabajadas, String disponibilidadDeChofer) {
        super(nombre, ID);  // Llama al constructor de Empleados
        this.horasTrabajadas = horasTrabajadas;
        this.disponibilidadDeChofer = disponibilidadDeChofer;
    }

    public List<Map.Entry<String, Integer>> calcularPrioridad(Map<String, Integer> horasPorChofer) {
        // Ordenar las entradas del mapa por horas trabajadas en orden ascendente
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(horasPorChofer.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        // Imprimir la lista ordenada
        System.out.println("Choferes ordenados por horas trabajadas:");
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            System.out.println("ID: " + entry.getKey() + ", Horas: " + entry.getValue());
        }

        // Retornar la lista ordenada
        return listaOrdenada;
    }

    // Map para almacenar horas trabajadas por chofer
    private Map<String, Integer> horasPorChofer = new HashMap<>();

    // -------------------------------
    // Getters y Setters (encapsulamiento)
    // -------------------------------

    // Horas trabajadas
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(String idChofer, int horasTrabajadas) {
        if (horasTrabajadas >= 0) {  // Validación básica
            horasPorChofer.put(idChofer, horasTrabajadas);
            System.out.println("Horas trabajadas asignadas: {" + idChofer + ": " + horasTrabajadas + "}");
        } else {
            System.out.println("Error: Las horas trabajadas no pueden ser negativas.");
        }
    }

    // Disponibilidad
    public String getDisponibilidadDeChofer() {
        return disponibilidadDeChofer;
    }

    public void setDisponibilidadDeChofer(String disponibilidadDeChofer) {
        if (disponibilidadDeChofer != null && !disponibilidadDeChofer.isEmpty()) {  // Validación
            this.disponibilidadDeChofer = disponibilidadDeChofer;
        } else {
            System.out.println("Error: La disponibilidad no puede estar vacía.");
        }
    }

    // Método para cargar choferes desde archivo
    public static List<Chofer> cargarChoferes(String rutaArchivo) throws IOException {
        List<Chofer> choferes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            Chofer chofer = new Chofer(
                    datos[1], // nombre
                    datos[0], // ID
                    Integer.parseInt(datos[2]), // horas
                    datos[3]  // disponibilidad
            );
            choferes.add(chofer);
        }
        reader.close();
        return choferes;
    }

    // Método para guardar choferes en archivo
    public static void guardarChoferes(String rutaArchivo, List<Chofer> choferes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));

        for (Chofer chofer : choferes) {
            writer.write(
                    chofer.getID() + "|" +
                            chofer.getNombre() + "|" +
                            chofer.getHorasTrabajadas() + "|" +
                            chofer.getDisponibilidadDeChofer()
            );
            writer.newLine();
        }
        writer.close();
    }

    public static void listarChoferesDisponibles(List<Chofer> choferes) {
        System.out.println("\n=== CHOFERES DISPONIBLES ===");
        for (Chofer chofer : choferes) {
            if ("Disponible".equalsIgnoreCase(chofer.getDisponibilidadDeChofer())) {
                System.out.printf("ID: %s | Nombre: %s | Horas: %d%n",
                        chofer.getID(), chofer.getNombre(), chofer.getHorasTrabajadas());
            }
        }
    }


}


