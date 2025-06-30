package clases;

public class Administrador extends Empleados {

    public Administrador (String nombre, String id) {
        super(nombre, id);
    }

    public void crearViaje() {
        // Implementación de la creación de un viaje,con datos de ejemplo
        Viaje nuevoViaje = new Viaje(100.0f, "Inicio", "Destino", "V001", "08:00", "12:00", null, null);
    }

    public void cobrarViaje(Viaje viaje) {
        // Implementación del cobro de un viaje
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);

            float montoACobrar = viaje.getPrecio(); // Obtener el precio desde el atributo de la clase Viaje

            System.out.print("Ingrese la cantidad de dinero recibido: ");
            float dineroRecibido = scanner.nextFloat();

            if (dineroRecibido >= montoACobrar) {
                float vuelto = dineroRecibido - montoACobrar;
                System.out.println("El vuelto es: " + vuelto);
            } else {
                System.out.println("Dinero insuficiente. Por favor, ingrese el monto correcto.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese valores numéricos.");
        }
    }

    public void consultarDatosPasajero() {
        // Implementación de la consulta de datos de pasajero
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Ingrese el DNI del pasajero: ");
        String idPasajero = scanner.nextLine();

        System.out.print("Ingrese el nombre del pasajero: ");
        String nombrePasajero = scanner.nextLine();

        System.out.print("Ingrese la dirección del pasajero: ");
        String direccionPasajero = scanner.nextLine();

        System.out.print("Ingrese el teléfono del pasajero: ");
        String telefonoPasajero = scanner.nextLine();

        Pasajero pasajero = new Pasajero(idPasajero, nombrePasajero, direccionPasajero, telefonoPasajero);
        System.out.println("Pasajero cargado exitosamente.");

    }


}