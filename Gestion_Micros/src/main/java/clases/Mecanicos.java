package clases;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Mecanicos extends Empleados {

    public static List<Mecanicos> cargarMecanicos(String rutaArchivo) throws IOException {
        List<Mecanicos> mecanicos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            mecanicos.add(new Mecanicos(datos[1], datos[0]));
        }
        reader.close();
        return mecanicos;
    }


    // Constructor
    public Mecanicos(String nombre, String id) {
        super(nombre, id);
    }

    public static void generarOrdenDeArreglo(Scanner scanner, String idMicro, Micros micro) {
        if (micro.getIdMicro().equals(idMicro) && micro.getEstadoMicro().equals("En servicio")) {
            System.out.println("No se genera el orden porque el micro está en funcionamiento.");
        } else {
            System.out.println("Orden de arreglo generada por: " + getNombre());
        }
    }


    public String getIdMecanico() {
        return getID();
    }

    public String getNombreMecanico() {
        return getNombre();
    }
}
