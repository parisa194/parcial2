import java.time.LocalDate;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idReserva = cliente.getIdCliente() + "_" + fechaInicio;
    }

    public void confirmarReserva(boolean seguro, boolean gps) {
        this.costoTotal = vehiculo.calculatorPrecious((int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay()), seguro, gps);
        vehiculo.reservar();
        System.out.println("Reserva confirmada. Costo total: $" + costoTotal);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", cliente=" + cliente.getNombre() +
                ", vehiculo=" + vehiculo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", costoTotal=" + costoTotal +
                '}';
    }
}