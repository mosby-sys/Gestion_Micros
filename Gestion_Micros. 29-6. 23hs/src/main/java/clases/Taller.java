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

    public void agregarMecanicos(Mecanicos mecanico) {
        if (this.mecanicos != null) {
            this.mecanicos.add(mecanico);
        }
    }
    public void mostrarMecanicos() {
        if (this.mecanicos != null && !this.mecanicos.isEmpty()) {
            System.out.println("Lista de Mecánicos:");
            for (Mecanicos mecanico : this.mecanicos) {
                System.out.println("ID: " + mecanico.getIdMecanico() + ", Nombre: " + mecanico.getNombreMecanico());
            }
        } else {
            System.out.println("No hay mecánicos registrados.");
        }
    }


    public void mostrarMicros(List<Micros> micros) {
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