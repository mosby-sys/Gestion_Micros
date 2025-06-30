package clases;

public class Mecanicos extends Empleados {
    // Constructor
    public Mecanicos(String nombre, String id) {
        super(nombre, id);
    }

    public void generarOrdenDeArreglo(String idMicro,  Micros micro) {
        if (micro.getIdMicro().equals(idMicro) && micro.getEstadoMicro().equals("En servicio")) {
            System.out.println("No se genera el orden porque el micro está en funcionamiento.");
        } else {
            System.out.println("Orden de arreglo generada por: " + getNombre());
        }
    }

    public String getIdMecanico() {
        return "";
    }

    public String getNombreMecanico() {
        return "";
    }
}
