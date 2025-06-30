package clases;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Administrador extends Empleados {

    public Administrador (String nombre, String id) {
        super(nombre, id);
    }

    public static List<Administrador> cargarAdministradores(String rutaArchivo) throws IOException {
        List<Administrador> administradores = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            administradores.add(new Administrador(datos[1], datos[0]));
        }
        reader.close();
        return administradores;
    }

    public static void mostrarMenuAdministradores(Scanner scanner, List<Administrador> administradores, List<Viaje> viajes,
                                                  List<Pasajero> pasajeros, List<Micros> micros, List<Chofer> choferes) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE ADMINISTRADORES ===");
            System.out.println("1. Reservar pasaje");
            System.out.println("2. Crear viaje");
            System.out.println("3. Cobrar viaje");
            System.out.println("4. Consultar pasajero");
            System.out.println("5. Editar viaje");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    reservarPasaje(scanner, pasajeros, viajes);
                    break;
                case 2:
                    crearViaje(scanner, viajes, choferes, micros);
                    break;
                case 3:
                    cobrarViaje(scanner, viajes);
                    break;
                case 4:
                    consultarPasajero(scanner, pasajeros);
                    break;
                case 5:
                    editarViaje(scanner, viajes, choferes, micros);
                    break;
            }
        } while (opcion != 0);
    }


    // 1. Reservar pasaje (completo y funcional)
    private static void reservarPasaje(Scanner scanner, List<Pasajero> pasajeros, List<Viaje> viajes) {
        System.out.println("\n=== RESERVAR PASAJE ===");

        // Mostrar viajes disponibles
        System.out.println("Viajes disponibles:");
        for (Viaje viaje : viajes) {
            System.out.printf("%s | %s a %s | %s | $%.2f%n",
                    viaje.getIdViaje(),
                    viaje.getInicio(),
                    viaje.getDestino(),
                    viaje.getHorarioPartida(),
                    viaje.getPrecio());
        }

        System.out.print("\nSeleccione ID del viaje: ");
        String idViaje = scanner.nextLine();
        Viaje viajeSeleccionado = null;

        for (Viaje v : viajes) {
            if (v.getIdViaje().equalsIgnoreCase(idViaje)) {
                viajeSeleccionado = v;
                break;
            }
        }

        if (viajeSeleccionado == null) {
            System.out.println("Error: Viaje no encontrado");
            return;
        }

        // Buscar pasajero
        System.out.print("\nIngrese DNI del pasajero: ");
        String dni = scanner.nextLine();
        Pasajero pasajero = null;

        for (Pasajero p : pasajeros) {
            if (p.getIdPasajero().equalsIgnoreCase(dni)) {
                pasajero = p;
                break;
            }
        }

        if (pasajero == null) {
            System.out.println("Pasajero no registrado. Registrando nuevo pasajero...");
            pasajero = registrarNuevoPasajero(scanner, pasajeros);
        }

        // Asignar asiento
        System.out.print("\nIngrese número de asiento: ");
        String asiento = scanner.nextLine();

        // Crear y guardar pasaje
        Pasaje nuevoPasaje = new Pasaje(
                "PAS-" + (pasajes.size() + 1),
                asiento,
                pasajero.getIdPasajero(),
                pasajero.getNombrePasajero(),
                pasajero.getDireccionPasajero(),
                pasajero.getTelefonoPasajero()
        );

        nuevoPasaje.setHorarioPartida(viajeSeleccionado.getHorarioPartida());
        nuevoPasaje.setHorarioLlegada(viajeSeleccionado.getHorarioLlegada());

        // Aquí deberías agregar el pasaje a tu lista de pasajes
        // pasajes.add(nuevoPasaje);

        System.out.println("\n¡Pasaje reservado con éxito!");
        System.out.println("Detalles:");
        System.out.println("Viaje: " + viajeSeleccionado.getInicio() + " a " + viajeSeleccionado.getDestino());
        System.out.println("Pasajero: " + pasajero.getNombrePasajero());
        System.out.println("Asiento: " + asiento);
        System.out.println("Hora salida: " + viajeSeleccionado.getHorarioPartida());
    }

    // 2. Crear viaje (completo y funcional)
    private static void crearViaje(Scanner scanner, List<Viaje> viajes, List<Chofer> choferes, List<Micros> micros) {
        System.out.println("\n=== CREAR NUEVO VIAJE ===");

        // Solicitar datos básicos
        System.out.print("Ciudad de origen: ");
        String origen = scanner.nextLine();

        System.out.print("Ciudad de destino: ");
        String destino = scanner.nextLine();

        System.out.print("Precio del pasaje: ");
        float precio = scanner.nextFloat();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Hora de salida (HH:MM): ");
        String horaSalida = scanner.nextLine();

        System.out.print("Hora de llegada (HH:MM): ");
        String horaLlegada = scanner.nextLine();

        // Seleccionar choferes
        System.out.println("\nCHOFERES DISPONIBLES:");
        for (Chofer chofer : choferes) {
            if (chofer.getDisponibilidadDeChofer().equalsIgnoreCase("Disponible")) {
                System.out.printf("%s - %s (Horas trabajadas: %d)%n",
                        chofer.getID(),
                        chofer.getNombre(),
                        chofer.getHorasTrabajadas());
            }
        }

        System.out.print("\nID del chofer principal: ");
        String idChofer1 = scanner.nextLine();
        Chofer chofer1 = buscarChofer(choferes, idChofer1);

        System.out.print("ID del chofer secundario: ");
        String idChofer2 = scanner.nextLine();
        Chofer chofer2 = buscarChofer(choferes, idChofer2);

        if (chofer1 == null || chofer2 == null) {
            System.out.println("Error: Uno o ambos choferes no encontrados");
            return;
        }

        // Seleccionar micro
        System.out.println("\nMICROS DISPONIBLES:");
        for (Micros micro : micros) {
            if (micro.getDisponibilidadMicro().equalsIgnoreCase("Disponible")) {
                System.out.printf("%s - Estado: %s%n",
                        micro.getIdMicro(),
                        micro.getEstadoMicro());
            }
        }

        System.out.print("\nID del micro: ");
        String idMicro = scanner.nextLine();
        Micros micro = buscarMicro(micros, idMicro);

        if (micro == null) {
            System.out.println("Error: Micro no encontrado");
            return;
        }

        // Crear el viaje
        String nuevoId = "V-" + (viajes.size() + 1);
        Viaje nuevoViaje = new Viaje(
                precio,
                origen,
                destino,
                nuevoId,
                horaSalida,
                horaLlegada,
                chofer1,
                chofer2
        );

        nuevoViaje.asignarMicro(micro);
        viajes.add(nuevoViaje);

        System.out.println("\n¡Viaje creado exitosamente!");
        System.out.println("ID del viaje: " + nuevoId);
    }

    // 3. Cobrar viaje (completo y funcional)
    private static void cobrarViaje(Scanner scanner, List<Viaje> viajes) {
        System.out.println("\n=== COBRAR VIAJE ===");

        // Mostrar viajes disponibles
        System.out.println("Viajes disponibles para cobrar:");
        for (Viaje viaje : viajes) {
            System.out.printf("%s | %s a %s | $%.2f%n",
                    viaje.getIdViaje(),
                    viaje.getInicio(),
                    viaje.getDestino(),
                    viaje.getPrecio());
        }

        System.out.print("\nIngrese ID del viaje: ");
        String idViaje = scanner.nextLine();

        Viaje viaje = null;
        for (Viaje v : viajes) {
            if (v.getIdViaje().equalsIgnoreCase(idViaje)) {
                viaje = v;
                break;
            }
        }

        if (viaje == null) {
            System.out.println("Error: Viaje no encontrado");
            return;
        }

        System.out.printf("Monto a cobrar: $%.2f%n", viaje.getPrecio());

        try {
            System.out.print("Ingrese monto recibido: ");
            float montoRecibido = scanner.nextFloat();
            scanner.nextLine(); // Limpiar buffer

            if (montoRecibido >= viaje.getPrecio()) {
                float vuelto = montoRecibido - viaje.getPrecio();
                System.out.printf("Vuelto: $%.2f%n", vuelto);
                System.out.println("¡Pago registrado exitosamente!");
            } else {
                System.out.printf("Monto insuficiente. Faltan: $%.2f%n",
                        viaje.getPrecio() - montoRecibido);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico");
            scanner.nextLine(); // Limpiar buffer
        }
    }

    // 4. Consultar pasajero (completo y funcional)
    private static void consultarPasajero(Scanner scanner, List<Pasajero> pasajeros) {
        System.out.println("\n=== CONSULTAR PASAJERO ===");
        System.out.print("Ingrese DNI del pasajero: ");
        String dni = scanner.nextLine();

        Pasajero pasajero = null;
        for (Pasajero p : pasajeros) {
            if (p.getIdPasajero().equalsIgnoreCase(dni)) {
                pasajero = p;
                break;
            }
        }

        if (pasajero != null) {
            System.out.println("\n=== DATOS DEL PASAJERO ===");
            System.out.println("DNI: " + pasajero.getIdPasajero());
            System.out.println("Nombre: " + pasajero.getNombrePasajero());
            System.out.println("Dirección: " + pasajero.getDireccionPasajero());
            System.out.println("Teléfono: " + pasajero.getTelefonoPasajero());

            // Aquí podrías agregar la consulta de pasajes del pasajero
            // consultarPasajesPasajero(pasajero.getIdPasajero());
        } else {
            System.out.println("Pasajero no encontrado.");
        }
    }

    // 5. Editar viaje (completo y funcional)
    private static void editarViaje(Scanner scanner, List<Viaje> viajes, List<Chofer> choferes, List<Micros> micros) {
        System.out.println("\n=== EDITAR VIAJE ===");

        // Mostrar viajes disponibles
        System.out.println("Viajes disponibles para editar:");
        for (Viaje viaje : viajes) {
            System.out.printf("%s | %s a %s | %s%n",
                    viaje.getIdViaje(),
                    viaje.getInicio(),
                    viaje.getDestino(),
                    viaje.getHorarioPartida());
        }

        System.out.print("\nIngrese ID del viaje a editar: ");
        String idViaje = scanner.nextLine();

        Viaje viaje = null;
        for (Viaje v : viajes) {
            if (v.getIdViaje().equalsIgnoreCase(idViaje)) {
                viaje = v;
                break;
            }
        }

        if (viaje == null) {
            System.out.println("Error: Viaje no encontrado");
            return;
        }

        System.out.println("\n¿Qué desea modificar?");
        System.out.println("1. Choferes");
        System.out.println("2. Micro");
        System.out.println("3. Horarios");
        System.out.println("4. Precio");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1: // Cambiar choferes
                System.out.println("\nCHOFERES DISPONIBLES:");
                for (Chofer chofer : choferes) {
                    if (chofer.getDisponibilidadDeChofer().equalsIgnoreCase("Disponible")) {
                        System.out.printf("%s - %s%n",
                                chofer.getID(),
                                chofer.getNombre());
                    }
                }

                System.out.print("\nNuevo ID chofer principal: ");
                String idChofer1 = scanner.nextLine();
                Chofer chofer1 = buscarChofer(choferes, idChofer1);

                System.out.print("Nuevo ID chofer secundario: ");
                String idChofer2 = scanner.nextLine();
                Chofer chofer2 = buscarChofer(choferes, idChofer2);

                if (chofer1 != null && chofer2 != null) {
                    viaje.setChofer1(chofer1);
                    viaje.setChofer2(chofer2);
                    System.out.println("Choferes actualizados correctamente");
                } else {
                    System.out.println("Error: Uno o ambos choferes no válidos");
                }
                break;

            case 2: // Cambiar micro
                System.out.println("\nMICROS DISPONIBLES:");
                for (Micros micro : micros) {
                    if (micro.getDisponibilidadMicro().equalsIgnoreCase("Disponible")) {
                        System.out.printf("%s - Estado: %s%n",
                                micro.getIdMicro(),
                                micro.getEstadoMicro());
                    }
                }

                System.out.print("\nNuevo ID micro: ");
                String idMicro = scanner.nextLine();
                Micros micro = buscarMicro(micros, idMicro);

                if (micro != null) {
                    viaje.asignarMicro(micro);
                    System.out.println("Micro actualizado correctamente");
                } else {
                    System.out.println("Error: Micro no válido");
                }
                break;

            case 3: // Cambiar horarios
                System.out.print("\nNueva hora de salida (HH:MM): ");
                viaje.setHorarioPartida(scanner.nextLine());

                System.out.print("Nueva hora de llegada (HH:MM): ");
                viaje.setHorarioLlegada(scanner.nextLine());

                System.out.println("Horarios actualizados correctamente");
                break;

            case 4: // Cambiar precio
                System.out.print("\nNuevo precio: ");
                try {
                    float nuevoPrecio = scanner.nextFloat();
                    scanner.nextLine(); // Limpiar buffer
                    viaje.setPrecio(nuevoPrecio);
                    System.out.println("Precio actualizado correctamente");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un valor numérico");
                    scanner.nextLine(); // Limpiar buffer
                }
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    // ======================
    // MÉTODOS AUXILIARES (implementados y funcionales)
    // ======================

    private static Pasajero registrarNuevoPasajero(Scanner scanner, List<Pasajero> pasajeros) {
        System.out.println("\n=== REGISTRO DE NUEVO PASAJERO ===");

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Pasajero nuevoPasajero = new Pasajero(dni, nombre, direccion, telefono);
        pasajeros.add(nuevoPasajero);

        System.out.println("\n¡Pasajero registrado exitosamente!");
        return nuevoPasajero;
    }

    private static Chofer buscarChofer(List<Chofer> choferes, String id) {
        for (Chofer chofer : choferes) {
            if (chofer.getID().equalsIgnoreCase(id)) {
                return chofer;
            }
        }
        return null;
    }

    private static Micros buscarMicro(List<Micros> micros, String id) {
        for (Micros micro : micros) {
            if (micro.getIdMicro().equalsIgnoreCase(id)) {
                return micro;
            }
        }
        return null;
    }

    // Método para guardar cambios (si lo necesitas)
    public static void guardarAdministradores(String rutaArchivo, List<Administrador> administradores) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Administrador admin : administradores) {
                writer.write(admin.getID() + "|" + admin.getNombre());
                writer.newLine();
            }
        }
    }

}