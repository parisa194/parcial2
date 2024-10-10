import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public boolean tieneReserva() {
        return !reservas.isEmpty();
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        Reserva nuevaReserva = new Reserva(this, vehiculo, fechaInicio, fechaFin);
        nuevaReserva.confirmarReserva(seguro, gps);
        reservas.add(nuevaReserva);
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdCliente() {
        return idCliente;
    }
}