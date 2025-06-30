package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Chofer extends Empleados {
    private int horasTrabajadas;
    private String disponibilidadDeChofer;

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

}


