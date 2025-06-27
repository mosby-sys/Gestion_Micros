package clases;

public class chofer extends Empleados{
    public int horasTrabajadas;
    public String disponibilidadDeChofer;

    private chofer(String nombre, String ID, int horasTrabajadas, String disponibilidadDeChofer) {
        setNombre(nombre);
        setID(ID);
        this.horasTrabajadas = horasTrabajadas;
        this.disponibilidadDeChofer = disponibilidadDeChofer;
    }

}
