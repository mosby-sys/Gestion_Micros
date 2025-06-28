package clases;

public class Micros {
    private int idMicro;
    private String estadoMicro;       // Ej: "En servicio", "En mantenimiento"
    private String disponibilidadMicro; // Ej: "Disponible", "Ocupado"
    private Inventario inventario;

    // -------------------------------
    // Constructor
    // -------------------------------
    public Micros(int idMicro, String estadoMicro, String disponibilidadMicro, Inventario inventario) {
        this.idMicro = idMicro;
        this.estadoMicro = estadoMicro;
        this.disponibilidadMicro = disponibilidadMicro;
        this.inventario = inventario;
    }

    // -------------------------------
    // Getters y Setters básicos
    // -------------------------------

    // ID Micro
    public int getIdMicro() {
        return idMicro;
    }

    public void setIdMicro(int idMicro) {
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
    public void verDisponibilidadMicro() {
        /* Lógica */
    }

    public void verEstadoMicro() {
        /* Lógica */
    }
}
