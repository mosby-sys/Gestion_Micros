package clases;

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


    public void verEstadoMicro(String idMicro) {
        if (this.idMicro.equals(idMicro)) {
            System.out.println("Estado del micro: " + estadoMicro);
        } else {
            System.out.println("El ID del micro no coincide.");
        }
    }
}
