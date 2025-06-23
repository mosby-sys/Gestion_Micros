package clases;

public class viaje {
    public Float precio;
    public String inicio;
    public String destino;
    private String idViaje;
    public String horarioPartida;
    public String horarioLlegada;
    private chofer chofer1;
    private chofer chofer2;

    // Constructor
    public viaje(Float precio, String inicio, String destino, String idViaje, String horarioPartida, String horarioLlegada, chofer chofer1, chofer chofer2) {
        this.precio = precio;
        this.inicio = inicio;
        this.destino = destino;
        this.idViaje = idViaje;
        this.horarioPartida = horarioPartida;
        this.horarioLlegada = horarioLlegada;
        this.chofer1 = chofer1;
        this.chofer2 = chofer2;
    }



    public void asignarChofer(chofer chofer1, chofer chofer2) {
        this.chofer1 = chofer1;
        this.chofer2 = chofer2;

    }

    public void asignarMicro() {
        // Aquí se podría implementar la lógica para asignar un micro al viaje

    }

    public void asignarAsiento() {
        // Aquí se podría implementar la lógica para asignar un asiento al pasajero

    }

    // GET para idViaje
    public String getIdViaje() {
        return idViaje;
    }
    // SET para idViaje
    public chofer setIdViaje(String idViaje) {
        this.idViaje = idViaje;



    //    // GET para chofer1
    chofer getChofer1;() {
        return chofer1;
    }
    // SET para chofer1
    public void setChofer1 chofer1) {
        this.chofer1 = chofer1;
    }

    // GET para chofer2
    public chofer getChofer2() {
        return chofer2;
    }
    // SET para chofer2
    public void setChofer2(chofer chofer2) {
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
