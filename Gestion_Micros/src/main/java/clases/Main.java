package clases;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static GestorDatos gestor = new GestorDatos();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            gestor.cargarTodosLosDatos();
            mostrarMenuPrincipal();
        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA BOLETERO ===");
            System.out.println("1. Registrar nuevo pasajero");
            System.out.println("2. Vender pasaje");
            System.out.println("3. Consultar viajes");
            System.out.println("4. Listar pasajeros");

            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrarPasajero(); break;
                case 2: venderPasaje(); break;
                case 3: consultarViajes(); break;
                case 4: listarPasajeros(); break;
            }
        } while (opcion != 0);

        guardarDatos();
    }


        private static void registrarPasajero() {
        System.out.println("\n--- REGISTRAR PASAJERO ---");
        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        gestor.agregarPasajero(new Pasajero(dni, nombre, direccion, telefono));
        System.out.println("Pasajero registrado exitosamente!");
    }

    private static void venderPasaje() {
        System.out.println("\n--- VENTA RÁPIDA DE PASAJE ---");

        try {
            // 1. Pedir precio del viaje
            System.out.print("Ingrese el precio del viaje: $");
            float precio = sc.nextFloat();

            // 2. Pedir monto pagado
            System.out.print("Ingrese el monto recibido: $");
            float pago = sc.nextFloat();
            sc.nextLine(); // Limpiar buffer

            // 3. Calcular diferencia
            float diferencia = pago - precio;

            // 4. Mostrar resultado
            System.out.println("\n═════════ COMPROBANTE ═════════");
            System.out.printf("Precio del viaje: $%.2f%n", precio);
            System.out.printf("Monto recibido:   $%.2f%n", pago);

            if (diferencia > 0) {
                System.out.printf("VUELTO:          $%.2f%n", diferencia);
            } else if (diferencia == 0) {
                System.out.println("El cliente pagó el monto exacto");
            } else {
                System.out.printf("FALTANTE:        $%.2f%n", Math.abs(diferencia));
            }
            System.out.println("═══════════════════════════════");

        } catch (Exception e) {
            System.out.println("Error: Ingrese valores numéricos válidos");
            sc.nextLine(); // Limpiar buffer en caso de error
        }
    }


    public static void consultarViajes() {
        System.out.println("\n--- VIAJES DISPONIBLES ---");
        System.out.println("ID      | Origen         | Destino       | Salida  | Precio  | Choferes");
        System.out.println("-----------------------------------------------------------------------");

        for (Viaje viaje : gestor.getViajes()) {
            System.out.printf("%-7s | %-14s | %-13s | %-7s | $%-6.2f | %s y %s%n",
                    viaje.getIdViaje(),
                    viaje.getInicio(),
                    viaje.getDestino(),
                    viaje.getHorarioPartida(),
                    viaje.getPrecio(),
                    viaje.getChofer1().getNombre(),
                    viaje.getChofer2().getNombre());
        }
    }

    private static void listarPasajeros() {
        System.out.println("\n--- PASAJEROS REGISTRADOS ---");
        System.out.println("DNI         | Nombre                | Teléfono   | Dirección");
        System.out.println("------------------------------------------------------------");

        for (Pasajero pasajero : gestor.getPasajeros()) {
            System.out.printf("%-11s | %-21s | %-10s | %s%n",
                    pasajero.getIdPasajero(),
                    pasajero.getNombrePasajero(),
                    pasajero.getTelefonoPasajero(),
                    pasajero.getDireccionPasajero());
        }

        System.out.println("\nTotal de pasajeros: " + gestor.getPasajeros().size());
    }

    private static void guardarDatos() {
        try {
            gestor.guardarPasajeros();
            gestor.guardarPasajes();
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}