package clases;

public class Chofer extends Empleados {
    private int horasTrabajadas;
    private String disponibilidadDeChofer;

    // Constructor público
    public Chofer(String nombre, String ID, int horasTrabajadas, String disponibilidadDeChofer) {
        super(nombre, ID);  // Llama al constructor de Empleados
        this.horasTrabajadas = horasTrabajadas;
        this.disponibilidadDeChofer = disponibilidadDeChofer;
    }

    // -------------------------------
    // Getters y Setters (encapsulamiento)
    // -------------------------------

    // Horas trabajadas
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas >= 0) {  // Validación básica
            this.horasTrabajadas = horasTrabajadas;
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


