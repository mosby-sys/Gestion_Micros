package clases;

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



    public void asignarChofer(Chofer chofer1, Chofer chofer2) {
        this.chofer1 = chofer1;
        this.chofer2 = chofer2;

    }

    public void asignarMicro() {
        // Aquí se podría implementar la lógica para asignar un micro al viaje

    }

    public void asignarAsiento(Pasaje pasaje, java.util.List<String> asientosReservados) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Asientos reservados: " + asientosReservados);
        System.out.print("Ingrese el asiento que desea asignar: ");
        String nuevoAsiento = scanner.nextLine();

        if (asientosReservados.contains(nuevoAsiento)) {
            System.out.println("El asiento ya está reservado. Por favor, elija otro.");
        } else {
            asientosReservados.add(nuevoAsiento);
            pasaje.setAsiento(nuevoAsiento);
            System.out.println("Asiento asignado exitosamente al pasaje.");
        }
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
