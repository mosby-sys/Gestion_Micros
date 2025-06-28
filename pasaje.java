package clases;

public class pasaje extends Pasajero {
    private int idPasaje;
    private float precioPasaje;
    private String asiento;

    private String horarioPartida;  // copiado desde viaje
    private String horarioLlegada;//copiado desde viaje


    //herencia de pasajero
    public pasaje(int idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
    }
    //constructor
    public pasaje(int idPasaje, float precioPasaje, String asiento, int idPasajero, String nombrePasajero, String direccionPasajero, String telefonoPasajero) {
        super(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
        this.idPasaje = idPasaje;
        this.precioPasaje = precioPasaje;
        this.asiento = asiento;
        this.horarioPartida = viaje.getHorarioPartida();
        this.horarioLlegada = viaje.getHorarioLlegada();

    }
    public void mostrarPasaje() {
        System.out.println("ID Pasaje: " + idPasaje);
        System.out.println("Precio Pasaje: " + precioPasaje);
        System.out.println("Asiento: " + asiento);
        System.out.println("Horario Partida: " + horarioPartida);
        System.out.println("Horario Llegada: " + horarioLlegada);
        System.out.println("ID Pasajero: " + getIdPasajero());
        System.out.println("Nombre Pasajero: " + getNombrePasajero());
    }



    // GET para idPasaje
    public int getIdPasaje() {
        return idPasaje;
    }
    // SET para idPasaje
    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }
    // GET para precioPasaje
    public float getPrecioPasaje() {
        return precioPasaje;
    }
    // SET para precioPasaje
    public void setPrecioPasaje(float precioPasaje) {
        this.precioPasaje = precioPasaje;
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

    private String getNombrePasajero() {
        return "";
    }

    private void setNombrePasajero(String nombrePasajero) {
        // Implementación del setter
    }

    private String getIdPasajero() {
        return "";
    }
    private void setIdPasajero(int idPasajero) {
        // Implementación del setter


    







}
