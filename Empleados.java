package clases;

public abstract class Empleados {
    private String nombre;
    private String ID;

    // GET para nombre
    public String getNombre() {
        return nombre;
    }
    // SET para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // GET para ID
    public String getID() {
        return ID;
    }
    // SET para ID
    public void setID(String ID) {
        this.ID = ID;
    }
}
