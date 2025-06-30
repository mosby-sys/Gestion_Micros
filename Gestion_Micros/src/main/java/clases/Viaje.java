package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private Float precio;
    private String inicio;
    private String destino;
    private String idViaje;
    public String horarioPartida;
    public String horarioLlegada;
    private Chofer chofer1;
    private Chofer chofer2;


    // Constructor
    public Viaje(Float precio, String inicio, String destino, String idViaje, String horarioPartida, String horarioLlegada, Chofer chofer1, Chofer chofer2) {
        this.precio = precio;
        this.inicio = inicio;
        this.destino = destino;
        this.idViaje = idViaje;
        this.horarioPartida = horarioPartida;
        this.horarioLlegada = horarioLlegada;
        this.chofer1 = chofer1;
        this.chofer2 = chofer2;
    }
    public static List<Viaje> cargarViajes(String rutaArchivo, List<Chofer> choferes) throws IOException {
        List<Viaje> viajes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            if (datos.length >= 8) {
                Chofer chofer1 = buscarChofer(choferes, datos[6]);
                Chofer chofer2 = buscarChofer(choferes, datos[7]);

                // Validación adicional
                if (chofer1 != null && chofer2 != null && chofer1.getID().equals(chofer2.getID())) {
                    System.err.println("Advertencia: Mismo chofer asignado a ambos puestos en viaje " + datos[0]);
                }

                Viaje viaje = new Viaje(
                        Float.parseFloat(datos[3]),
                        datos[1],
                        datos[2],
                        datos[0],
                        datos[4],
                        datos[5],
                        chofer1,
                        chofer2
                );
                viajes.add(viaje);
            }
        }
        reader.close();
        return viajes;
    }

    private static Chofer buscarChofer(List<Chofer> choferes, String idChofer) {
        if (idChofer == null || idChofer.isEmpty()) {
            return null;
        }

        Chofer encontrado = choferes.stream()
                .filter(c -> c.getID() != null && c.getID().equals(idChofer))
                .findFirst()
                .orElse(null);

        if (encontrado == null) {
            System.err.println("Chofer no encontrado con ID: " + idChofer);
        }
        return encontrado;
    }


    // GET para idViaje
    public String getIdViaje() {
        return idViaje;
    }
    // SET para idViaje
    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }
    // GET para chofer1
    public Chofer getChofer1() {
        return chofer1;
    }
    // SET para chofer1
    public void setChofer1(Chofer chofer1) {
        this.chofer1 = chofer1;
    }

    // GET para chofer2
    public Chofer getChofer2() {
        return chofer2;
    }
    // SET para chofer2
    public void setChofer2(Chofer chofer2) {
        this.chofer2 = chofer2;
    }

    //get y set para precio
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    //get y set para inicio
    public String getInicio() {
        return inicio;
    }
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
    //get y set para destino
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    //get y set para horarioPartida
    public String getHorarioPartida() {
        return horarioPartida;
    }
    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }
    //get y set para horarioLlegada
    public String getHorarioLlegada() {
        return horarioLlegada;
    }
    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

}
