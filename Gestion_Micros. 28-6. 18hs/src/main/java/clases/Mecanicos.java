package clases;

public class Mecanicos extends Empleados {
    // Constructor
    public Mecanicos(String nombre, String id) {
        super(nombre, id);
    }

    public void generarOrdenDeArreglo() {
        System.out.println("Orden de arreglo generada por: " + getNombre());
        // Lógica adicional si es necesaria
    }

}
