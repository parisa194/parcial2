import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        List<Cliente> listaClientes = new ArrayList<>();  // Lista para gestionar clientes

        // Agregar vehículos (como antes)
        admin.añadirVehiculo(new Auto("1", "Toyota", "Corolla", 2020, 30000, "Gasolina"));
        admin.añadirVehiculo(new Auto("2", "Honda", "Civic", 2021, 35000, "Gasolina"));
        admin.añadirVehiculo(new Auto("3", "Chevrolet", "Malibu", 2022, 32000, "Gasolina"));
        admin.añadirVehiculo(new Moto("4", "Yamaha", "MT-07", 2021, 20000, 689));
        admin.añadirVehiculo(new Moto("5", "Kawasaki", "Ninja 650", 2022, 25000, 649));
        admin.añadirVehiculo(new Moto("6", "Ducati", "Monster 797", 2021, 30000, 803));
        admin.añadirVehiculo(new Camioneta("7", "Ford", "F-150", 2022, 50000, 1000));
        admin.añadirVehiculo(new Camioneta("8", "Ram", "1500", 2023, 60000, 1200));
        admin.añadirVehiculo(new Camioneta("9", "Chevrolet", "Silverado", 2023, 55000, 1100));
        admin.añadirVehiculo(new Autobus("10", "Mercedes", "Sprinter", 2020, 80000, 15));
        admin.añadirVehiculo(new Autobus("11", "Iveco", "Crossway", 2020, 90000, 40));
        admin.añadirVehiculo(new Autobus("12", "Scania", "Citywide", 2021, 85000, 35));

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bienvenido a Systecar:");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Cliente");
            System.out.println("2. Administrador");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Ingrese su nombre: ");
                String nombreCliente = scanner.nextLine();

                System.out.print("Ingrese su ID de cliente: ");
                String idCliente = scanner.nextLine();

                // Verificar si el cliente ya existe
                Cliente cliente = buscarCliente(listaClientes, idCliente);
                if (cliente == null) {
                    cliente = new Cliente(idCliente, nombreCliente);
                    listaClientes.add(cliente);  // Añadir cliente a la lista si no existe
                }

                if (cliente.tieneReserva()) {
                    System.out.println("Ya tienes un vehículo alquilado. No puedes alquilar más.");
                } else {
                    System.out.println("\nVehículos disponibles:");
                    List<Vehiculo> vehiculosDisponibles = admin.listarVehiculosDisponibles();
                    for (Vehiculo vehiculo : vehiculosDisponibles) {
                        System.out.println(vehiculo);
                    }

                    System.out.print("Seleccione el ID del vehículo que desea alquilar: ");
                    String idVehiculo = scanner.nextLine();
                    Vehiculo vehiculoSeleccionado = null;
                    for (Vehiculo v : vehiculosDisponibles) {
                        if (v.idVehiculo.equals(idVehiculo)) {
                            vehiculoSeleccionado = v;
                            break;
                        }
                    }

                    if (vehiculoSeleccionado != null) {
                        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
                        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

                        int dias = 0;
                        boolean diasValidos = false;

                        while (!diasValidos) {
                            try {
                                System.out.print("Ingrese la duración del alquiler en días: ");
                                dias = scanner.nextInt();
                                scanner.nextLine();
                                if (dias <= 0) {
                                    System.out.println("La duración debe ser un número positivo. Intente de nuevo.");
                                } else {
                                    diasValidos = true;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada no válida. Por favor, ingrese un número entero positivo.");
                                scanner.nextLine();
                            }
                        }

                        LocalDate fechaFin = fechaInicio.plusDays(dias);

                        System.out.print("¿Desea agregar seguro? (si/no): ");
                        boolean seguro = scanner.nextLine().equalsIgnoreCase("si");

                        System.out.print("¿Desea agregar GPS? (si/no): ");
                        boolean gps = scanner.nextLine().equalsIgnoreCase("si");

                        cliente.reservarVehiculo(vehiculoSeleccionado, fechaInicio, fechaFin, seguro, gps);
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                }
            } else if (opcion == 2) {
                // Lógica del administrador (igual que antes)
            }

            System.out.print("\n¿Desea realizar otra acción? (si/no): ");
            String respuesta = scanner.next().toLowerCase();
            continuar = respuesta.equals("si");
        }

        System.out.println("Gracias por usar a Systecar. ¡Hasta luego!");
    }

    // Método para buscar un cliente por ID
    public static Cliente buscarCliente(List<Cliente> listaClientes, String idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }
}



