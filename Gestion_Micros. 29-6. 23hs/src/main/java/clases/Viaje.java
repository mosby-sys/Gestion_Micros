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
    private static String idViaje;
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
            if (datos.length >= 8) { // Verifica que tenga todos los campos
                Viaje viaje = new Viaje(
                        Float.parseFloat(datos[3]),  // precio
                        datos[1],                    // inicio
                        datos[2],                    // destino
                        datos[0],                    // idViaje
                        datos[4],                    // horarioPartida
                        datos[5],                    // horarioLlegada
                        buscarChofer(choferes, datos[6]),  // chofer1
                        buscarChofer(choferes, datos[7])   // chofer2
                );
                viajes.add(viaje);
            }
        }
        reader.close();
        return viajes;
    }

    private static Chofer buscarChofer(List<Chofer> choferes, String idChofer) {
        for (Chofer chofer : choferes) {
            if (chofer.getID().equals(idChofer)) {
                return chofer;
            }
        }
        System.out.println("Advertencia: Chofer con ID " + idChofer + " no encontrado");
        return null;
    }


    // GET para idViaje
    public static String getIdViaje() {
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
