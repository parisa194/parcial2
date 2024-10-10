import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Vehiculo> flota;

    public Administrador() {
        flota = new ArrayList<>();
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
        System.out.println("Vehículo añadido: " + vehiculo);
    }

    public boolean verificarDisponibilidad(Vehiculo vehiculo) {
        return vehiculo.isDisponible();
    }

    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo v : flota) {
            if (v.isDisponible()) {
                disponibles.add(v);
            }
        }
        return disponibles;
    }
}