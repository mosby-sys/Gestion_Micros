package clases;


import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Taller {
    private int idTaller;

    public static void mostrarMenuTaller(Scanner scanner, Taller taller, List<Micros> micros, List<Mecanicos> mecanicos) {
        int opcion;
        do {
            System.out.println("\n=== TALLER DE MANTENIMIENTO ===");
            System.out.println("1. Generar orden de reparación");
            System.out.println("2. Mostrar micros");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    generarOrdenReparacion(mecanicos, micros);
                    break;
                case 2:
                    mostrarMicros(micros);
            }
        } while (opcion != 0);
    }



    // Getters y Setters
    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }


    public static void  generarOrdenReparacion(List<Mecanicos> mecanicos,List<Micros> micros){

    }

    public static void mostrarMicros(List<Micros> micros) {
        if (micros != null && !micros.isEmpty()) {
            System.out.println("Lista de Micros:");
            for (Micros micro : micros) {
                System.out.println("ID Micro: " + micro.getIdMicro());
            }
        } else {
            System.out.println("No hay micros registrados.");
        }
    }

}