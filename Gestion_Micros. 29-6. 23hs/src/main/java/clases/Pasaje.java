package clases;

public class Pasaje extends Pasajero {
    private String idPasaje;
    private String asiento;
    private String horarioPartida;  // copiado desde viaje
    private String horarioLlegada;//copiado desde viaje


    //herencia de pasajero
    public Pasaje(String idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
    }
    //constructor
    public Pasaje(String idPasaje, String asiento, String idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
        this.idPasaje = idPasaje;
        this.asiento = asiento;
        this.horarioPartida = horarioPartida;
        this.horarioLlegada = horarioLlegada;

    }
    public void mostrarPasaje() {
        System.out.println("ID Pasaje: " + idPasaje);
        System.out.println("Asiento: " + asiento);
        System.out.println("Horario Partida: " + horarioPartida);
        System.out.println("Horario Llegada: " + horarioLlegada);
        System.out.println("ID Pasajero: " + getIdPasajero());
        System.out.println("Nombre Pasajero: " + getNombrePasajero());
    }



    // GET para idPasaje
    public String getIdPasaje() {return idPasaje;}
    // SET para idPasaje
    public void setIdPasaje(String idPasaje) {
        this.idPasaje = idPasaje;
    }
    // GET para asiento
    public String getAsiento() {
        return asiento;
    }
    // SET para asiento
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    // GET para horarioPartida
    public String getHorarioPartida() {
        return horarioPartida;
    }
    // SET para horarioPartida
    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }
    // GET para horarioLlegada
    public String getHorarioLlegada() {
        return horarioLlegada;
    }
    // SET para horarioLlegada
    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public String getNombrePasajero() {
        return "";
    }

    public void setNombrePasajero(String nombrePasajero) {
        // Implementación del setter
    }

    public String getIdPasajero() { return ""; }

    public void setIdPasajero(String idPasajero) {
        // Implementación del setter
    }

}
