package clases;

public class Inventario {
    private int idInventario;
    private int cantidadRuedas;
    private int cantidadAsientos;
    private int cantidadMotores;
    private int cantidadVentanas;

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

    // Métodos
    public void modificarInventario() {
        /* Lógica */
    }

    public void mostrarInventario() {

    }
}

