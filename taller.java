package clases;

import java.util.List;  // Asegúrate de importar List

public class Taller {
    private int idTaller;
    private List<Mecanicos> mecanicos;  // Correcto: atributo privado

    // Getters y Setters
    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public List<Mecanicos> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<Mecanicos> mecanicos) {
        this.mecanicos = mecanicos;
    }

    // Métodos
    public void mostrarMicros() { /* Lógica */ }
    public void mostrarInventario() { /* Lógica */ }
}